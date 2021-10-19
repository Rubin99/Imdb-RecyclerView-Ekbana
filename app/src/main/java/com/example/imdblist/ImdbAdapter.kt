package com.example.imdblist

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImdbAdapter(

    private val context: Context,
    private val imdbDataList: MutableList<ImdbData>,
    private val onViewClicked: (position: Int) -> Unit

) : RecyclerView.Adapter<ImdbViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ImdbViewHolder(parent.inflate(R.layout.adapter_items_list)) { position ->
            onViewClicked(position)
        }

    override fun onBindViewHolder(holder: ImdbViewHolder, position: Int) {
        val imdbData = imdbDataList[position]


        Picasso.get()
            .load("https://i.pinimg.com/originals/7e/4c/3a/7e4c3a7b6aa1fe5ae34d3247f054f517.jpg")
            .into(holder.movieImageView)

        //picasso.load(imdbData).into(holder.movieImageView)
        holder.bookmarkImageBtn.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_bookmark_add_24))
        //holder.movieImageView.setImageDrawable(context.getDrawable(imdbData.movieImageView))
        holder.movieNameTV.text = imdbData.movieNameTV
        holder.rating1TV.text = imdbData.rating1TV.toString()
        holder.rating2TV.text = imdbData.rating2TV.toString()
        holder.ratingMetascoreTV.text = imdbData.ratingMetascoreTV.toString()

        holder.bookmarkImageBtn.setOnClickListener {
            holder.bookmarkImageBtn.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_check_circle_24))
        }
    }

    override fun getItemCount() = imdbDataList.count()

}
