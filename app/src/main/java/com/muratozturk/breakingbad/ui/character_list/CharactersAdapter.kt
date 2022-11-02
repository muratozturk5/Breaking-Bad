package com.muratozturk.breakingbad.ui.character_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muratozturk.breakingbad.common.glideImage
import com.muratozturk.breakingbad.databinding.ItemCharacterBinding
import com.muratozturk.breakingbad.domain.model.CharacterUI
import com.muratozturk.click_shrink_effect.applyClickShrink

class CharactersAdapter(private var characterList: ArrayList<CharacterUI>) :
    RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var onClick: (Int) -> Unit = {}

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterUI) {
            with(binding) {
                with(item) {
                    text.text = name
                    imageView.glideImage(img)
                    root.setOnClickListener { onClick(charId) }
                    root.applyClickShrink()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(characterList[position])

    override fun getItemCount(): Int = characterList.size

}