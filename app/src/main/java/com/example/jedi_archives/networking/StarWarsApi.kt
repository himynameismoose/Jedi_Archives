package com.example.jedi_archives.networking

import android.os.Looper
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import okhttp3.OkHttpClient

class StarWarsApi {
    fun getApolloClient() : ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Only the main thread can get the apolloClient instance"
        }

        val okHttpClient = OkHttpClient.Builder().build()

        return ApolloClient.Builder()
            .serverUrl("https://swapi.dev/api/")
            .okHttpClient(okHttpClient)
            .build()
    }
}