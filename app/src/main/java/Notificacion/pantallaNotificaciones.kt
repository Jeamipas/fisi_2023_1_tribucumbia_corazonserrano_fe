package Notificacion

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.ingresogastos.R

class pantallaNotificaciones : AppCompatActivity() {

    private val CHANNEL_ID = "MiCanalDeNotificaciones"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_notificaciones)

        // Crear canal de notificación (solo necesario para Android Oreo y versiones superiores)
        createNotificationChannel()

        // Lógica para comprobar si se ha superado el límite de gastos
        val limiteGastos = 1000 // Definir el límite de gastos permitido
        val gastosActuales = 1200 // Obtener los gastos actuales del usuario

        if (gastosActuales > limiteGastos) {
            // Mostrar notificación de que se ha superado el límite de gastos
            showNotification()
        }
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

    private fun showNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Límite de gastos superado")
            .setContentText("Has superado tu límite de gastos permitido")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            // Notificar al usuario
            notify(0, builder.build())
        }
    }
}
