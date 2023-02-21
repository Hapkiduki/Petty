package com.hapkiduki.common

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): Result<T> = withContext(Dispatchers.IO) {
    try {
        Result.Success(call())
    } catch (e: UnknownHostException) {
        Result.Error(e)
    } catch (e: HttpException) {
        Result.Error(e)
    } catch (e: Exception) {
        Result.Error(e)
    }
}