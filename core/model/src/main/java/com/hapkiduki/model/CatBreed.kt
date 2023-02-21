package com.hapkiduki.model

/**
 *  External data layer representation of a fully populated breed of dogs or cats
 */
data class CatBreed(
    val id: String,
    val weight: Measure,
    val name: String,
    val temperament: String,
    val origin: String,
    val countryCode: String,
    val description: String,
    val lifeSpan: String,
    val child_friendly: Int,
    val dog_friendly: Int,
    val energy_level: Int,
    val intelligence: Int,
    val adaptability: Int,
)
