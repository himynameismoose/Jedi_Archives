package com.example.jedi_archives.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.jedi_archives.AllFilmsQuery

class FilmAdapter {

}

class FilmDiffUtil : DiffUtil.ItemCallback<AllFilmsQuery.AllFilms>() {
    override fun areItemsTheSame(
        oldItem: AllFilmsQuery.AllFilms,
        newItem: AllFilmsQuery.AllFilms
    ): Boolean {
        return oldItem.__typename == newItem.__typename
    }

    override fun areContentsTheSame(
        oldItem: AllFilmsQuery.AllFilms,
        newItem: AllFilmsQuery.AllFilms
    ): Boolean {
        return oldItem == newItem
    }
}