package com.hapkiduki.data.model

import com.hapkiduki.network.model.NetworkCatBreed
import com.hapkiduki.model.CatBreed

fun NetworkCatBreed.asExternalModel() = CatBreed(
    id = id,
    weight = weight.asExternalModel(),
    name = name,
    temperament = temperament,
    countryCode = countryCode,
    origin = origin,
    description = description,
    lifeSpan = lifeSpan,
    child_friendly = childFriendly,
    dog_friendly = dogFriendly,
    energy_level = energyLevel,
    intelligence = intelligence,
    adaptability = adaptability
)