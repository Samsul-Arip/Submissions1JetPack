package com.example.movieapps.ui.detail

import androidx.lifecycle.ViewModel
import com.example.movieapps.model.DataContent
import com.example.movieapps.utils.DataDummy

class DetailViewModel: ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }
    fun setSelectedTvShow(tvId: String) {
        this.tvShowId = tvId
    }

    fun getDetailMovieById(): DataContent {
        lateinit var movie: DataContent
        val movieEntities = DataDummy.generateDummyMovie()
        for(movieEntity in movieEntities) {
            if(movieEntity.id == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getDetailTvById(): DataContent {
        lateinit var tvShow: DataContent
        val tvShowEntities = DataDummy.generateDummyTvShow()
        for(tvEntity in tvShowEntities) {
            if(tvEntity.id == tvShowId) {
                tvShow = tvEntity
            }
        }
        return tvShow
    }
}