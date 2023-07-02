package Configuracion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.R

class Ayudapantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vm_ayuda_config)
        val btnregresar = findViewById<AppCompatImageButton>(R.id.btnregresar)
        btnregresar.setOnClickListener {
            val intent = Intent(this, Confiprincipal::class.java)
            startActivity(intent)
        }
    }
}