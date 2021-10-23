package com.example.imdblist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {   private lateinit var imdbAdapter: ImdbAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imdbDataList: MutableList<ImdbData>

    private var myView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (myView == null) {
            myView = container?.inflate(R.layout.fragment_first)
        }
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
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
                "Venom (2021)",
                7.2,
                7,
                71,
                false,
                "https://m.media-amazon.com/images/I/71-GNRNf0VS._AC_SL1000_.jpg"
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
                "The Suicide Squad (2021)",
                8.5,
                8,
                85,
                false,
                "https://cdn.shopify.com/s/files/1/0037/8008/3782/products/TheSuicideSquadOneSheetMoviePoster-145571_1024x1024@2x.jpg?v=1622506700"

            )
        )
        imdbDataList.add(
            ImdbData(
                "Black Widow (2021)",
                8.1,
                8,
                81,
                false,
                "https://m.media-amazon.com/images/M/MV5BNjRmNDI5MjMtMmFhZi00YzcwLWI4ZGItMGI2MjI0N2Q3YmIwXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg"
            )
        )
        imdbDataList.add(
            ImdbData(
                "The Conjuring 3 (2021)",
                8.0,
                8,
                80,
                false,
                "https://wallpaperaccess.com/full/4592385.jpg"
            )
        )

        imdbAdapter = ImdbAdapter(FirstFragment(), imdbDataList) { position ->
            val imdbData = imdbDataList[position]
            if (imdbData.bookmarked){
                imdbData.bookmarked = false
            }else{
                imdbData.bookmarked = true
            }
            imdbAdapter.notifyItemChanged(position)
        }

        imdbDataList.sortByDescending { it.ratingMetascoreTV }
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = imdbAdapter
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {

            }
    }

}