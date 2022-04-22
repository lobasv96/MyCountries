package com.example.mycountries.api

import com.example.mycountries.pojo.Country
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("name/{name}")
    suspend fun getCountriesByName(@Path("name") cityName: String) : List<Country>
}