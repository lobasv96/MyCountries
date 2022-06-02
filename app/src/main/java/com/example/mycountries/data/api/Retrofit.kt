package com.example.mycountries.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private const val BASE_URL = "https://restcountries.com/v2/"

     private val retrofit = Retrofit.Builder()
         .addConverterFactory(GsonConverterFactory.create())
         .baseUrl(BASE_URL)
         .build()

    val service: GetCountriesApi = retrofit.create(GetCountriesApi::class.java)
        // переменная service реализует данный интерфейс - ApiService,
        // за счет того что мы передали ссылку на данный интефрейс
        // то есть у этой переменной мы можем вызывать такую функцию - fun getCountriesByName
        // и другие, если бы они были в интерфейсе

}