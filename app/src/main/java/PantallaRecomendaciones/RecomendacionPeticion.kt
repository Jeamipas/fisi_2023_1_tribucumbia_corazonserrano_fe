package PantallaRecomendaciones

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RecomendacionPeticion {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.10:5000/ux-recomendaciones/appww/servicio-al-cliente/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    public val service = retrofit.create(RecomendacionInterface::class.java)

}