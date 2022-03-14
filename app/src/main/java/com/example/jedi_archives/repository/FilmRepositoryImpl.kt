package com.example.jedi_archives.repository

import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import com.example.jedi_archives.AllFilmsQuery
import com.example.jedi_archives.networking.JediArchivesApi
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val webService: JediArchivesApi
): FilmRepository {
    override suspend fun queryFilmList(): Response<AllFilmsQuery.Data> {

        return webService.getApolloClient().query(AllFilmsQuery()).await()
    }
}