package com.example.jedi_archives.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.jedi_archives.databinding.FragmentFilmListBinding
import com.example.jedi_archives.view.adapter.FilmAdapter
import com.example.jedi_archives.view.state.ViewState
import com.example.jedi_archives.viewmodel.FilmViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class FilmListFragment : Fragment() {
    // properties
    private lateinit var binding: FragmentFilmListBinding
    private val filmAdapter by lazy { FilmAdapter() }
    private val viewModel by viewModels<FilmViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmListBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.charactersRv.adapter = filmAdapter
        viewModel.queryFilmList()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.filmList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is ViewState.Loading -> {
                    binding.charactersRv.visibility = View.GONE
                    binding.charactersFetchProgress.visibility = View.VISIBLE
                }

                is ViewState.Success -> {
                    if (response.value?.data?.allFilms?.films?.size == 0) {
                        filmAdapter.submitList(emptyList())
                        binding.charactersFetchProgress.visibility = View.GONE
                        binding.charactersRv.visibility = View.GONE
                        binding.charactersEmptyText.visibility = View.VISIBLE
                    } else {
                        binding.charactersRv.visibility = View.VISIBLE
                        binding.charactersEmptyText.visibility = View.GONE
                    }

                    val results = response.value?.data?.allFilms?.films
                    filmAdapter.submitList(results)
                    binding.charactersFetchProgress.visibility = View.GONE
                }

                is ViewState.Error -> {
                    filmAdapter.submitList(emptyList())
                    binding.charactersFetchProgress.visibility = View.GONE
                    binding.charactersRv.visibility = View.GONE
                    binding.charactersEmptyText.visibility = View.VISIBLE
                }
            }
        }
    }
}