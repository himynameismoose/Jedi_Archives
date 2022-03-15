package com.example.jedi_archives.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.jedi_archives.AllFilmsListQuery

class FilmAdapter {
}

class FilmDiffUtil : DiffUtil.ItemCallback<AllFilmsListQuery.Film>() {

    override fun areItemsTheSame(
        oldItem: AllFilmsListQuery.Film,
        newItem: AllFilmsListQuery.Film
    ): Boolean {
        return oldItem.episodeID == newItem.episodeID
    }

    override fun areContentsTheSame(
        oldItem: AllFilmsListQuery.Film,
        newItem: AllFilmsListQuery.Film
    ): Boolean {
        return oldItem == newItem
    }

}