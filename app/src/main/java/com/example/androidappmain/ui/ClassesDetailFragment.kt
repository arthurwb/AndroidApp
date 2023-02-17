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
            val type = requireArguments().getString("type")
            val origin = requireArguments().getString("origin")
            val page = requireArguments().getInt("page")
            val description = requireArguments().getString("description")

            view.findViewById<TextView>(R.id.class_detail_name).text = name
            view.findViewById<TextView>(R.id.class_detail_type).text = type
            view.findViewById<TextView>(R.id.class_detail_origin).text = view.context.resources.getString(R.string.class_origin_title, origin)
            view.findViewById<TextView>(R.id.class_detail_page).text = view.context.resources.getString(R.string.class_page_title, page)
            view.findViewById<TextView>(R.id.class_detail_description).text = description
        }

        return view
    }
}