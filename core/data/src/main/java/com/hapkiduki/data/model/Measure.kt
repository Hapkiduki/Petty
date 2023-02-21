package com.hapkiduki.data.model

import com.hapkiduki.model.Measure
import com.hapkiduki.network.model.NetworkMeasure

fun NetworkMeasure.asExternalModel() = Measure(imperial, metric)