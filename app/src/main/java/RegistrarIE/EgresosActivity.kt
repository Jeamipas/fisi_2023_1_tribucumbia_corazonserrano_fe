package RegistrarIE

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.example.ingresogastos.R
import com.google.android.material.button.MaterialButton

class EgresosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_egresos)
        val btnACategoria = findViewById<AppCompatButton>(R.id.btnACategoria)

        btnACategoria.setOnClickListener {
            val intent = Intent(this, CategoriaPopWindowActivity::class.java)
            startActivity(intent)
        }

    }
}