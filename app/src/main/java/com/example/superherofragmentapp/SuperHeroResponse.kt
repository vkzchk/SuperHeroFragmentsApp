package com.example.superherofragmentapp

data class SuperHeroResponse(
    val id: Long,
    val name:String,
    val slug: String,
    val powerstats:Powerstats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections:Connections,
    val images: Images
)

data class Powerstats (
    val intelligence : Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power : Int,
    val combat: Int

)

data class Appearance (
    val gender: String,
    val race: String,
    val height: ArrayList<String>,
    val weight: ArrayList<String> ,
    val eyeColor: String,
    val hairColor: String

)

data class Biography (
    val fullName: String,
    val alterEgos: String,
    val aliases: ArrayList<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String

)

data class Work (
    val occupation: String,
    val base: String

)

data class Connections (
    val groupAffiliation: String,
    val relatives: String

)

data class Images (
    val xs : String,
    val sm : String,
    val md : String,
    val lg : String
)

data class SuperHeroTransformResponse( val name:String, val work: String, val imageUrl: String, val details: Details)


data class Details(
    val fullName: String,
    val gender: String,
    val alterEgos: String,
    val imageUrl: String,
    val groupAffiliation: String,
    val relatives: String
)