package Configuracion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.R

class Infopantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vm_informacion_config)
        val btnregrd = findViewById<AppCompatImageButton>(R.id.btnregrd)
        btnregrd.setOnClickListener {
            val intent = Intent(this, Confiprincipal::class.java)
            startActivity(intent)
        }
    }
}