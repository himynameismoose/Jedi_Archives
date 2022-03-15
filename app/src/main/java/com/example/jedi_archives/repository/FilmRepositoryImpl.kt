package com.example.jedi_archives.repository

import com.apollographql.apollo.api.Response
import com.example.jedi_archives.AllFilmsListQuery

class FilmRepositoryImpl : FilmRepository {
    override suspend fun queryAllFilmsList(): Response<AllFilmsListQuery.Data> {
        TODO("Not yet implemented")
    }
}