package com.hapkiduki.model

data class DogBreed(
    val id: Int,
    val name: String,
    val bredFor: String?,
    val breedGroup: String?,
    val countryCode: String?,
    val description: String?,
    val history: String?,
    val height: Measure,
    val image: String?,
    val lifeSpan: String,
    val origin: String?,
    val referenceImageId: String,
    val temperament: String?,
    val weight: Measure
)
