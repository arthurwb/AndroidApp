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

        for (i in 0 .. 30) {
            classes.add(createClasses())
        }

        val adapter = ClassesAdapter(classes)
        recyclerView.adapter = adapter
    }

    private fun createClasses() = DndClass(
        name = "Artificer",
        id = Random.nextInt(10, 99),
        description = "Make stuff",
        image = R.drawable.baseline_airline_seat_recline_extra_24,
        type = "support",
        origin = "Eberron",
        pageNum = 132
    )
}