package Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.10:8080/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi = retrofit.create(ConsumirApi::class.java)
}