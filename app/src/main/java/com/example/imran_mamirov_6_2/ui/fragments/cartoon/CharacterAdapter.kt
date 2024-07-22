package com.example.imran_mamirov_6_2.ui.fragments.cartoon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imran_mamirov_6_2.R
import com.example.imran_mamirov_6_2.data.model.Character
import com.example.imran_mamirov_6_2.databinding.ItemCharactersBinding
import com.example.imran_mamirov_6_2.ui.interfaces.OnClick

class CharacterAdapter(private val onClick: OnClick) : ListAdapter<Character, CharacterAdapter.ViewHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
        holder.itemView.setOnClickListener {
            onClick.onClick(getItem(position))
        }
    }

    inner class ViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(character: Character) = with(binding) {
            characterName.text = character.name
            lastKnownLocation.text = character.location.name
            firstSeenIn.text = character.origin.name
            characterImage.load(character.image) {
                crossfade(true)
            }
            characterStatus.text = character.status
            colorIndicator.setImageResource(
                when {
                    character.status.contains("Dead") -> R.drawable.ic_circle_red
                    character.status.contains("Alive") -> R.drawable.ic_circle_green
                    else -> R.drawable.ic_circle_gray
                }
            )
        }
    }
}
private val diffUtil = object : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Character, newItem: Character) = oldItem == newItem
}