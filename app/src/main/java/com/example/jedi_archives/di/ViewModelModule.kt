package com.example.jedi_archives.di

import com.example.jedi_archives.repository.FilmRepository
import com.example.jedi_archives.repository.FilmRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repo: FilmRepositoryImpl): FilmRepository
}