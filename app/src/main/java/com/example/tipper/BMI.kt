package com.example.tipper

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// for EditText event handling
// EditText listener
// for bill amount input
// for changing the tip percentage
// SeekBar listener
// for displaying text
// for currency formatting
class BMI : AppCompatActivity() {
    // currency and percent formatter objects
    private var weight = 65.0
    private var height = 165.0
    private var heightTextView: TextView? = null
    private var weightTextView: TextView? = null
    private var bmiTextView: TextView? = null

    // called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.activity_main) // inflate the GUI

        // get references to programmatically manipulated TextViews
        bmiTextView = findViewById<View>(R.id.bmiTextView) as TextView
        bmiTextView!!.setText(R.string.total)
        weightTextView = findViewById<View>(R.id.weightTextView) as TextView
        heightTextView = findViewById<View>(R.id.heightTextView) as TextView
        // set weightEditText's TextWatcher
        val weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)

        // set heightEditText's TextWatcher
        val heightEditText = findViewById<View>(R.id.heightEditText) as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)
    }

    // calculate and display BMI
    private fun calculate() {
        // calculate the BMI
        val bmi = weight / (height * height)

        // display tip and total formatted as currency
        bmiTextView!!.text = String.format(bmi.toString())
    }

    // listener object for the EditText's text-changed events
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        // called when the user modifies the bill amount
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try { // get weight and display value
                weight = s.toString().toDouble()
                weightTextView!!.text = String.format(weight.toString())
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                weightTextView!!.text = ""
                weight = 0.0
            }
            calculate() // update the bmi TextView
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                height = s.toString().toDouble() / 100.0
                heightTextView!!.text = String.format(height.toString())
            } catch (e: NumberFormatException) { // if s is empty or non-numeric
                heightTextView!!.text = ""
                height = 0.0
            }
            calculate() // update the tip and total TextViews
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
}