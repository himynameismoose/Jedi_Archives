package com.example.jedi_archives.view.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jedi_archives.FilmListQuery
import com.example.jedi_archives.databinding.ItemFilmBinding

class FilmAdapter {

}

class FilmViewHolder(val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root)

class FilmDiffUtil : DiffUtil.ItemCallback<FilmListQuery.Film>() {
    override fun areItemsTheSame(
        oldItem: FilmListQuery.Film,
        newItem: FilmListQuery.Film
    ): Boolean {
        return oldItem.episodeID == newItem.episodeID
    }

    override fun areContentsTheSame(
        oldItem: FilmListQuery.Film,
        newItem: FilmListQuery.Film
    ): Boolean {
        return oldItem == newItem
    }
}