package com.example.jedi_archives.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jedi_archives.FilmListQuery
import com.example.jedi_archives.R
import com.example.jedi_archives.databinding.ItemFilmBinding

class FilmAdapter : ListAdapter<FilmListQuery.Film, FilmViewHolder>(FilmDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding: ItemFilmBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_film,
            parent,
            false
        )

        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.binding.film = getItem(position)
    }

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