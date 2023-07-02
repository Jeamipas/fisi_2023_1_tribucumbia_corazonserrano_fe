package RegistrarIE

import Configuracion.Confiprincipal
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.MainActivity
import com.example.ingresogastos.R

class Egresos2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egresos2)
        val btnACategoria = findViewById<AppCompatButton>(R.id.btnACategoria)
        val btnIngresos = findViewById<AppCompatButton>(R.id.buttonIngresos)
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

        btnSettings.setOnClickListener {
            val intent = Intent(this, Confiprincipal::class.java)
            startActivity(intent)
        }

        btnIngresos.setOnClickListener {
            val intent = Intent(this, IngresosActivity::class.java)
            startActivity(intent)
        }

        btnACategoria.setOnClickListener {
            val intent = Intent(this, CategoriaPopWindowActivity::class.java)
            startActivity(intent)
        }

        btnEditar.setOnClickListener{
            val intent = Intent(this, EgresosPopWindowActivity::class.java)
            startActivity(intent)
        }

        btnEliminar.setOnClickListener{
            val intent = Intent(this, EgresosEliminarPopWindowActivity::class.java)
            startActivity(intent)
        }

        btnCancelar.setOnClickListener {
            barra.setBackgroundColor(Color.parseColor("#123946"))
            btnHome.visibility = View.VISIBLE
            btnSettings.visibility = View.VISIBLE
            btnCancelar.visibility = View.GONE
            btnEditar.visibility = View.GONE
            btnEliminar.visibility = View.GONE
        }

        barra.setOnTouchListener(object : View.OnTouchListener {
            private val longPressDuration = 1000 // DuraciÃ³n de 1 segundo en milisegundos
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

    }
}