package PantallaRecomendaciones

import android.content.Intent
import android.graphics.Color
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ingresogastos.MainActivity
import com.example.ingresogastos.R
import com.github.mikephil.charting.charts.PieChart
import java.text.SimpleDateFormat
import java.util.*
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.charts.LineChart
import kotlin.concurrent.thread

class pantallaRecomendacionesBot : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_recomendaciones_bot)
        val botonRegresar = findViewById<Button>(R.id.button)
        botonRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        llenarSaldoActual()
        llenarTextProgreso()
        llenarRecomendacion()

    }


    private fun llenarSaldoActual(){
        val saldo = 10000-4442
        var textViewSaldo: TextView= findViewById(R.id.editTextText)
        textViewSaldo.text = "Su saldo actual es de S/. $saldo"
    }

    private fun llenarTextProgreso(){
        val saldo = 10000-4442
        val presupuesto = 10000
        val gasto = presupuesto - saldo
        var textViewSaldo: TextView= findViewById(R.id.textProgressBar)
        textViewSaldo.text = "S/. $gasto de S/. $presupuesto gastados"
    }
    private fun obtenerRecomendación(id:Int):String{
        thread {
            val recomendacion = RecomendacionPeticion.service.getRecomendacion(id)
            val body = recomendacion.execute().body()
            runOnUiThread {
                if (body != null) {
                    var textRecomendacion: TextView = findViewById(R.id.textViewRecomendacion)
                    textRecomendacion.text = body.recomendacion
                    Log.d("pantallaRecomendacionesBot", "RecomendacionRequest count:${body.recomendacion}" )
                    llenarGraficoProgreso(body.pronostico, body.real)
                } else{
                    Log.d("pantallaRecomendacionesBot", "RecomendacionRequest terrible" )
                }
            }
        }

        return "hola"
    }
    private fun llenarRecomendacion(){
        obtenerRecomendación(1)
        val recomendacion = "No existe hay ninguna recomendación para usted"
    }

    private fun llenarGraficoProgreso(pron:List<Double>,real:List<Double>){

        val lineChartIncomes: LineChart = findViewById(R.id.lineChart)

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
        for (i in 1..pron.size){
            lineentry.add(Entry(i*1f,pron[i-1].toFloat()))
        }

        val linedataset = LineDataSet(lineentry,"First")
        linedataset.setDrawValues(false); // Desactiva las etiquetas de los puntos
        linedataset.color = resources.getColor(R.color.black)

        val data = LineData(linedataset)

        lineChartIncomes.data = data
        lineChartIncomes.setBorderColor(R.color.black)
        lineChartIncomes.setGridBackgroundColor(Color.parseColor("#BEFBF4"))
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