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
            view.context.resources.getString(R.string.class_artificer_description),
            "https://www.enworld.org/data/attachments/25/25385-b7ecb2659a2ad69e504b73de736160d4.jpg"
        )
        val barbarian = createClass(
            "Barbarian",
            "Player's Handbook",
            (0..300).random(),
            "${classType[0]}",
            2,
            view.context.resources.getString(R.string.class_barbarian_description),
            "https://www.enworld.org/data/attachments/25/25427-e516d7294e89f2ffec671b85bb8770d8.jpg"
        )
        val bard = createClass(
            "Bard",
            "Player's Handbook",
            (0..300).random(),
            "${classType[1]}/${classType[4]}",
            3,
            view.context.resources.getString(R.string.class_bard_description),
            "https://www.enworld.org/data/attachments/25/25453-9e7fa880325abcb7a8fb69930e9d6b5e.jpg"
        )
        val cleric = createClass(
            "Cleric",
            "Player's Handbook",
            (0..300).random(),
            "${classType[3]}/${classType[1]}",
            4,
            view.context.resources.getString(R.string.class_cleric_description),
            "https://www.enworld.org/data/attachments/25/25488-c22eacecc312cb6c46b749c0804a1426.jpg"
        )
        val druid = createClass(
            "Druid",
            "Player's Handbook",
            (0..300).random(),
            "${classType[0]}/${classType[1]}/${classType[2]}/${classType[3]}/${classType[4]}",
            5,
            view.context.resources.getString(R.string.class_druid_description),
            "https://www.enworld.org/data/attachments/25/25527-b5410377ddef5f14a22e1109e7dca5eb.jpg"
        )
        val fighter = createClass(
            "Fighter",
            "Player's Handbook",
            (0..300).random(),
            "${classType[0]}/${classType[2]}",
            6,
            view.context.resources.getString(R.string.class_fighter_description),
            "https://www.enworld.org/data/attachments/25/25643-6603092789799dac8e3efeb566b3795a.jpg"
        )
        val error = createClass(
            "Error",
            "Error",
            -1,
            "Error",
            -1,
            "This error have been placed here intentionally",
            "https://cdn0.iconfinder.com/data/icons/shift-interfaces/32/Error-512.png"
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
        description: String,
        image: String
    ) = DndClass(
        name = name,
        id = id,
        description = description,
        image = image,
        type = type,
        origin = origin,
        pageNum = pageNum
    )
}