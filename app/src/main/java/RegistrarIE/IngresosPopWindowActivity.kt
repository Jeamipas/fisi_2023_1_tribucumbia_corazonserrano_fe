package RegistrarIE

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.R
import java.util.Calendar

class IngresosPopWindowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_ingresos_pop_window)

        val btnFecha = findViewById<AppCompatImageButton>(R.id.btnFecha)

        btnFecha.setOnClickListener {
            // Obtener la fecha actual para establecerla como fecha predeterminada en el DatePicker
            val currentDate = Calendar.getInstance()
            val year = currentDate.get(Calendar.YEAR)
            val month = currentDate.get(Calendar.MONTH)
            val day = currentDate.get(Calendar.DAY_OF_MONTH)

            // Crear un DatePickerDialog para permitir al usuario seleccionar una fecha
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                // El usuario ha seleccionado una fecha, haz algo con ella
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)

                // Realizar acciones adicionales con la fecha seleccionada
                // Por ejemplo, puedes mostrarla en un TextView
                /*val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDate.time)
                textView.text = formattedDate*/
            }, year, month, day)

            // Mostrar el DatePickerDialog
            datePickerDialog.show()
        }
    }
}