package com.example.androidappmain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidappmain.DndClass
import com.example.androidappmain.ClassesAdapter
import com.example.androidappmain.R
import kotlin.random.Random

class ClassesListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_class_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.class_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //characters
        val classes = mutableListOf<DndClass>()

        //genders
        val classType = mutableListOf("Tank", "Ranged DPS", "Melee DPS", "Healer", "Support")
        //characterLocations
        val classOrigin = mutableListOf(
            "Player's Handbook",
            "Xanathar's Guide to Everything",
            "Tasha's Cauldron of Everything",
            "Homebrew"
        )
        //nameMods
        val dndClassNames = mutableListOf("Artificer", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Error")
        //characterNames -> Maybe replace with a random ID

        for (i in 0..6) {
            classes.add(
                createClass(
                    dndClassNames[i],
                    classOrigin.random(),
                    classType.random(),
                    i,
                    (0..200).random()
                )
            )
        }

        val adapter = ClassesAdapter(classes)
        recyclerView.adapter = adapter

        return view
    }

    private fun createClass(
        name: String,
        origin: String,
        type: String,
        id: Int,
        pageNum: Int
    ) = DndClass(
        name = name,
        id = id,
        description = "Sample Description",
        image = "https://rickandmortyapi.com/api/character/avatar/291.jpeg",
        type = type,
        origin = origin,
        pageNum = pageNum
    )
}