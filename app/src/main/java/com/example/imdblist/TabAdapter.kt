package com.example.imdblist

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
    }

    /* override fun getItem(position: Int): Fragment {
         *//*when (position) {
            0 -> {
                val firstFragment: FirstFragment = FirstFragment()
                return FirstFragment()
            }
            1 -> {
                val secondFragment: SecondFragment = SecondFragment()
                return SecondFragment()
            }

            else -> return null
        }*//*
    }*/

}
