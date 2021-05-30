package com.example.roomdb.uiControllers

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdb.R
import com.example.roomdb.WordViewModel
import com.example.roomdb.WordViewModelFactory
import com.example.roomdb.adapter.WordsAdapter
import com.example.roomdb.data.Word
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }
    var adapter: WordsAdapter? = null

    companion object {
        const val REQUEST_CODE_TO_NEWWORDSACTIVITY = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWordsRv()
        setupObserver()
        setupFab()
    }

    private fun setupWordsRv() {
        rvWords.layoutManager = LinearLayoutManager(this)
        adapter = WordsAdapter()
        rvWords.adapter = adapter
    }

    private fun setupObserver() {
        wordViewModel.allWords.observe(this, Observer { words ->
            words?.let { adapter?.submitList(it) }
        })
    }

    private fun setupFab() {
        fabWord.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordsActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_TO_NEWWORDSACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_TO_NEWWORDSACTIVITY && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewWordsActivity.EXTRA_REPLY)?.let { reply ->
                val word = Word(reply)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(applicationContext, "Not Saved", Toast.LENGTH_LONG).show()
        }
    }
}