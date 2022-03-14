package com.example.jedi_archives.networking

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

/**
 * This class will be used to create an instance of the ApolloClient.
 *
 * @author Mershelle Rivera
 * @version 1.0
 */
class JediArchivesApi {
    // fun to get apollo client
    fun getApolloClient() : ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Only the main thread can get the apolloClient instance"
        }

        val okHttpClient = OkHttpClient.Builder().build()

        // Returns the network call to the SWAPI endpoint
        return ApolloClient.builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
            .okHttpClient(okHttpClient)
            .build()
    }
}