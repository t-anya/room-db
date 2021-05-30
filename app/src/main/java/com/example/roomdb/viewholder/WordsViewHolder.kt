package com.example.roomdb.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.lyt_word_item.view.*

class WordsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val tvWordTitle = view.tvWordTitle
    fun bind(data: String?) {
        tvWordTitle.text = data ?: ""
    }
}