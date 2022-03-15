package com.example.jedi_archives.repository

import com.apollographql.apollo.api.Response
import com.example.jedi_archives.AllFilmsListQuery

interface FilmRepository {
    suspend fun queryAllFilmsList(): Response<AllFilmsListQuery.Data>
}