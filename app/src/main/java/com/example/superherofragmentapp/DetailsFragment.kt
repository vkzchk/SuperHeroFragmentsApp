package com.example.superherofragmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class DetailsFragment:Fragment() {
    private lateinit var fullNameTextView: TextView
    private lateinit var genderTextView: TextView
    private lateinit var alterEgosTextView: TextView
    private lateinit var groupAffiliationTextView: TextView
    private lateinit var relativesTextView: TextView
    private lateinit var itemImageView: ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fullNameTextView = view.findViewById(R.id.fullName)
        genderTextView = view.findViewById(R.id.gender)
        alterEgosTextView = view.findViewById(R.id.alterEgos)
        groupAffiliationTextView = view.findViewById(R.id.groupAffiliation)
        relativesTextView = view.findViewById(R.id.relatives)
        itemImageView = view.findViewById(R.id.imageUrl)
    }

    fun updateDetails(details: Details) {
        fullNameTextView.text = details.fullName
        genderTextView.text = details.gender
        alterEgosTextView.text = details.alterEgos
        groupAffiliationTextView.text = details.groupAffiliation
        relativesTextView.text = details.relatives
        Glide.with(requireContext()).load(details.imageUrl).into(itemImageView)

    }
}