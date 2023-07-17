package PantallaRecomendaciones

data class RecomendacionRequest(
    val pronostico: List<Double>,
    val real: List<Double>,
    val recomendacion: String
)