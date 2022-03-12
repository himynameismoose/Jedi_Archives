package com.example.jedi_archives.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.FilmsQuery


interface DirectorRepository {
    suspend fun queryDirectorList(): ApolloResponse<FilmsQuery.Data>
}