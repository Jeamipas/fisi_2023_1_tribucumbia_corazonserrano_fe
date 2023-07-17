package Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ConsumirApi {
    @GET("ux-gestion-usuarios/appww/servicio-al-cliente/v1/obtener-datos-usuario")
    fun getUsuario(@Query("idUsuario") idUsuario: Int): Call<Usuario>

    @GET("ux-operaciones/appww/servicio-al-cliente/v1/listar-gastos")
    fun getEgresos(@Query("idUsuario") idUsuario: Int): Call<Operacion2>

    @GET("ux-operaciones/appww/servicio-al-cliente/v1/listar-ingresos")
    fun getIngresos(@Query("idUsuario") idUsuario: Int): Call<Operacion2>
}