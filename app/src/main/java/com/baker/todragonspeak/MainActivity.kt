package com.baker.todragonspeak

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.*
import android.view.View
import android.widget.Toast
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
            resultTitleTxt.text = "⬇ Dragon Speak RESULT ⬇"
            resultText.text = editedPhrase.toString()

        } else {
            Toast.makeText(this@MainActivity, "No phrase has been entered", Toast.LENGTH_SHORT).show()
        }
    }

    fun clearResult(view: View) {
        if (resultText.text.isNotEmpty()) {
            resultTitleTxt.text = " "
            resultText.text = " "
        } else {
            Toast.makeText(this@MainActivity, "There is nothing to clear", Toast.LENGTH_SHORT).show()
        }
    }
}
