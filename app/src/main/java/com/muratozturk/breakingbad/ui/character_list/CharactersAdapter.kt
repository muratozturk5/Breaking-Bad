package com.muratozturk.breakingbad.ui.character_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muratozturk.breakingbad.common.glideImage
import com.muratozturk.breakingbad.databinding.ItemCharacterBinding
import com.muratozturk.breakingbad.domain.model.CharacterUI

class CharactersAdapter(private var characterList: ArrayList<CharacterUI>) :
    RecyclerView.Adapter<CharactersAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(val itemBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    var onClick: (Int) -> Unit = {}

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemCharacterBinding.inflate(layoutInflater, parent, false)
        return ProductsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val item = characterList[position]

        holder.itemBinding.apply {
            text.text = item.name
            imageView.glideImage(item.img)
            root.setOnClickListener { onClick(item.charId) }
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}