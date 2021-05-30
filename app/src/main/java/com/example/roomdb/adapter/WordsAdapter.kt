package com.example.roomdb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.roomdb.R
import com.example.roomdb.data.Word
import com.example.roomdb.utils.WordsComparator
import com.example.roomdb.viewholder.WordsViewHolder

class WordsAdapter: ListAdapter<Word, WordsViewHolder>(WordsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        return WordsViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.lyt_word_item,parent,false))
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.bind(getItem(position).word)
    }
}