package com.example.imdblist

import com.squareup.picasso.RequestCreator

data class ImdbData(
    val bookmarkImageBtn: Int,
    val movieImageView: RequestCreator,
    val movieNameTV: String,
    val rating1TV: Double,
    val rating2TV: Int,
    val ratingMetascoreTV: Int
)