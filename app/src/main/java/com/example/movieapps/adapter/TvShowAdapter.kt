package com.example.movieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapps.R
import com.example.movieapps.databinding.FilmItemBinding
import com.example.movieapps.model.DataContent
import com.example.movieapps.ui.fragment.ItemCallBack
import com.squareup.picasso.Picasso

class TvShowAdapter(private val callBack: ItemCallBack): RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private val listTvShow = ArrayList<DataContent>()

    fun setTvShow(data: List<DataContent>) {
        listTvShow.clear()
        listTvShow.addAll(data)
    }

    inner class TvShowViewHolder(private val binding: FilmItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(dataTvShow: DataContent) {
            with(binding) {
                roundedImage.setOnClickListener {
                    callBack.setItemcallBack(dataTvShow)
                }
                tvTitle.text = dataTvShow.title
                Picasso.get()
                    .load(dataTvShow.imagePoster)
                    .placeholder(R.drawable.ic_refresh)
                    .error(R.drawable.ic_error)
                    .into(roundedImage)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val filmItemBinding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(filmItemBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShow[position])
    }

    override fun getItemCount(): Int = listTvShow.size
}