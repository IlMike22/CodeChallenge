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
            Log.i("CodeChallenge", "button clicked")
            checkStringForPalindromes(txtPalindrom.text.toString())
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

    private fun checkStringForPalindromes(textInput: String) {
        // all palindorms includingsabc substrings should be detected
        // example: sabcbakd -> abcba is a palindrome
        // even spaces can be a palindrome, you should check substrings with at least 4 chars

        var output: String = ""
        var indexLeft = 0
        for (leftSideLetter in textInput) {
            var indexRight = textInput.length

            indexLeft = textInput.indexOf(leftSideLetter)
            Log.i("cc", "left index is $indexLeft")
            while (indexLeft != indexRight) {
                Log.i("cc", "right index is $indexRight")
                if (leftSideLetter == textInput[indexRight - 1]) {
                    // found same char in string
                    Log.i("cc","check string ${textInput.substring(indexLeft,indexRight)}")
                    var paldrSuspicion = textInput.substring(indexLeft, indexRight)

                    if (paldrSuspicion.length > 2)
                    {
                        var isPalindrome = checkForPalindrome(textInput.substring(indexLeft, indexRight))
                        if (isPalindrome)
                        {
                            Log.i("cc","pal found ${textInput.substring(indexLeft,indexRight)}")
                            output += textInput.substring(indexLeft,indexRight)
                        }
                    }
                }
                indexRight--
            }

            Log.i("cc", leftSideLetter.toString())
            tvResult.text = "Palindroms: $output"
        }
    }


    private fun checkForPalindrome(value: String):Boolean {
        var i = value.length-1
        for (letter in value)
        {
            if (value[i] != letter) // last index vs first index
                return false
            else
                if (i > 0)
                    i--
        }
        return true
    }


//        var words = textInput.split(" ")
//        var amountPalindroms = 0
//        var palindromeString:String = ""
//
//        for (word in words)
//        {
//            // check every single word if it`s a palindrome.
//            var revWord = word.reversed()
//            Log.i("Challenge","Reversed string is $revWord")
//            for (word in words)
//                if (revWord == word)
//                {
//                    palindromeString += revWord + ","
//                    amountPalindroms++
//                }
//
//        }
//
//

}
