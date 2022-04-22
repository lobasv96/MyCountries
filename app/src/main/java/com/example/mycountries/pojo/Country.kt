package com.example.mycountries.pojo

import android.widget.ImageView
import java.util.*

data class Country (
    val name: String,
    val capital: String,
    val region: String,
    val population: Long,
    val area: Long,
    val languages: List<Language>,
    val currencies: List<Currency>,
    val flag: String
        )

data class Language (
    val name: String
        )
data class Currency (
    val name: String
        )


