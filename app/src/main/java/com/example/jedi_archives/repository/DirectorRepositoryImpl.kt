package com.example.jedi_archives.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.example.FilmsQuery

class DirectorRepositoryImpl : DirectorRepository {
    override suspend fun queryDirectorList(): ApolloResponse<FilmsQuery.Data> {
        TODO("Not yet implemented")
    }
}