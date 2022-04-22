package com.example.mycountries

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.example.mycountries.api.ApiFactory.service
import com.example.mycountries.databinding.ActivityMainBinding
import com.example.mycountries.pojo.Country
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val provider = ViewModelProviders.of(this)
        val countriesViewModel = provider.get(CountriesViewModel::class.java)


        binding.buttonFind.setOnClickListener {
            val countryName = binding.editTextCountryName.text.toString()

            lifecycleScope.launch {
                val countries: List<Country> = service.getCountriesByName(countryName)
                val country = countries[0]

                binding.textViewCountryName.text = country.name
                binding.textViewRegion.text = country.region
                binding.textViewCapital.text = country.capital
                binding.textViewArea.text = countriesViewModel.formatNumber(country.area)
                binding.textViewPopulation.text = countriesViewModel.formatNumber(country.population)
                binding.textViewLanguage.text = countriesViewModel.converterListLanguageToString(country.languages)
                binding.textViewCurrency.text = countriesViewModel.converterListCurrencyToString(country.currencies)
                countriesViewModel.loadImage(binding.imageViewFlag, country.flag)
                binding.layoutResult.visibility = View.VISIBLE
            }
        }
    }
}