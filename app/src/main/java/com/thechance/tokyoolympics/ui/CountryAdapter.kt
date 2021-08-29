package com.thechance.tokyoolympics.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thechance.tokyoolympics.R
import com.thechance.tokyoolympics.data.domain.Achievements
import com.thechance.tokyoolympics.databinding.ItemAchievementsBinding
import android.widget.Filter
import android.widget.Filterable
import java.util.*
import kotlin.collections.ArrayList


class CountryAdapter(private var list: List<Achievements>):RecyclerView.Adapter<CountryAdapter.MatchViewHolder>(){
    var countryFilterList = ArrayList<String>()

    init {
        countryFilterList = list.map{it.team} as ArrayList<String>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        //provide the necessary items to show
       val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_achievements,parent,false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        //list that has the current position
        val currentValue = list[position]
       
      holder.binding.apply {
          number.text = currentValue.rank.toString()
         textCountryName.text = currentValue.team
         textGoldMedal.text = currentValue.goldMedal.toString()
          textSilverMedal.text = currentValue.silverMedal.toString()
          textBronzeMedal.text = currentValue.bronzeMedal.toString()
          textTotalCount.text = currentValue.rankByTotal.toString()
      }
    }


    override fun getItemCount() = list.size

   class MatchViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem) {
        val binding = ItemAchievementsBinding.bind(viewItem)
   }

}