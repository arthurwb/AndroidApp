package com.example.androidappmain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClassesAdapter(private val classes: List<DndClass>) : RecyclerView.Adapter<ClassesAdapter.ClassesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val view = LayoutInflater.from(parent.context).
            inflate(R.layout.class_card_view, parent, false)
        return ClassesViewHolder(view)
    }

    override fun getItemCount() = classes.size

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        val dndClass = classes[position]
        holder.classImage.setImageResource(dndClass.image)
        holder.className.text = dndClass.name
        holder.classType.text = dndClass.type
        holder.classId.text = "Id: " + dndClass.id
        holder.classDescription.text = dndClass.description
        holder.classOrigin.text = dndClass.origin
        holder.classPageNum.text = "" + dndClass.pageNum
    }

    class ClassesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val classImage: ImageView = itemView.findViewById(R.id.class_image)
        val className: TextView = itemView.findViewById(R.id.class_name)
        val classType: TextView = itemView.findViewById(R.id.class_type)
        val classId: TextView = itemView.findViewById(R.id.class_id)
        val classDescription: TextView = itemView.findViewById(R.id.class_description)
        val classOrigin: TextView = itemView.findViewById(R.id.class_origin_book)
        val classPageNum: TextView = itemView.findViewById(R.id.class_page_number)
    }
}