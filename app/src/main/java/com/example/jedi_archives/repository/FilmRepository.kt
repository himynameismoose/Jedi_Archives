package com.example.jedi_archives.repository

import com.apollographql.apollo.api.Response
import com.example.jedi_archives.FilmListQuery

/**
 * This interface will create FilmRepositoryImpl
 * This will be used to query AllFilmsQuery.kt
 *
 * @author Mershelle
 * @version 1.0
 */
interface FilmRepository {

    suspend fun queryFilmList(): Response<FilmListQuery.Data>
}