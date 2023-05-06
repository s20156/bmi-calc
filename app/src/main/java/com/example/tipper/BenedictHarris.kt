package com.example.tipper

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BenedictHarris : AppCompatActivity() {
    private var weight = 0.0
    private var height = 0.15
    private var age = 0
    private var isMale = false
    private var heightTextView: TextView? = null
    private var weightTextView: TextView? = null
    private var ageTextView: TextView? = null
    private var totalTextView: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.benedict_harris_layout)
        val genderSwitch = findViewById<Switch>(R.id.genderSwitch)
        weightTextView = findViewById<View>(R.id.weightTextView) as TextView
        heightTextView = findViewById<View>(R.id.heightTextView) as TextView
        ageTextView = findViewById<View>(R.id.ageTextView) as TextView
        totalTextView = findViewById<View>(R.id.totalTextView) as TextView
        totalTextView!!.text = String.format(0.toString())
        val weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)
        val heightEditText = findViewById<View>(R.id.heightEditText) as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)
        val ageEditText = findViewById<View>(R.id.ageEditText) as EditText
        ageEditText.addTextChangedListener(ageEditTextWatcher)
        genderSwitch.setOnCheckedChangeListener(switchChangeListener)
    }

    // listeners object for TextViews weight and height text-changed events
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                weight = s.toString().toDouble()
                weightTextView!!.text = String.format(weight.toString())
            } catch (e: NumberFormatException) {
                weightTextView!!.text = ""
                weight = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                height = s.toString().toDouble()
                heightTextView!!.text = String.format(height.toString())
            } catch (e: NumberFormatException) {
                heightTextView!!.text = ""
                height = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
    }
    private val ageEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            try {
                age = s.toString().toInt()
                ageTextView!!.text = String.format(age.toString())
            } catch (e: NumberFormatException) {
                age = 0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
    }
    private val switchChangeListener =
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            isMale = try {
                isChecked
            } catch (e: Exception) {
                false
            }
            calculate()
        }

    fun calculate() {
        var total = 0.00
        total = if (isMale) {
            66.47 + 13.7 * weight + 5.0 * height - 6.76 * age
        } else {
            655.1 + 9.567 * weight + 1.95 * height - 4.68 * age
        }
        totalTextView!!.text = String.format(total.toString())
    }
}