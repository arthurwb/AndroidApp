package com.example.androidappmain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.class_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val classes = mutableListOf<DndClass>()

        for (i in 0 .. 5) {
            classes.add(createClasses(i))
        }


        val adapter = ClassesAdapter(classes)
        recyclerView.adapter = adapter
    }

    private fun createClasses(input: Int) =
        when(input) {
            0 -> DndClass(
                name = "Artificer",
                id = 0,
                description = "Masters of invention, artificers use ingenuity and magic to unlock extraordinary capabilities in objects.",
                image = R.drawable.baseline_handyman_24,
                type = "Support",
                origin = "Eberron: Rising from the Last War",
                pageNum = 54
            )
            1 -> DndClass(
                name = "Barbarian",
                id = 1,
                description = "A fierce warrior of primitive background who can enter a battle rage",
                image = R.drawable.baseline_healing_24,
                type = "Tank",
                origin = "Player's Handbook",
                pageNum = 45
            )
            2 -> DndClass(
                name = "Bard",
                id = 2,
                description = "An inspiring magician whose power echoes the music of creation",
                image = R.drawable.baseline_theater_comedy_24,
                type = "Support",
                origin = "Player's Handbook",
                pageNum = 51
            )
            3 -> DndClass(
                name = "Cleric",
                id = 3,
                description = "A priestly champion who wields divine magic in service of a higher power",
                image = R.drawable.baseline_church_24,
                type = "Support/Dps",
                origin = "Player's Handbook",
                pageNum = 56
            )
            4 -> DndClass(
                name = "Druid",
                id = 4,
                description = "A priest of the Old Faith, wielding the powers of nature — moonlight and plant growth, fire and lightning — and adopting animal forms",
                image = R.drawable.baseline_emoji_nature_24,
                type = "Support/Dps/Tank",
                origin = "Player's Handbook",
                pageNum = 51
            )
            5 -> DndClass(
                name = "Fighter",
                id = 5,
                description = "A master of martial combat, skilled with a variety of weapons and armor",
                image = R.drawable.baseline_gavel_24,
                type = "Tank/Dps",
                origin = "Player's Handbook",
                pageNum = 70
            )
            else -> DndClass(
                name = "Error",
                id = -1,
                description = "Error",
                image = R.drawable.baseline_airline_seat_recline_extra_24,
                type = "Error",
                origin = "Error",
                pageNum = -1
            )
        }





//        DndClass(
//        name = "Artificer",
//        id = Random.nextInt(10, 99),
//        description = "Make stuff",
//        image = R.drawable.baseline_airline_seat_recline_extra_24,
//        type = "test",
//        origin = "Eberron",
//        pageNum = 132
//    )

/*

 */
}