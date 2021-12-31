package com.example.movieapps.ui.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.movieapps.R
import com.example.movieapps.databinding.ActivityDetailBinding
import com.example.movieapps.model.DataContent
import com.example.movieapps.utils.DataDummy
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ID_MOVIE = "id_movie"
        const val ID_TV_SHOW = "id_tv_show"
    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.collapsingLayout.apply {
            setCollapsedTitleTextColor(ContextCompat.getColor(applicationContext, R.color.white))
            setExpandedTitleColor(Color.TRANSPARENT)
        }
        binding.imgBackDetail.setOnClickListener {
            onBackPressed()
            finish()
        }

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras

        if(extras != null) {
            val movieId = extras.getString(ID_MOVIE)
            val tvShowId = extras.getString(ID_TV_SHOW)
            if(movieId != null) {
                viewModel.setSelectedMovie(movieId)
                for(movie in DataDummy.generateDummyMovie()) {
                    if(movie.id == movieId) {
                        populateMovie(viewModel.getDetailMovieById())
                    }
                }
            }
            if(tvShowId != null) {
                viewModel.setSelectedTvShow(tvShowId)
                for(tvShow in DataDummy.generateDummyTvShow()) {
                    if(tvShow.id == tvShowId) {
                        populateMovie(viewModel.getDetailTvById())
                    }
                }
            }

        }

    }

    private fun populateMovie(movie: DataContent) {
        with(binding) {
            Picasso.get()
                .load(movie.imagePreview)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(imgPreview)

            tvTitle.text = movie.title
            tvTime.text = movie.time
            tvGenre.text = movie.genre
            tvDate.text = movie.date
            tvRating.text = movie.rating.toString()
            tvSinopsis.text = movie.synopsis
        }
    }
}