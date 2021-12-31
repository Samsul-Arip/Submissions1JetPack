package com.example.movieapps.ui.detail

import com.example.movieapps.utils.DataDummy
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getDetailMovieById() {
        val movie = viewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.imagePreview, movie.imagePreview)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.time, movie.time)
        assertEquals(dummyMovie.rating.toString(), movie.rating.toString())
        assertEquals(dummyMovie.date, movie.date)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.synopsis, movie.synopsis)
    }

    @Test
    fun getDetailTvById() {
        val tvShow = viewModel.getDetailTvById()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.imagePreview, tvShow.imagePreview)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.time, tvShow.time)
        assertEquals(dummyTvShow.rating.toString(), tvShow.rating.toString())
        assertEquals(dummyTvShow.date, tvShow.date)
        assertEquals(dummyTvShow.genre, tvShow.genre)
        assertEquals(dummyTvShow.synopsis, tvShow.synopsis)
    }
}