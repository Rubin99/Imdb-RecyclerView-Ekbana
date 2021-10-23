package com.example.imdblist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var imdbAdapter: ImdbAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imdbDataList: MutableList<ImdbData>

    private lateinit var viewPager: ViewPager
    private var viewPagerAdapter: ViewPagerAdapter? = null
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recyclerView = findViewById(R.id.recyclerView)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        //initRecyclerView()
        initViewPager()
    }

    private fun initViewPager() {
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter

        val firstFragment = FirstFragment()
        viewPagerAdapter?.addFragment(firstFragment, "Most Recent")

        val secondFragment = SecondFragment()
        viewPagerAdapter?.addFragment(secondFragment, "Top Rated")

        viewPagerAdapter?.notifyDataSetChanged()
        tabLayout.setupWithViewPager(viewPager)

    }


    /*private fun initRecyclerView() {
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
    }*/
}