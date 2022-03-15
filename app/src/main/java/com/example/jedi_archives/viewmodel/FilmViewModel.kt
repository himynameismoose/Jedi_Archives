package com.example.jedi_archives.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.jedi_archives.AllFilmsListQuery
import com.example.jedi_archives.repository.FilmRepository
import com.example.jedi_archives.view.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository
) : ViewModel() {
    // fields
    private val _filmsList by lazy { MutableLiveData<ViewState<Response<AllFilmsListQuery.Data>>>() }
    val filmsList: LiveData<ViewState<Response<AllFilmsListQuery.Data>>>
        get() = _filmsList

    fun queryAllFilmsList() = viewModelScope.launch {
        _filmsList.postValue(ViewState.Loading())
        try {
            val response = repository.queryAllFilmsList()
            _filmsList.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            Log.d("ApolloException", "Failure", e)
            _filmsList.postValue(ViewState.Error("Error fetching characters"))
        }
    }
}