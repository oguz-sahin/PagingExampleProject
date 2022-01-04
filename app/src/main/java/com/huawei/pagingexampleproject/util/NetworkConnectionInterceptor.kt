package com.huawei.pagingexampleproject.util

import android.content.Context
import com.huawei.pagingexampleproject.util.NetworkUtils.isNetworkAvailable
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Created by Oguz Sahin on 11/10/2021.
 */

class NetworkConnectionInterceptor(private val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable(context)) {
            throw NoConnectionException()
        }
        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    inner class NoConnectionException : IOException() {
        override val message: String
            get() = super.message ?: "No Internet Connection"
    }
}