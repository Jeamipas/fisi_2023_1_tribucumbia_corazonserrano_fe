package Login

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.ingresogastos.R
import com.example.ingresogastos.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var passwordEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnIngresar = findViewById<AppCompatButton>(R.id.bttn_ingresar)
        val btnRegistrar = findViewById<AppCompatButton>(R.id.bttn_registrar)
        nombreEditText = findViewById(R.id.id)
        passwordEditText = findViewById(R.id.password)


        btnIngresar.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val password = passwordEditText.text.toString()

            //Realiza la validacion

            val nombreValido = validarNombre(nombre)
            val passwordValido = validarPassword(password)


            if (nombreValido && passwordValido) {
                // Iniciar sesión exitoso
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }else {
                // Error de inicio de sesión
                mostrarVentanaEmergente()
                //Toast.makeText(this, "Error: Los datos ingresados son incorrectos", Toast.LENGTH_SHORT).show()
            }

        }

        btnRegistrar.setOnClickListener {
            // Aquí puedes agregar la lógica para abrir la pantalla de registro
            // Toast.makeText(this, "Abrir pantalla de registro", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
            private fun validarNombre(nombre: String): Boolean {
                // Realiza la validación del nombre aquí y devuelve true si es válido, de lo contrario false
                // Puedes implementar tu lógica de validación según tus requerimientos
                // Por ejemplo, verificar si no está vacío o si cumple ciertas condiciones
                return !nombre.isEmpty()
            }

            private fun validarPassword(password: String): Boolean {
                // Realiza la validación de la contraseña aquí y devuelve true si es válida, de lo contrario false
                // Puedes implementar tu lógica de validación según tus requerimientos
                // Por ejemplo, verificar si no está vacía o si cumple ciertas condiciones
                return password.length >= 6
            }

            private fun mostrarVentanaEmergente() {
                // Crea un AlertDialog para mostrar la ventana emergente
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Error")
                alertDialogBuilder.setMessage("Error: Los datos ingresados son incorrectos. Vuelva a ingresar sus datos")

                // Agrega un botón "Aceptar" en la ventana emergente
                alertDialogBuilder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
                    // Acciones a realizar cuando se hace clic en el botón "Aceptar"
                    dialog.dismiss() // Cierra la ventana emergente
                })
                // Muestra la ventana emergente
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
}

