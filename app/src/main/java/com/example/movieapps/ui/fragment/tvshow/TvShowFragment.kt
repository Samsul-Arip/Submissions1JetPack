package com.example.movieapps.ui.fragment.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movieapps.adapter.TvShowAdapter
import com.example.movieapps.databinding.FragmentTvShowBinding
import com.example.movieapps.model.DataContent
import com.example.movieapps.ui.detail.DetailActivity
import com.example.movieapps.ui.fragment.ContentViewModel
import com.example.movieapps.ui.fragment.ItemCallBack

class TvShowFragment : Fragment(), ItemCallBack{

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]
            val tvShow = viewModel.getTvShow()

            val tvShowAdapter = TvShowAdapter(this)
            tvShowAdapter.setTvShow(tvShow)

            with(binding.rvTvShow) {
                layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setItemcallBack(data: DataContent) {
        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra(DetailActivity.ID_TV_SHOW, data.id)
        startActivity(intent)
    }

}