package edu.temple.audiobookplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val title = resources.getStringArray(R.array.title)
        val author = resources.getStringArray(R.array.author)
        val bookList = BookList()

        for(i in 0..9){
            bookList.add(BookObject(title[i],author[i]))
        }

    }
}