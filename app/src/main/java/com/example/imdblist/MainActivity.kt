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
                R.drawable.ic_baseline_bookmark_add_24,
                Picasso.get().load("https://i.pinimg.com/originals/7e/4c/3a/7e4c3a7b6aa1fe5ae34d3247f054f517.jpg")
                    ,
                "Dune (2021)",
                8.8,
                8,
                88
            )
        )
        imdbDataList.add(
            ImdbData(
                R.drawable.ic_baseline_bookmark_add_24,
                Picasso.get().load("https://image.posterlounge.com/images/l/1904986.jpg")
                ,
                "The French Dispatch (2021)",
                7.2,
                7,
                71
            )
        )
        imdbDataList.add(
            ImdbData(
                R.drawable.ic_baseline_bookmark_add_24,
                Picasso.get().load("https://img.republicworld.com/republic-prod/stories/images/16019654225f7c0d6e3ec0a.png")
                ,
                "Free Guy (2021)",
                9.0,
                9,
                92
            )
        )


        imdbAdapter = ImdbAdapter(this, imdbDataList) { position ->
            val imdbData = imdbDataList[position]

        }
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = imdbAdapter
    }
}