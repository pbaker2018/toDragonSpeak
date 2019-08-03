package com.baker.todragonspeak

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.*
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun translatePhrase(view: View) {
        if (editText.text.isNotEmpty()) {
            val phrase = editText.text.toString()
            val editedPhrase = phrase.replace (Regex ("[aeiouAEIOU]")) {
                when (it.value) {
                    "a" -> "4"
                    "A" -> "4"
                    "e" -> "3"
                    "E" -> "3"
                    "i" -> "1"
                    "I" -> "1"
                    "O" -> "0"
                    "o" -> "0"
                    "u" -> "|_|"
                    "U" -> "|_|"
                    else -> it.value
                }
            }
            resultText.text = editedPhrase.toString()

        } else {
            resultText.text = "No phrase given"
        }
    }
}
