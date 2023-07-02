package Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ingresogastos.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var bttnRegistrar: Button
    private lateinit var nombreEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passEditText: EditText
    private lateinit var confirmarpassEditText: EditText
    private lateinit var bttnIniciar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nombreEditText = findViewById(R.id.nombre)
        emailEditText = findViewById(R.id.email)
        passEditText = findViewById(R.id.pass)
        confirmarpassEditText = findViewById(R.id.confirmarpass)
        bttnIniciar = findViewById(R.id.bttniniciarsesion)
        bttnRegistrar = findViewById(R.id.bttnregistrar)

        bttnRegistrar.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val email = emailEditText.text.toString()
            val pass= passEditText.text.toString()
            val confirmarpass = confirmarpassEditText.text.toString()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


            // Aquí puedes agregar la lógica para validar el inicio de sesión
           /* if (nombre.isNotEmpty() && pass.isNotEmpty() && email.isNotEmpty() && confirmarpass.isNotEmpty()) {
                // Iniciar registro exitoso
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            } else {
                // Error de registro
                Toast.makeText(this, "Error: Ingresa el nombre y la contraseña", Toast.LENGTH_SHORT).show()
            }*/
        }

        bttnIniciar.setOnClickListener {
            // Aquí puedes agregar la lógica para abrir la pantalla de registro
            // Toast.makeText(this, "Abrir pantalla de registro", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}