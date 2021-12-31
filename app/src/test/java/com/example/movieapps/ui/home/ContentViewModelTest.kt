package com.example.movieapps.ui.home

import com.example.movieapps.ui.fragment.ContentViewModel
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class ContentViewModelTest {

    private lateinit var viewModel: ContentViewModel

    @Before
    fun setUp() {
        viewModel = ContentViewModel()
    }

    @Test
    fun getMovie() {
        val movies = viewModel.getMovie()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun getTvShow() {
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(10, tvShow.size)
    }
}