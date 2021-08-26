package com.thechance.tokyoolympics.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.thechance.tokyoolympics.data.DataManager
import com.thechance.tokyoolympics.util.CsvParser
import com.thechance.tokyoolympics.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val LOG_TAG="Main_Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        parseCsvFile()
        val adapter = CountryAdapter(DataManager.achievement)
        binding.countryRecycleView.adapter=adapter
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
            val currentMatch= parser.parse(it)
            DataManager.addCountry(currentMatch)
        }
    }
}