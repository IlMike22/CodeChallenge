package com.mwidlok.codechallenge

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btnOk.setOnClickListener {
            Log.i("CodeChallenge","button clicked")
            searchForPalindroms(txtPalindrom.text.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun searchForPalindroms(textInput : String)
    {
        // seperate the words

        var words = textInput.split(" ")
        var amountPalindroms = 0
        var palindromeString:String = ""

        for (word in words)
        {
            // check every single word if it`s a palindrome.
            var revWord = word.reversed()
            Log.i("Challenge","Reversed string is $revWord")
            for (word in words)
                if (revWord == word)
                {
                    palindromeString += revWord + ","
                    amountPalindroms++
                }

        }

        tvResult.text = "$amountPalindroms palindroms found. $palindromeString"
    }
}
