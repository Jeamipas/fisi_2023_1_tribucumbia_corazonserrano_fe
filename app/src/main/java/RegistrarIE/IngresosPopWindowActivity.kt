package RegistrarIE

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class IngresosPopWindowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_ingresos_pop_window)

        val btnFecha = findViewById<AppCompatImageButton>(R.id.btnFecha)
        val fecha = findViewById<EditText>(R.id.fecha)

        var btnFechaSelected = false
        var fechaSelected = false

        fun checkSelection(){
            if (btnFechaSelected || fechaSelected) {
                // Obtener la fecha actual para establecerla como fecha predeterminada en el DatePicker
                val currentDate = Calendar.getInstance()
                val year = currentDate.get(Calendar.YEAR)
                val month = currentDate.get(Calendar.MONTH)
                val day = currentDate.get(Calendar.DAY_OF_MONTH)

                // Crear un DatePickerDialog para permitir al usuario seleccionar una fecha
                val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(selectedYear, selectedMonth, selectedDay)

                    val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDate.time)
                    fecha.setText(formattedDate)
                }, year, month, day)

                datePickerDialog.show()
            }
        }

        btnFecha.setOnClickListener {
            btnFechaSelected = true
            checkSelection()
        }

        fecha.setOnClickListener {
            fechaSelected = true
            checkSelection()
        }
    }
}