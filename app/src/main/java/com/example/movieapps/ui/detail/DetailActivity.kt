package com.example.movieapps.ui.detail

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.movieapps.R
import com.example.movieapps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

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

    }
}