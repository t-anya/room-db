package com.example.roomdb.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.roomdb.data.Word

class WordsComparator: DiffUtil.ItemCallback<Word>() {
    override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
        return oldItem.word == newItem.word
    }
}