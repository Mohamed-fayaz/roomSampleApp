package com.example.guideapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    private val newWordActivityRequestCode = 1
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }
    private lateinit var wordrv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editWordView =findViewById<EditText>(R.id.editTextTextPersonName)
         wordrv = findViewById<RecyclerView>(R.id.wordrv)
        wordrv.layoutManager = LinearLayoutManager(this)
        wordViewModel.allWords.observe(this, Observer { words ->

            val newString :MutableList<String> = mutableListOf("helli")
                 words.forEach() {  newString.add(it.word) }
            val newString1 = newString.joinToString("\n")


            wordrv.adapter = WordViewAdapter(this,words)
            wordrv.adapter!!.notifyDataSetChanged()

        })
        button.setOnClickListener {
                val newWord = Word(editWordView.text.toString())
                wordViewModel.insert(newWord)

            editWordView.setText("");


        }

        }


}