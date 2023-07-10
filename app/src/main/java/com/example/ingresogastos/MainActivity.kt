package com.example.ingresogastos

import Configuracion.Confiprincipal
import Notificacion.pantallaNotificaciones
import PantallaRecomendaciones.pantallaRecomendacionesBot
import RegistrarIE.IngresosActivity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.google.android.material.progressindicator.LinearProgressIndicator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val configuracion = findViewById<Button>(R.id.button_options)
        val agregar = findViewById<Button>(R.id.button_more)
        val notificaciones = findViewById<Button>(R.id.button_notifications)
        val recomendaciones = findViewById<TextView>(R.id.textViewRecomendacion)

        configuracion.setOnClickListener {
            val intent = Intent(this, Confiprincipal::class.java)
            startActivity(intent)
        }
        agregar.setOnClickListener {
            val intent = Intent(this, IngresosActivity::class.java)
            startActivity(intent)
        }
        notificaciones.setOnClickListener {
            val intent = Intent(this, pantallaNotificaciones::class.java)
            startActivity(intent)
        }
        recomendaciones.setOnClickListener {
            val intent = Intent(this, pantallaRecomendacionesBot::class.java)
            startActivity(intent)
        }

        val linearProgressIndicator: LinearProgressIndicator = findViewById(R.id.linearProgressIndicator)
        linearProgressIndicator.progress = 80

        val pieChartIncomes: PieChart = findViewById(R.id.pieChartIncomes)

        val incomes = listOf(
            PieEntry(47.62f, "Salario"),
            PieEntry(9.5f, "Alquiler"),
            PieEntry(4.76f, "Otros"),
            PieEntry(9.5f, "Inversiones"),
            PieEntry(9.5f, "Subvenciones"),
            PieEntry(19f, "Bonificaciones")


        )
        val colors = listOf(
            ContextCompat.getColor(this, R.color.Salario),
            ContextCompat.getColor(this, R.color.Alquiler),
            ContextCompat.getColor(this, R.color.Otros),
            ContextCompat.getColor(this, R.color.Inversiones),
            ContextCompat.getColor(this, R.color.Subvenciones),
            ContextCompat.getColor(this, R.color.Bonificaciones)
        )

        val dataSet = PieDataSet(incomes, "Gráfico Circular")
        dataSet.colors = colors

        dataSet.valueTextSize= 16f

        val data = PieData(dataSet)
        pieChartIncomes.data = data
        pieChartIncomes.description.isEnabled = false
        pieChartIncomes.legend.isEnabled = false
        pieChartIncomes.centerText="S/.10 500"
        pieChartIncomes.setCenterTextSize(16f)

        pieChartIncomes.invalidate() // Actualiza el gráfico

        val pieChartExpenses: PieChart = findViewById(R.id.pieChartExpenses)

        val expenses = listOf(
            PieEntry(47.62f, "Vivienda"),
            PieEntry(9.5f, "Transporte"),
            PieEntry(4.76f, "Gastos Médicos"),
            PieEntry(9.5f, "Otros"),
            PieEntry(9.5f, "Entretenimiento"),
            PieEntry(19f, "Comida")

        )

        val dataSetExpenses = PieDataSet(expenses, "Gráfico Circular")
        dataSetExpenses.colors = colors

        dataSetExpenses.valueTextSize= 16f

        val dataExpenses = PieData(dataSetExpenses)
        pieChartExpenses.data = dataExpenses
        pieChartExpenses.description.isEnabled = false
        pieChartExpenses.legend.isEnabled = false
        pieChartExpenses.centerText="S/.5 800"
        pieChartExpenses.setCenterTextSize(16f)

        pieChartExpenses.invalidate() // Actualiza el gráfico

        // Obtener referencia al TextView en el archivo de diseño
        val textView: TextView = findViewById(R.id.textView)

        // Texto de bienvenida y nombre
        val welcomeText = "¡Bienvenido, "
        val nameText = "Bruno!"

        // Crear un SpannableStringBuilder para aplicar estilos al texto
        val spannableStringBuilder = SpannableStringBuilder(welcomeText + nameText)

        // Aplicar el estilo en negrita al texto de bienvenida
        spannableStringBuilder.setSpan(
            StyleSpan(Typeface.BOLD),  // Estilo en negrita
            0,                        // Índice de inicio del texto de bienvenida
            welcomeText.length,       // Índice de fin del texto de bienvenida
            SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE  // Bandera de exlusividad
        )

        // Establecer el SpannableStringBuilder en el TextView
        textView.text = spannableStringBuilder
    }
}