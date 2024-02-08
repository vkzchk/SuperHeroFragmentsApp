package com.example.superherofragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.superherolist.ApiClient
import com.example.superherolist.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listFragment = supportFragmentManager.findFragmentById(R.id.listContainer) as ListFragment
        val detailsFragment = supportFragmentManager.findFragmentById(R.id.details) as? DetailsFragment
        val apiClient = ApiClient.client.create(ApiInterface::class.java)

        apiClient.getSuperHeroes()
            .subscribeOn(Schedulers.io())
            .map { res -> transformResponse(res) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                listFragment.updateList(it)
            }, {
                Toast.makeText(this, "Fetch error ${it.message}", Toast.LENGTH_LONG).show()
            })

       listFragment.setItemClickListener { details ->
            if (detailsFragment != null) {
                detailsFragment.setDetails(details)
           } else {
                val newDetailsFragment = DetailsFragment()
                newDetailsFragment.setDetails(details)
                supportFragmentManager.beginTransaction()
                    .add(R.id.listContainer, newDetailsFragment)
                    .addToBackStack("details_fragment")
                   .commit()
            }
        }
    }

    private fun transformResponse(res: List<SuperHeroResponse>): MutableList<SuperHeroTransformResponse> {
        val items: MutableList<SuperHeroTransformResponse> = mutableListOf()
        res.forEach {
            val name = it.name
            val work = it.work.occupation
            val image = it.images.sm
            val fullName = it.biography.fullName
            val gender = it.appearance.gender
            val alterEgos = it.biography.alterEgos
            val imageUrl = it.images.lg
            val groupAffiliation = it.connections.groupAffiliation
            val relatives = it.connections.relatives
            val details = Details(fullName, gender,alterEgos,imageUrl,groupAffiliation,relatives)
            items.add(SuperHeroTransformResponse(name, work, image, details))
        }

        return items
    }
}