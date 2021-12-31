package com.example.movieapps.ui.fragment.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapps.adapter.MovieAdapter
import com.example.movieapps.databinding.FragmentMoviesBinding
import com.example.movieapps.model.DataContent
import com.example.movieapps.ui.detail.DetailActivity
import com.example.movieapps.ui.fragment.ContentViewModel
import com.example.movieapps.ui.fragment.ItemCallBack

class MoviesFragment : Fragment(), ItemCallBack {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]
            val movie = viewModel.getMovie()

            val movieAdapter = MovieAdapter(this)
            movieAdapter.setMovie(movie)

            with(binding.rvMovie){
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setItemcallBack(data: DataContent) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.ID_MOVIE, data.id)
        startActivity(intent)
    }
}