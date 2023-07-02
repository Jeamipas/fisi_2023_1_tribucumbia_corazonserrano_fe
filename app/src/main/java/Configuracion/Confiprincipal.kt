package Configuracion

import Login.LoginActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import com.example.ingresogastos.MainActivity
import com.example.ingresogastos.R

class Confiprincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vm_principal_config)
        val close = findViewById<AppCompatImageButton>(R.id.close)
        val cerrars = findViewById<AppCompatButton>(R.id.cerrars)
        val btninfor = findViewById<AppCompatButton>(R.id.btninfor)
        val btnhelp = findViewById<AppCompatButton>(R.id.btnhelp)
        close.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        cerrars.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btninfor.setOnClickListener {
            val intent = Intent(this, Infopantalla::class.java)
            startActivity(intent)
        }
        btnhelp.setOnClickListener {
            val intent = Intent(this, Ayudapantalla::class.java)
            startActivity(intent)
        }
    }
}
