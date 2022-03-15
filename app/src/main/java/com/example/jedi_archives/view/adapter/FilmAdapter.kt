package com.example.jedi_archives.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.jedi_archives.AllFilmsQuery

class FilmAdapter {

}

class FilmDiffUtil : DiffUtil.ItemCallback<AllFilmsQuery.Film>() {
    override fun areItemsTheSame(
        oldItem: AllFilmsQuery.Film,
        newItem: AllFilmsQuery.Film
    ): Boolean {
        return oldItem.episodeID == newItem.episodeID
    }

    override fun areContentsTheSame(
        oldItem: AllFilmsQuery.Film,
        newItem: AllFilmsQuery.Film
    ): Boolean {
        return oldItem == newItem
    }
}