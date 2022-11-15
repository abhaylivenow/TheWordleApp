package com.example.wordleapptest

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.wordleapptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        keepPassingFocus()

        binding.edt15.addTextChangedListener {
            validateTheRow(
                binding.edt11,binding.edt12,binding.edt13,binding.edt14,binding.edt15
            )
        }

        binding.edt25.addTextChangedListener {
            validateTheRow(
                binding.edt21,binding.edt22,binding.edt23,binding.edt24,binding.edt25
            )
        }

        binding.edt35.addTextChangedListener {
            validateTheRow(
                binding.edt31,binding.edt32,binding.edt33,binding.edt34,binding.edt35
            )
        }

        binding.edt45.addTextChangedListener {
            validateTheRow(
                binding.edt41,binding.edt42,binding.edt43,binding.edt44,binding.edt45
            )
        }

        binding.edt55.addTextChangedListener {
            validateTheRow(
                binding.edt51,binding.edt52,binding.edt53,binding.edt54,binding.edt55
            )
        }

        binding.edt65.addTextChangedListener {
            validateTheRow(
                binding.edt61,binding.edt62,binding.edt63,binding.edt64,binding.edt65
            )
        }

    }

    private fun validateTheRow(
        edt1: EditText,
        edt2: EditText,
        edt3: EditText,
        edt4: EditText,
        edt5: EditText,
    ) {
        val edt1Text = edt1.text.toString()
        val edt2Text = edt2.text.toString()
        val edt3Text = edt3.text.toString()
        val edt4Text = edt4.text.toString()
        val edt5Text = edt5.text.toString()

        val word1 = WORD[0].toString()
        val word2 = WORD[1].toString()
        val word3 = WORD[2].toString()
        val word4 = WORD[3].toString()
        val word5 = WORD[4].toString()

        if(edt1Text == word2 || edt1Text == word3 || edt1Text == word4 || edt1Text == word5) {
            edt1.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt2Text == word1 || edt2Text == word3 || edt2Text == word4 || edt2Text == word5) {
            edt2.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt3Text == word1 || edt3Text == word2 || edt3Text == word4 || edt3Text == word5) {
            edt3.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt4Text == word1 || edt4Text == word2 || edt4Text == word3 || edt4Text == word5) {
            edt4.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if(edt5Text == word1 || edt5Text == word2 || edt5Text == word3 || edt5Text == word4) {
            edt5.setBackgroundColor(Color.parseColor("#ffff00"))
        }

        if(edt1Text == WORD[0].toString()) {
            edt1.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt2Text == WORD[1].toString()) {
            edt2.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt3Text == WORD[2].toString()) {
            edt3.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt4Text == WORD[3].toString()) {
            edt4.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if(edt5Text == WORD[4].toString()) {
            edt5.setBackgroundColor(Color.parseColor("#33cc33"))
        }

        if(edt1Text != word1 && edt1Text != word2 && edt1Text != word3 && edt1Text != word4 && edt1Text != word5) {
            edt1.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt2Text != word1 && edt2Text != word2 && edt2Text != word3 && edt2Text != word4 && edt2Text != word5) {
            edt2.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt3Text != word1 && edt3Text != word2 && edt3Text != word3 && edt3Text != word4 && edt3Text != word5) {
            edt3.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt4Text != word1 && edt4Text != word2 && edt4Text != word3 && edt4Text != word4 && edt4Text != word5) {
            edt4.setBackgroundColor(Color.parseColor("#ff3333"))
        }
        if(edt5Text != word1 && edt5Text != word2 && edt5Text != word3 && edt5Text != word4 && edt5Text != word5) {
            edt5.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if(edt1Text == word1 && edt2Text == word2 && edt3Text == word3 && edt4Text == word4 && edt5Text == word5) {
            Toast.makeText(this, "Congratulations, You Guessed The Word Right!!", Toast.LENGTH_SHORT).show()
            binding.text.visibility = View.VISIBLE
            binding.text.text = "Congratulations, You Guessed The Word Right!!"
            makeGameInactive()
            return
        }

        if(edt5.id == R.id.edt_65) {
            Toast.makeText(this, "Sorry, You couldn't guess the word :((", Toast.LENGTH_SHORT).show()
            binding.text.visibility = View.VISIBLE
            binding.text.text = "Sorry, You couldn't guess the word :(("
            makeGameInactive()
            return
        }
    }

    private fun passFocusToNextEditText(
        edt1: EditText,
        edt2: EditText
    ) {
        edt1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (s.length == 1) {
                    edt2.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {}

            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) {}
        })
    }

    private fun makeGameInactive() {
        binding.edt11.isEnabled = false
        binding.edt12.isEnabled = false
        binding.edt13.isEnabled = false
        binding.edt14.isEnabled = false
        binding.edt15.isEnabled = false
        binding.edt21.isEnabled = false
        binding.edt22.isEnabled = false
        binding.edt23.isEnabled = false
        binding.edt24.isEnabled = false
        binding.edt25.isEnabled = false
        binding.edt31.isEnabled = false
        binding.edt32.isEnabled = false
        binding.edt33.isEnabled = false
        binding.edt34.isEnabled = false
        binding.edt35.isEnabled = false
        binding.edt41.isEnabled = false
        binding.edt42.isEnabled = false
        binding.edt43.isEnabled = false
        binding.edt44.isEnabled = false
        binding.edt45.isEnabled = false
        binding.edt51.isEnabled = false
        binding.edt52.isEnabled = false
        binding.edt53.isEnabled = false
        binding.edt54.isEnabled = false
        binding.edt55.isEnabled = false
        binding.edt61.isEnabled = false
        binding.edt62.isEnabled = false
        binding.edt63.isEnabled = false
        binding.edt64.isEnabled = false
        binding.edt65.isEnabled = false
    }

    private fun keepPassingFocus() {
        passFocusToNextEditText(binding.edt11,binding.edt12)
        passFocusToNextEditText(binding.edt12,binding.edt13)
        passFocusToNextEditText(binding.edt13,binding.edt14)
        passFocusToNextEditText(binding.edt14,binding.edt15)

        passFocusToNextEditText(binding.edt21,binding.edt22)
        passFocusToNextEditText(binding.edt22,binding.edt23)
        passFocusToNextEditText(binding.edt23,binding.edt24)
        passFocusToNextEditText(binding.edt24,binding.edt25)

        passFocusToNextEditText(binding.edt31,binding.edt32)
        passFocusToNextEditText(binding.edt32,binding.edt33)
        passFocusToNextEditText(binding.edt33,binding.edt34)
        passFocusToNextEditText(binding.edt34,binding.edt35)

        passFocusToNextEditText(binding.edt41,binding.edt42)
        passFocusToNextEditText(binding.edt42,binding.edt43)
        passFocusToNextEditText(binding.edt43,binding.edt44)
        passFocusToNextEditText(binding.edt44,binding.edt45)

        passFocusToNextEditText(binding.edt51,binding.edt52)
        passFocusToNextEditText(binding.edt52,binding.edt53)
        passFocusToNextEditText(binding.edt53,binding.edt54)
        passFocusToNextEditText(binding.edt54,binding.edt55)

        passFocusToNextEditText(binding.edt61,binding.edt62)
        passFocusToNextEditText(binding.edt62,binding.edt63)
        passFocusToNextEditText(binding.edt63,binding.edt64)
        passFocusToNextEditText(binding.edt64,binding.edt65)
    }

    companion object {
        val WORD = "dubai"
    }
}