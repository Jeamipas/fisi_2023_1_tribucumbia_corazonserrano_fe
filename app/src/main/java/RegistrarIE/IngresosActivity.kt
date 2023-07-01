package RegistrarIE

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.ingresogastos.R

class IngresosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_ingresos)
        val btnGastos = findViewById<AppCompatButton>(R.id.btnGastos)

        btnGastos.setOnClickListener {
            val intent = Intent(this, EgresosActivity::class.java)
            startActivity(intent)
        }
    }
}