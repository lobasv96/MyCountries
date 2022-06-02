package com.example.mycountries.presentation.screens

import android.app.Application
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.mycountries.R
import com.example.mycountries.converterListCurrencyToString
import com.example.mycountries.converterListLanguageToString
import com.example.mycountries.data.api.Retrofit
import com.example.mycountries.databinding.ActivityMainBinding
import com.example.mycountries.domain.pojo.Country
import com.example.mycountries.formatNumber
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {


    suspend fun loadImage(imageView: ImageView, url: String) {
        Picasso.get()
            .load(url)
            .error(R.drawable.flag_nations)
            .resize(150,200)
            .into(imageView)
    }
}