package com.example.imdblist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var imdbAdapter: ImdbAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imdbDataList: MutableList<ImdbData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        imdbDataList = ArrayList()
        imdbDataList.add(
            ImdbData(
                "Dune (2021)",
                8.8,
                8,
                88,
                false,
                "https://cdn.europosters.eu/image/1300/posters/dune-fear-is-the-mind-killer-i107183.jpg"

            )
        )
        imdbDataList.add(
            ImdbData(
                "The French Dispatch (2021)",
                7.2,
                7,
                71,
                false,
                "https://m.media-amazon.com/images/I/71nWfxOlCTL._AC_SL1398_.jpg"
            )
        )
        imdbDataList.add(
            ImdbData(
                "Free Guy (2021)",
                9.0,
                9,
                92,
                false,
                "https://img.republicworld.com/republic-prod/stories/images/16019654225f7c0d6e3ec0a.png"
                )
        )
        imdbDataList.add(
            ImdbData(
                "Dune (2021)",
                8.8,
                8,
                88,
                false,
                "https://cdn.europosters.eu/image/1300/posters/dune-fear-is-the-mind-killer-i107183.jpg"

            )
        )
        imdbDataList.add(
            ImdbData(
                "The French Dispatch (2021)",
                7.2,
                7,
                71,
                false,
                "https://m.media-amazon.com/imageFs/I/71nWfxOlCTL._AC_SL1398_.jpg"
            )
        )
        imdbDataList.add(
            ImdbData(
                "Free Guy (2021)",
                9.0,
                9,
                92,
                false,
                "https://img.republicworld.com/republic-prod/stories/images/16019654225f7c0d6e3ec0a.png"
            )
        )

        imdbAdapter = ImdbAdapter(this, imdbDataList) { position ->
            val imdbData = imdbDataList[position]
            if (imdbData.bookmarked){
                imdbData.bookmarked = false
            }else{
                imdbData.bookmarked = true
            }
            imdbAdapter.notifyItemChanged(position)
        }
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = imdbAdapter
    }
}