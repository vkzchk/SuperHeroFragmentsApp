package com.example.superherofragmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment:Fragment() {

    private var onItemClick: (Details) -> Unit = {}
    private lateinit var adapter: SuperheroesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_item_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list: ListView = view.findViewById(R.id.listContainer)
        adapter = SuperheroesAdapter(requireContext(), mutableListOf())
        list.adapter = adapter
        list.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            val superhero = adapter.getItem(position)
            superhero?.let { onItemClick(it.details) }}
    }

    fun setItemClickListener(lambda: (details: Details) -> Unit) {
        onItemClick = lambda
    }

    fun updateList(superheroes: List<SuperHeroTransformResponse>) {
        adapter.clear()
        adapter.addAll(superheroes)
        adapter.notifyDataSetChanged()
    }
}