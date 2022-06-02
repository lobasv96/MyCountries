package com.example.mycountries.data.api

import androidx.lifecycle.LiveData
import com.example.mycountries.domain.pojo.Country
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCountriesApi {
    @GET("name/{name}")
    suspend fun getCountriesByName(@Path("name") cityName: String) : List<Country>
}