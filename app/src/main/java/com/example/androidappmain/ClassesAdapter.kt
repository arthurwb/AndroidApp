package com.example.androidappmain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidappmain.ui.ClassesDetailFragment

class ClassesAdapter(private val classes: List<DndClass>) :
    RecyclerView.Adapter<ClassesAdapter.ClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.class_card_view, parent, false)
        return ClassViewHolder(view) { position ->
            val classLocation = classes[position]

            val bundle = bundleOf(
                "name" to classLocation.name,
                "id" to classLocation.id,
                "image" to classLocation.image,
                "type" to classLocation.type,
                "origin" to classLocation.origin,
                "page" to classLocation.pageNum,
                "description" to classLocation.description
            )

            val detailFragment = ClassesDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity

            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = classes.size

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val classGlide = classes[position]
        Glide
            .with(holder.itemView.context)
            .load(classGlide.image)
            .into(holder.classImage)

        holder.className.text = classGlide.name
        holder.classID.text = classGlide.id.toString()
    }

    inner class ClassViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val classImage: ImageView = itemView.findViewById(R.id.class_image)
        val className: TextView = itemView.findViewById(R.id.class_name)
        val classID: TextView = itemView.findViewById(R.id.class_id)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }
}
