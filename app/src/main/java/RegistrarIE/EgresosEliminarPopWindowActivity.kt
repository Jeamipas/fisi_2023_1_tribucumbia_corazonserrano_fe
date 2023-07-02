package RegistrarIE

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.MainActivity
import com.example.ingresogastos.R

class EgresosEliminarPopWindowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_egresos_eliminar_pop_window)

        val botonCancelar = findViewById<AppCompatImageButton>(R.id.botonCancelar)
        val botonAceptar = findViewById<AppCompatImageButton>(R.id.botonAceptar)

        botonCancelar.setOnClickListener {
            val intent = Intent(this, EgresosActivity::class.java)
            startActivity(intent)
        }
    }
}