package com.thechance.tokyoolympics

class CsvParser {
    fun parse(line:String): Achievements {
        //split using comma ','
        val tokens = line.split(',')
        return Achievements(
            rank = tokens[Constant.ColumnIndex.RANK].toInt(),
            team = tokens[Constant.ColumnIndex.TEAM].replace("'",""),
            goldMedal = tokens[Constant.ColumnIndex.GOLD_MEDAL].toInt(),
            silverMedal = tokens[Constant.ColumnIndex.SILVER_MEDAL].toInt(),
            bronzeMedal = tokens[Constant.ColumnIndex.BRONZE_MEDAL].toInt(),
            total = tokens[Constant.ColumnIndex.TOTAL].toInt(),
            rankByTotal = tokens[Constant.ColumnIndex.RANK_BY_TOTAL].toInt()
        )

    }
}