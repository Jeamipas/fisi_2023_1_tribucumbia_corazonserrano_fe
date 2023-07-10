package Login

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.ingresogastos.R

class RegisterActivity : AppCompatActivity() {


    private lateinit var nombreEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passEditText: EditText
    private lateinit var confirmarpassEditText: EditText
    private lateinit var nombreUserEditText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nombreEditText = findViewById(R.id.id)
        emailEditText = findViewById(R.id.email)
        passEditText = findViewById(R.id.pass)
        confirmarpassEditText = findViewById(R.id.confirmarpass)
        nombreUserEditText = findViewById(R.id.nombreUser)

        val btnIniciar= findViewById<AppCompatButton>(R.id.bttniniciarsesion)
        val btnRegistro = findViewById<AppCompatButton>(R.id.bttnregistrar)

        btnRegistro.setOnClickListener {
            val nombre = nombreEditText.text.toString()
            val email = emailEditText.text.toString()
            val pass= passEditText.text.toString()
            val confirmarpass = confirmarpassEditText.text.toString()
            val nombreUser = nombreUserEditText.text.toString()


            val nombreValido = validarNombre(nombre)
            val emailValido = validarEmail(email)
            val passValido = validarPass(pass)
            val confirmarpassValido = validarConfirmarpassword(confirmarpass)
            val nombreUserValido = validarNombreUser(nombreUser)
            val coincidirPassword = validarCoincidenciaPassword(pass,confirmarpass)


            if (nombreValido && emailValido && passValido && confirmarpassValido && nombreUserValido && coincidirPassword) {
                // Iniciar sesión exitoso
                mostrarVentanaEmergenteValido()
                //Toast.makeText(this, "Usted ha sido registrado exitosamente", Toast.LENGTH_SHORT).show()

            }else {
                if(!coincidirPassword){
                    mostrarVentanaEmergentePassword()
                }
                else{
                    // Error de inicio de sesión
                    mostrarVentanaEmergenteError()
                    //Toast.makeText(this, "Error: Los datos ingresados son incorrectos", Toast.LENGTH_SHORT).show()
                }

            }
        }


        btnIniciar.setOnClickListener {
            // Aquí puedes agregar la lógica para abrir la pantalla de registro
            // Toast.makeText(this, "Abrir pantalla de registro", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validarNombre(nombre: String): Boolean {
        // Realiza la validación del nombre aquí y devuelve true si es válido, de lo contrario false
        // Puedes implementar tu lógica de validación según tus requerimientos
        // Por ejemplo, verificar si no está vacío o si cumple ciertas condiciones
        return !nombre.isEmpty()
    }

    private fun validarEmail(email: String): Boolean {
        // Realiza la validación del nombre aquí y devuelve true si es válido, de lo contrario false
        // Puedes implementar tu lógica de validación según tus requerimientos
        // Por ejemplo, verificar si no está vacío o si cumple ciertas condiciones
        return !email.isEmpty()
    }

    private fun validarPass(pass: String): Boolean {
        // Realiza la validación de la contraseña aquí y devuelve true si es válida, de lo contrario false
        // Puedes implementar tu lógica de validación según tus requerimientos
        // Por ejemplo, verificar si no está vacía o si cumple ciertas condiciones
        return pass.length >= 6
    }

    private fun validarConfirmarpassword(confirmarpass: String): Boolean {
        // Realiza la validación de la contraseña aquí y devuelve true si es válida, de lo contrario false
        // Puedes implementar tu lógica de validación según tus requerimientos
        // Por ejemplo, verificar si no está vacía o si cumple ciertas condiciones
        return confirmarpass.length >= 6
    }

    private fun validarCoincidenciaPassword(pass: String, confirmarpass: String): Boolean {
        return pass == confirmarpass
    }


    private fun validarNombreUser(nombre: String): Boolean {
        // Realiza la validación del nombre aquí y devuelve true si es válido, de lo contrario false
        // Puedes implementar tu lógica de validación según tus requerimientos
        // Por ejemplo, verificar si no está vacío o si cumple ciertas condiciones
        return !nombre.isEmpty()
    }

    private fun mostrarVentanaEmergenteValido() {
        // Crea un AlertDialog para mostrar la ventana emergente
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Registro validado")
        alertDialogBuilder.setMessage("Usted ha sido registrado exitosamente")
        val intent = Intent(this, LoginActivity::class.java)
        // Agrega un botón "Aceptar" en la ventana emergente
        alertDialogBuilder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, which ->
            // Acciones a realizar cuando se hace clic en el botón "Aceptar"
            startActivity(intent) // Cierra la ventana emergente
        })
        // Muestra la ventana emergente
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun mostrarVentanaEmergenteError() {
        // Crea un AlertDialog para mostrar la ventana emergente
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Error en Registro")
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

    private fun mostrarVentanaEmergentePassword() {
        // Crea un AlertDialog para mostrar la ventana emergente
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Error en Contraseña")
        alertDialogBuilder.setMessage("Error: Los contraseñas ingresados no coinciden. Vuelva a ingresar sus datos")

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