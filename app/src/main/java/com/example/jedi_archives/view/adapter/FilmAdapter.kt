package com.example.jedi_archives.view.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jedi_archives.AllFilmsListQuery
import com.example.jedi_archives.databinding.ItemFilmBinding

class FilmAdapter {
}

class FilmViewHolder(val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root)

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