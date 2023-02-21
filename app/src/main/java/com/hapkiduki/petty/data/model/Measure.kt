package com.hapkiduki.petty.data.model

import com.hapkiduki.petty.data.network.model.NetworkMeasure
import com.hapkiduki.petty.model.Measure

fun NetworkMeasure.asExternalModel() = Measure(imperial, metric)