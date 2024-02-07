package com.example.superherofragmentapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class SuperheroesAdapter(
    context: Context,
    items: MutableList<SuperHeroTransformResponse>
): ArrayAdapter<SuperHeroTransformResponse>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView:View
        if (convertView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.list_item_layout,
                parent,
                false
            )
            val itemImage: ImageView = listItemView.findViewById(R.id.itemImage)
            val itemTitle: TextView = listItemView.findViewById(R.id.itemTitle)
            val itemWork: TextView = listItemView.findViewById(R.id.itemWork)
            val superhero = getItem(position)

            superhero?.let {
                itemTitle.text = it.name
                itemWork.text = it.work
                Glide.with(context).load(it.imageUrl).into(itemImage)
            }
        } else {
            listItemView = convertView
        }

        return listItemView
    }
}
