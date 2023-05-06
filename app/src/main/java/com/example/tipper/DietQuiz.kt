package com.example.tipper

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class DietQuiz : AppCompatActivity() {
    private var questionTextView: TextView? = null
    private var optionTrue: Button? = null
    private var optionFalse: Button? = null
    private var questionIndex = 0
    private var question = 0
    private var score = 0
    private var statsTextView: TextView? = null
    private val questions = arrayOf(
        QuestionModel(R.string.q1, true),
        QuestionModel(R.string.q2, true),
        QuestionModel(R.string.q3, false),
        QuestionModel(R.string.q4, true),
        QuestionModel(R.string.q5, false),
        QuestionModel(R.string.q6, false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_layout)
        questionTextView = findViewById(R.id.questionText)
        val q1 = questions[questionIndex]
        question = q1.question
        questionTextView!!.setText(question)
        statsTextView = findViewById(R.id.quizStats)
        optionTrue = findViewById(R.id.buttonTrue)
        optionTrue!!.setOnClickListener(View.OnClickListener { view: View? ->
            evaluateAnswer(true)
            changeQuestion()
        })
        optionFalse = findViewById(R.id.buttonFalse)
        optionFalse!!.setOnClickListener(View.OnClickListener { view: View? ->
            evaluateAnswer(false)
            changeQuestion()
        })
    }

    private fun changeQuestion() {
        questionIndex = (questionIndex + 1) % 6
        if (questionIndex == 0) {
            val alert = AlertDialog.Builder(this)
            alert.setCancelable(false)
            alert.setTitle(getString(R.string.onFinish))
            alert.setMessage(getString(R.string.result) + score)
            alert.setPositiveButton(getString(R.string.finish)) { dialog, which -> finish() }
            alert.show()
        }
        question = questions[questionIndex].question
        questionTextView!!.setText(question)
        statsTextView!!.text = "$score/ 6"
    }

    private fun evaluateAnswer(userAnswer: Boolean) {
        val currentQuestionAnswer = questions[questionIndex].isAnswer
        if (currentQuestionAnswer == userAnswer) {
            score = score + 1
        }
    }
}