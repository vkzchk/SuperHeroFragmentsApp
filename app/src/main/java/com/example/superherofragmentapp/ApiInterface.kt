package com.example.superherolist

import com.example.superherofragmentapp.SuperHeroResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("/superhero-api/api/all.json")
    fun getSuperHeroes():Single<List<SuperHeroResponse>>
}