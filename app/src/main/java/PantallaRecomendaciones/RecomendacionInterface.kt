package PantallaRecomendaciones
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecomendacionInterface {
    @GET("obtener-recomendacion")
    fun getRecomendacion(@Query("idUsuario") idUsuario: Int): Call<RecomendacionRequest>
}