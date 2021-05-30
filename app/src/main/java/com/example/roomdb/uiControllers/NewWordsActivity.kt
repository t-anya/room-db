package com.example.roomdb.uiControllers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdb.R
import kotlinx.android.synthetic.main.lyt_new_word.*

class NewWordsActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lyt_new_word)
        button_save.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(edit_word.text)) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val word = edit_word.text.toString()
                intent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }
}