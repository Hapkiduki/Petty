package com.hapkiduki.petty.data.model

import com.hapkiduki.petty.data.network.model.NetworkCatBreed
import com.hapkiduki.petty.model.CatBreed

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