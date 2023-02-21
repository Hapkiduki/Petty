package com.hapkiduki.data.model

import com.hapkiduki.model.DogBreed
import com.hapkiduki.network.model.NetworkDogBreed

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