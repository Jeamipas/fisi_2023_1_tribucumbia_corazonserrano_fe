package RegistrarIE

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat
import com.example.ingresogastos.MainActivity
import com.example.ingresogastos.R

class IngresosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_ingresos)
        val btnGastos = findViewById<AppCompatButton>(R.id.btnGastos)
        val btnACategoria = findViewById<AppCompatButton>(R.id.btnACategoria)
        val barra = findViewById<View>(R.id.barra)
        val btnHome = findViewById<AppCompatImageButton>(R.id.btnHome)
        val btnSettings = findViewById<AppCompatImageButton>(R.id.btnSettings)
        val btnCancelar = findViewById<AppCompatImageButton>(R.id.btnCancelar)
        val btnEditar = findViewById<AppCompatImageButton>(R.id.btnEditar)
        val btnEliminar = findViewById<AppCompatImageButton>(R.id.btnEliminar)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnGastos.setOnClickListener {
            val intent = Intent(this, CategoriaPopWindowActivity::class.java)
            startActivity(intent)
        }

        btnACategoria.setOnClickListener {
            val intent = Intent(this, IngresosEliminarPopWindowActivity::class.java)
            startActivity(intent)
        }

        barra.setOnTouchListener(object : View.OnTouchListener {
            private val longPressDuration = 1000 // Duración de 1 segundo en milisegundos
            private var longPressTimer: CountDownTimer? = null

            override fun onTouch(view: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        longPressTimer = object : CountDownTimer(longPressDuration.toLong(), longPressDuration.toLong()) {
                            override fun onTick(millisUntilFinished: Long) {
                                // No se utiliza
                            }

                            override fun onFinish() {
                                barra.setBackgroundColor(Color.parseColor("#059561"))
                                btnHome.visibility = View.GONE
                                btnSettings.visibility = View.GONE
                                btnCancelar.visibility = View.VISIBLE
                                btnEditar.visibility = View.VISIBLE
                                btnEliminar.visibility = View.VISIBLE
                            }
                        }
                        longPressTimer?.start()
                    }
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        longPressTimer?.cancel()
                    }
                }
                return true
            }
        })

        btnCancelar.setOnClickListener {
            barra.setBackgroundColor(Color.parseColor("#123946"))
            btnHome.visibility = View.VISIBLE
            btnSettings.visibility = View.VISIBLE
            btnCancelar.visibility = View.GONE
            btnEditar.visibility = View.GONE
            btnEliminar.visibility = View.GONE
        }

        btnEditar.setOnClickListener {
            val intent = Intent(this, IngresosPopWindowActivity::class.java)
            startActivity(intent)
        }

        btnEditar.setOnClickListener {
            val intent = Intent(this, IngresosEliminarPopWindowActivity::class.java)
            startActivity(intent)
        }
    }
}