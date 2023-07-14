package Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ConsumirApi {
    @GET("usuario/getUsuario")
    fun getUsuario(@Query("idUsuario") idUsuario: Int): Call<Usuario>

    @GET("operaciones/listar-egresos2")
    fun getEgresos(@Query("idUsuario") idUsuario: Int): Call<Operacion2>

    @GET("operaciones/listar-ingresos2")
    fun getIngresos(@Query("idUsuario") idUsuario: Int): Call<Operacion2>
}