package com.example.taskwebgridcardview


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(private val context: Context, private val websites: Array<GridItem>) : BaseAdapter() {

    override fun getCount(): Int = websites.size

    override fun getItem(position: Int): Any = websites[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)

        val icon: ImageView = view.findViewById(R.id.icon)
        val title: TextView = view.findViewById(R.id.title)

        val gridItem = websites[position]
        title.text = gridItem.name
        icon.setImageResource(gridItem.imageResId) // Использование изображения из модели

        return view
    }
}