package com.example.jedi_archives.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.jedi_archives.AllFilmsQuery
import com.example.jedi_archives.repository.FilmRepository
import com.example.jedi_archives.view.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository,
) : ViewModel() {

    // Fields
    private val _filmList by lazy { MutableLiveData<ViewState<Response<AllFilmsQuery.Data>>>() }
    val filmList: LiveData<ViewState<Response<AllFilmsQuery.Data>>>
    get() = _filmList

    fun queryFilmList() = viewModelScope.launch{
        _filmList.postValue(ViewState.Loading())

        try {
            val response = repository.queryFilmList()
            _filmList.postValue(ViewState.Success(response))
        } catch (e: ApolloException) {
            Log.d("ApolloException", "Failure", e)
            _filmList.postValue(ViewState.Error("Error fetching films"))
        }
    }
}