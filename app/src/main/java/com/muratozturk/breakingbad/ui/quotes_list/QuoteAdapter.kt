package com.muratozturk.breakingbad.ui.quotes_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muratozturk.breakingbad.databinding.ItemQuoteBinding
import com.muratozturk.breakingbad.domain.model.QuoteUI

class QuoteAdapter(private val quote: List<QuoteUI>) :
    RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuoteUI) {
            with(binding) {
                with(item) {
                    quoteCount.text = author
                    quoteText.text = quote
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(quote[position])

    override fun getItemCount(): Int = quote.size
}