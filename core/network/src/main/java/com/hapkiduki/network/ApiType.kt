package com.hapkiduki.network

enum class ApiType(
    val url: String
) {
    CATS(Constants.CAT_URL),
    DOGS(Constants.DOG_URL)
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Api(
    val value: ApiType
)