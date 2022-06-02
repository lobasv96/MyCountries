package com.example.mycountries.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.mycountries.*
import com.example.mycountries.data.api.Retrofit
import com.example.mycountries.databinding.ActivityMainBinding
import com.example.mycountries.domain.pojo.Country
import kotlinx.coroutines.launch
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val provider = ViewModelProviders.of(this)
        val mainViewModel = provider.get(MainViewModel::class.java)


        binding.buttonFind.setOnClickListener {
            val countryName = binding.editTextCountryName.text.toString()

            lifecycleScope.launch {
                binding.progressBar.isVisible = true
                binding.buttonFind.isEnabled = false
                val countries: List<Country> = Retrofit.service.getCountriesByName(countryName)
                val country = countries[0]

                binding.textViewCountryName.text = country.name
                binding.textViewRegion.text = country.region
                binding.textViewCapital.text = country.capital
                binding.textViewArea.text = formatNumber(country.area)
                binding.textViewPopulation.text = formatNumber(country.population)
                binding.textViewLanguage.text = converterListLanguageToString(country.languages)
                binding.textViewCurrency.text = converterListCurrencyToString(country.currencies)

                mainViewModel.loadImage(binding.imageViewFlag, country.flag)
                binding.layoutResult.visibility = View.VISIBLE
                binding.buttonFind.isEnabled = true
                binding.progressBar.isVisible = false
            }
        }
    }
}