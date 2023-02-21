package com.hapkiduki.petty.data.network.interceptors


import com.hapkiduki.petty.data.network.Api

import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import java.io.IOException

object BaseUrlInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val apiType = originalRequest.tag(Invocation::class.java)
            ?.method()
            ?.getAnnotation(Api::class.java)?.value
            ?: throw IOException("You must add ApiType to your request method in interface.")


        val baseUrl = apiType.url.toHttpUrl()

        val newUrl = originalRequest.url.newBuilder()
            .scheme(baseUrl.scheme)
            .host(baseUrl.host)
            .port(baseUrl.port)
            .build()


        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}