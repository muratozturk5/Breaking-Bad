package com.muratozturk.breakingbad.ui.episode_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muratozturk.breakingbad.databinding.ItemEpisodeBinding
import com.muratozturk.breakingbad.domain.model.EpisodeUI
import com.muratozturk.click_shrink_effect.applyClickShrink

class EpisodeAdapter(private val episode: List<EpisodeUI>) :
    RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EpisodeUI) {
            with(binding) {
                with(item) {
                    productCount.text = episodeId.toString()
                    productText.text = title
                    root.applyClickShrink()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(episode[position])

    override fun getItemCount(): Int = episode.size


}