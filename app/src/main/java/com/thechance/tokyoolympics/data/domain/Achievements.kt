package com.thechance.tokyoolympics.data.domain

data class Achievements(   val rank:Int,
                      val team :String,
                      val goldMedal:Int,
                      val silverMedal:Int,
                      val bronzeMedal:Int,
                      val total:Int,
                      val rankByTotal:Int)