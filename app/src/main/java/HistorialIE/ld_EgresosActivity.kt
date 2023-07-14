package HistorialIE

import Configuracion.Confiprincipal
import Retrofit.RetrofitClient
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.MainActivity
import com.example.ingresogastos.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Calendar
import java.util.Locale
import kotlin.concurrent.thread
import java.util.Date


class ld_EgresosActivity : AppCompatActivity() {

    var matriz = arrayOf(
        arrayOf("Fecha","Nombre","Monto")

    )
    var tl_historial_egresos:TableLayout?=null

    //Nuevo code conexion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ld_egresoshistorial)
        tl_historial_egresos=findViewById(R.id.tl_historial_egresos)
        tl_historial_egresos?.removeAllViews()


        // Agregar los nuevos gastos a la matriz
        //var nuevoGasto1 = arrayOf("12-03-2023","Chifa","-S/.50.00")
        // matriz += nuevoGasto1

        var nuevoG = arrayOf("","","")

        thread {
            val operacion = RetrofitClient.consumirApi.getEgresos(1)
            val body = operacion.execute().body()
            runOnUiThread {

                if (body != null) {
                    for (i in body) {
                        val fechaRegistroSubstring = i.fechaRegistro.substring(0, 10)

                        Log.d("Id_EgresosActivity", "RecomendacionRequest count: $fechaRegistroSubstring")
                        Log.d("Id_EgresosActivity", "RecomendacionRequest count: ${i.nombre}")
                        Log.d("Id_EgresosActivity", "RecomendacionRequest count: ${i.monto}")

                        nuevoG = arrayOf(fechaRegistroSubstring, i.nombre, i.monto.toString())
                        matriz += nuevoG
                    }
                }


                else {
                    Log.d("Id_EgresosActivity", "RecomendacionRequest terrible")
                }
                for (i in (0 until matriz.count())) {
                    val registro =
                        LayoutInflater.from(this).inflate(R.layout.ld_tabla_egresos, null, false)
                    val fecha = registro.findViewById<View>(R.id.fecha) as TextView
                    val hora = registro.findViewById<View>(R.id.hora) as TextView
                    val monto = registro.findViewById<View>(R.id.monto) as TextView

                    fecha.text = matriz[i][0].toString()
                    hora.text = matriz[i][1].toString()
                    monto.text = matriz[i][2].toString()
                    tl_historial_egresos?.addView(registro)
                }
            }





        }

        llenarGraficoEgre()
        /*
                runOnUiThread
                {

                }*/


        //BOTON ATRAS
        val btnAtrasEgresos = findViewById<AppCompatImageButton>(R.id.iconoAtrasEgresos)
        btnAtrasEgresos.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val btnFecha = findViewById<AppCompatImageButton>(R.id.IngresosDesplegableDateEgresos)
        //val fecha = findViewById<EditText>(R.id.fecha)

        var btnFechaSelected = false

        fun checkSelection(){
            if (btnFechaSelected) {
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
                }, year, month, day)
                //fecha.setText(formattedDate)
                datePickerDialog.show()
            }
        }

        btnFecha.setOnClickListener {
            btnFechaSelected = true
            checkSelection()
        }

        /*fecha.setOnClickListener {
            fechaSelected = true
            checkSelection()
        }*/
    }

    private fun llenarGraficoEgre(){

        val lineChartIncomes: LineChart = findViewById(R.id.lineChartEgre)

        val xvalue = ArrayList<String>()
        val fechaInicial = "07/02" // Fecha inicial en formato "dd/MM"
        val formatoFecha = SimpleDateFormat("dd/MM", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.time = formatoFecha.parse(fechaInicial) // Convertir fecha inicial a objeto Date
        xvalue.add(fechaInicial)
        val diasMes = calcularDiasMes()
        var fecha = ""
        for(i in 1 until 4){
            calendar.add(Calendar.DAY_OF_MONTH, 7) // Agregar 7 días
            fecha = formatoFecha.format(calendar.time) // Convertir objeto Date a formato "dd/MM"
            for(j in 1..6){
                xvalue.add("")
            }
            xvalue.add(fecha)
        }
        for(i in 1..diasMes-22){
            xvalue.add("")
        }
        calendar.add(Calendar.DAY_OF_MONTH, diasMes-21) // Agregar 7 días
        fecha = formatoFecha.format(calendar.time)
        xvalue.add(fecha)
        val lineentry = ArrayList<Entry>();
        for (i in 1..diasMes){
            lineentry.add(Entry(i*1f,20f))
        }

        val linedataset = LineDataSet(lineentry,"First")
        linedataset.color = resources.getColor(R.color.black)

        val data = LineData(linedataset)

        lineChartIncomes.data = data
        lineChartIncomes.setBackgroundColor(Color.parseColor("#BEFBF4"))
        lineChartIncomes.animateXY(1000,1000)
        lineChartIncomes.invalidate()


    }
    private fun calcularDiasMes(): Int{
        val calendar = Calendar.getInstance()
        val mesActual = calendar.get(Calendar.MONTH)
        val anioActual = calendar.get(Calendar.YEAR)
        calendar.set(anioActual, mesActual, 1) // Establecer el primer día del mes actual
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    }

}