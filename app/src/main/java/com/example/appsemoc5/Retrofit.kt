package com.example.appsemoc5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SemocApiService {
    @GET("minicursos.json")
    suspend fun getMinicursos(): List<Minicurso>

    @GET("palestras.json")
    suspend fun getPalestras(): List<Palestra>

    @GET("pessoas.json")
    suspend fun getPessoas(): List<Pessoa>
}

object RetrofitInstance {
    val api: SemocApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/ucsal/semoc/main/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SemocApiService::class.java)
    }
}
