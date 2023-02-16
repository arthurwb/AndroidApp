package com.example.androidappmain.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidappmain.R


class ClassesDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_class_detail, container, false)

        if (arguments != null) {
            val name = requireArguments().getString("name")
            val id = requireArguments().getInt("id")
            val image = requireArguments().getString("image")
            val description = requireArguments().getString("description")

            view.findViewById<TextView>(R.id.class_description).text = description
        }

        return view
    }
}