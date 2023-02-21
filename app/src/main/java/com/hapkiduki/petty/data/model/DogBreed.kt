package com.hapkiduki.petty.data.model

import com.hapkiduki.petty.data.network.model.NetworkDogBreed
import com.hapkiduki.petty.model.DogBreed

fun NetworkDogBreed.asExternalModel() = DogBreed(
    id = id,
    name,
    bredFor,
    breedGroup,
    countryCode,
    description,
    history,
    height.asExternalModel(),
    image.url,
    lifeSpan,
    origin,
    referenceImageId,
    temperament,
    weight.asExternalModel()
)