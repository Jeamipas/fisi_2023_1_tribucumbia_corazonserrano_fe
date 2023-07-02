package Login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.ingresogastos.R

class LoginActivity : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var ingresarButton: Button
    private lateinit var registrarButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnIngresar= findViewById<AppCompatButton>(R.id.bttn_ingresar)
        val btnRegistrar = findViewById<AppCompatButton>(R.id.bttn_registrar)
        nombreEditText = findViewById(R.id.nombre)
        passwordEditText = findViewById(R.id.password)


        /*
        ingresarButton = findViewById(R.id.bttn_ingresar)
        registrarButton = findViewById<AppCompatButton>(R.id.bttn_registrar)
        */

        btnIngresar.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Aquí puedes agregar la lógica para validar el inicio de sesión
            if (nombre.isNotEmpty() && password.isNotEmpty()) {
                // Iniciar sesión exitoso
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            } else {
                // Error de inicio de sesión
                Toast.makeText(this, "Error: Ingresa el nombre y la contraseña", Toast.LENGTH_SHORT).show()
            }
        }


        btnRegistrar.setOnClickListener {
            // Aquí puedes agregar la lógica para abrir la pantalla de registro
            // Toast.makeText(this, "Abrir pantalla de registro", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }



}
