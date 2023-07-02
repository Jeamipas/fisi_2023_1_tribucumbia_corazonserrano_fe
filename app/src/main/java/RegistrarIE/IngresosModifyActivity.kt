package RegistrarIE

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.ingresogastos.R

class IngresosModifyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_ingresos_modify)
        val btnEditar = findViewById<AppCompatButton>(R.id.btnEditar)
        val btnEliminar = findViewById<AppCompatButton>(R.id.btnEliminar)

        btnEditar.setOnClickListener {
            val intent = Intent(this, IngresosPopWindowActivity::class.java)
            startActivity(intent)
        }

        btnEliminar.setOnClickListener {
            val intent = Intent(this, IngresosEliminarPopWindowActivity::class.java)
            startActivity(intent)
        }
    }
}