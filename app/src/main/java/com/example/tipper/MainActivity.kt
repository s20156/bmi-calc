package com.example.tipper

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// for EditText event handling
// EditText listener
// for bill amount input
// for changing the tip percentage
// SeekBar listener
// for displaying text
// for currency formatting
class MainActivity : AppCompatActivity() {
    private var bmiButton: Button? = null
    private var recipeButton: Button? = null
    private var bhButton: Button? = null
    private var quizButton: Button? = null
    private var graphButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call superclass onCreate
        setContentView(R.layout.main_layout)
        bmiButton = findViewById<View>(R.id.bmiButton) as Button
        bhButton = findViewById<View>(R.id.benedictHarris) as Button
        recipeButton = findViewById<View>(R.id.recipe) as Button
        quizButton = findViewById<View>(R.id.quiz) as Button
        graphButton = findViewById<View>(R.id.graph) as Button
        bmiButton!!.setOnClickListener { v: View? -> openBmiActivity() }
        bhButton!!.setOnClickListener { v: View? -> openBHActivity() }
        recipeButton!!.setOnClickListener { v: View? -> openRecipeActivity() }
        quizButton!!.setOnClickListener { v: View? -> openQuizActivity() }
        graphButton!!.setOnClickListener { v: View? -> openGraphActivity() }
    }

    fun openBmiActivity() {
        val intent = Intent(this, BMI::class.java)
        startActivity(intent)
    }

    fun openBHActivity() {
        val intent = Intent(this, BenedictHarris::class.java)
        startActivity(intent)
    }

    fun openRecipeActivity() {
        val intent = Intent(this, Recipe::class.java)
        startActivity(intent)
    }

    fun openQuizActivity() {
        val intent = Intent(this, DietQuiz::class.java)
        startActivity(intent)
    }

    fun openGraphActivity() {
        val intent = Intent(this, Graph::class.java)
        startActivity(intent)
    }
}