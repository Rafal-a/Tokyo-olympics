package com.thechance.tokyoolympics.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import com.thechance.tokyoolympics.data.DataManager
import com.thechance.tokyoolympics.util.CsvParser
import com.thechance.tokyoolympics.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val LOG_TAG = "Main_Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseCsvFile()
        val adapter = CountryAdapter(DataManager.achievement)
        binding.countryRecycleView.adapter = adapter
        addCallBack()
    }

    private fun parseCsvFile() {
        //  will return inputStream and save it in buffer
        val inputStream = assets.open("tokyo_2021.csv")
        val parser = CsvParser()
        /*
        * buffer reader take stream reader as it's argument
        * input stream reader takes input stream as it's argument*/
        val buffer = BufferedReader(InputStreamReader(inputStream))
        /*lambda function that uses log to run the app in log and see the info in the csv file */
        buffer.forEachLine {
            val currentMatch = parser.parse(it)
            DataManager.addCountry(currentMatch)
        }
    }

    fun addCallBack() {

        binding!!.apply {
            searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                //click search icon in keyboard
                override fun onQueryTextSubmit(query: String) = search(query)
                override fun onQueryTextChange(newText: String?) = false
            })
            searchBar.queryHint = "Looking for Country, Type it's Name"
        }
    }

    private fun search(country: String): Boolean {
        binding?.apply {
            DataManager.getSearchedCountry(country).forEach {
                binding.countryRecycleView.toString().let {
                  TODO()

                }
                }
                binding?.countryRecycleView

            }
            return false
        }
}