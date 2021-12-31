package com.example.movieapps.ui.fragment

import androidx.lifecycle.ViewModel
import com.example.movieapps.model.DataContent
import com.example.movieapps.utils.DataDummy

class ContentViewModel: ViewModel() {

    fun getMovie(): List<DataContent> = DataDummy.generateDummyMovie()

    fun getTvShow(): List<DataContent> = DataDummy.generateDummyTvShow()

}