package com.example.movieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapps.R
import com.example.movieapps.databinding.FilmItemBinding
import com.example.movieapps.model.DataContent
import com.example.movieapps.ui.fragment.ItemCallBack
import com.squareup.picasso.Picasso

class MovieAdapter(private val callBack: ItemCallBack) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listTvShow = ArrayList<DataContent>()

    fun setMovie(data: List<DataContent>) {
        listTvShow.clear()
        listTvShow.addAll(data)
    }

    inner class MovieViewHolder(private val binding: FilmItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(dataMovie: DataContent) {
            with(binding) {
                roundedImage.setOnClickListener {
                    callBack.setItemcallBack(dataMovie)
                }
                tvTitle.text = dataMovie.title
                Picasso.get()
                    .load(dataMovie.imagePoster)
                    .placeholder(R.drawable.ic_refresh)
                    .error(R.drawable.ic_error)
                    .into(roundedImage)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val filmItemBinding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(filmItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size
}
