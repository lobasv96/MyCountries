package com.example.mycountries

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import com.example.mycountries.pojo.Currency
import com.example.mycountries.pojo.Language
import com.squareup.picasso.Picasso
import java.text.NumberFormat

class CountriesViewModel(application: Application) : AndroidViewModel(application) {

    fun converterListLanguageToString(languages: List<Language>): String {
        // метод для конвертации массива в строку
        return languages.joinToString { it.name }
    }

    fun converterListCurrencyToString(currencies: List<Currency>): String {
        return currencies.joinToString { it.name }
    }

    fun formatNumber(number: Long): String {
        //метод для красивого разбития числа разряды
        val string = NumberFormat.getInstance().format(number)
        return string
    }

    suspend fun loadImage(imageView: ImageView, url: String) {
        Picasso.get()
            .load(url)
            .error(R.drawable.flag_nations)
            .resize(150,200)
            .into(imageView)
    }

    fun loadData() {
        
    }
}