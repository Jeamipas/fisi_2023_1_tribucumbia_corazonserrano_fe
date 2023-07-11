package Notificacion

import Configuracion.Confiprincipal
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.widget.TextView
import com.example.ingresogastos.MainActivity
import com.example.ingresogastos.R
import java.text.SimpleDateFormat
import java.util.*

class pantallaNotificaciones : AppCompatActivity() {

    private val CHANNEL_ID = "MiCanalDeNotificaciones"
    private val NOTIFICATION_ID = 0
    private val PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_notificaciones)

        val cerrar=findViewById<View>(R.id.cerrar)
        cerrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        // Crear canal de notificación (solo necesario para Android Oreo y versiones superiores)
        createNotificationChannel()

        // Obtener la fecha actual
        val currentDate = getCurrentDate()

        // Definir los mensajes de notificación basados en la fecha actual
        val notificationMessage = when (currentDate) {
            getCurrentDate() -> "¡Felicitaciones! 🚀 Usted ha ahorrado S/. 450. En su periodo propuesto de 1 mes!"
            getPreviousDate(1) -> "¡Aguanteee! 😥 Le queda menos de la mitad del presupuesto asignado."
            getPreviousDate(2) -> "Atento 🫡 El tiempo de presupuesto asignado expira en dos días"
            getPreviousDate(5) -> "¡Alerta, no ahorro nada! 😡 El tiempo asignado al presupuesto ha expirado, lastimosamente no pudo generar ningún ahorro."
            getPreviousDate(7) -> "Ojito 👀 Le quedan solo S/.500 de su presupuesto asignado."
            else -> ""
        }

        // Mostrar la notificación si el mensaje no está vacío
        if (notificationMessage.isNotEmpty()) {
            // Verificar si se tienen los permisos necesarios
            if (hasNotificationPermission()) {
                // Se tienen los permisos, mostrar la notificación
                showNotification(notificationMessage)
            } else {
                // No se tienen los permisos, solicitarlos al usuario
                requestNotificationPermission()
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }

    @SuppressLint("SimpleDateFormat")
    private fun getPreviousDate(days: Int): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, -days)
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    private fun createNotificationChannel() {
        // Solo es necesario para Android Oreo y versiones superiores
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Mi Canal de Notificaciones"
            val descriptionText = "Canal de notificaciones para informar sobre límite de gastos"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Registrar el canal de notificación en el sistema
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification(message: String) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle("Límite de gastos superado")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        try {
            with(NotificationManagerCompat.from(this)) {
                // Notificar al usuario
                notify(NOTIFICATION_ID, builder.build())
            }
        } catch (e: SecurityException) {
            // Manejar la excepción en caso de que se produzca un error de permiso
            e.printStackTrace()
        }
    }

    private fun hasNotificationPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestNotificationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
            PERMISSION_REQUEST_CODE
        )
    }
}
