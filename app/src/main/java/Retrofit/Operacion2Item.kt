package Retrofit

data class Operacion2Item(
    val categoria: String,
    val fechaReal: String,
    val fechaRegistro: String,
    val futuro: Boolean,
    val idOperacion: Int,
    val monto: Double,
    val nombre: String,
    val tipoie: String,
    val usuario: Usuario
)