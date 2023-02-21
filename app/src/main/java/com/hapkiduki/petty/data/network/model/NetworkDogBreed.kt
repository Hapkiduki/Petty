package com.hapkiduki.petty.data.network.model


import com.google.gson.annotations.SerializedName

data class NetworkDogBreed(
    @SerializedName("bred_for")
    val bredFor: String?,
    @SerializedName("breed_group")
    val breedGroup: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    val description: String?,
    val height: NetworkMeasure,
    val history: String?,
    val id: Int,
    val image: NetworkImage,
    @SerializedName("life_span")
    val lifeSpan: String,
    val name: String,
    val origin: String?,
    @SerializedName("reference_image_id")
    val referenceImageId: String,
    val temperament: String?,
    val weight: NetworkMeasure
)