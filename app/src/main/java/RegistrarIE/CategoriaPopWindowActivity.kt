package RegistrarIE

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.widget.AppCompatButton
import com.example.ingresogastos.R

class CategoriaPopWindowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ie_activity_categoria_pop_window)

        val buttonAceptar = findViewById<AppCompatButton>(R.id.buttonAceptar)

        buttonAceptar.setOnClickListener {
            val intent = Intent(this, IngresosActivity::class.java)
            startActivity(intent)
        }

    }
}