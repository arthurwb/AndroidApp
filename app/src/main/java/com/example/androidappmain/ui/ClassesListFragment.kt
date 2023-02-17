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


        val classes = mutableListOf<DndClass>()

        val classType = mutableListOf("Tank", "Ranged DPS", "Melee DPS", "Healer", "Support")

        val artificer = createClass(
            "Artificer",
            "Eberron: Rising from the Last War",
            (0..300).random(),
            "${classType[1]}/${classType[4]}",
            1,
            "Sample"
        )
        val barbarian = createClass(
            "Barbarian",
            "Player's Handbook",
            (0..300).random(),
            "${classType[0]}",
            2,
            "Sample"
        )
        val bard = createClass(
            "Bard",
            "Player's Handbook",
            (0..300).random(),
            "${classType[1]}/${classType[4]}",
            3,
            "Sample"
        )
        val cleric = createClass(
            "Cleric",
            "Player's Handbook",
            (0..300).random(),
            "${classType[3]}/${classType[1]}",
            4,
            "Sample"
        )
        val druid = createClass(
            "Druid",
            "Player's Handbook",
            (0..300).random(),
            "${classType[0]}/${classType[1]}/${classType[2]}/${classType[3]}/${classType[4]}",
            5,
            "Sample"
        )
        val fighter = createClass(
            "Fighter",
            "Player's Handbook",
            (0..300).random(),
            "${classType[0]}/${classType[2]}",
            6,
            "Sample"
        )
        val error = createClass(
            "Error",
            "Error",
            -1,
            "Error",
            -1,
            "Error"
        )

        val classList = mutableListOf<DndClass>(artificer, barbarian, bard, cleric, druid, fighter, error)

        for (i in 0..(classList.size-1)) {
            classes.add(
                classList[i]
            )
        }

        val adapter = ClassesAdapter(classes)
        recyclerView.adapter = adapter

        return view
    }

    private fun createClass(
        name: String,
        origin: String,
        pageNum: Int,
        type: String,
        id: Int,
        description: String
    ) = DndClass(
        name = name,
        id = id,
        description = description,
        image = "https://viterbi-web.usc.edu/~mkperlmu/itp104/assignment_05/interests_page_gallery_layout_images/DnDLogo.jpg",
        type = type,
        origin = origin,
        pageNum = pageNum
    )
}