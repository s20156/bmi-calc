package com.example.tipper;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;

public class DietQuiz extends AppCompatActivity {
    private TextView questionTextView;
    private Button optionTrue;
    private Button optionFalse;
    private int questionIndex;
    private int question;
    private int score;
    private TextView statsTextView;

    private final QuestionModel[] questions = new QuestionModel[]{
            new QuestionModel((R.string.q1), true),
            new QuestionModel((R.string.q2), true),
            new QuestionModel((R.string.q3), false),
            new QuestionModel((R.string.q4), true),
            new QuestionModel((R.string.q5), false),
            new QuestionModel((R.string.q6), false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        questionTextView = findViewById(R.id.questionText);
        QuestionModel q1 = questions[questionIndex];
        question = q1.getQuestion();
        questionTextView.setText(question);
        statsTextView = findViewById(R.id.quizStats);

        optionTrue = findViewById(R.id.buttonTrue);
        optionTrue.setOnClickListener(view -> {
            evaluateAnswer(true);
            changeQuestion();
        });

        optionFalse = findViewById(R.id.buttonFalse);
        optionFalse.setOnClickListener(view -> {
            evaluateAnswer(false);
            changeQuestion();
        });
    }

    private void changeQuestion() {
        questionIndex = (questionIndex + 1) % 6;
        if (questionIndex == 0) {
            Builder alert = new Builder(this);
            alert.setCancelable(false);
            alert.setTitle(getString(R.string.onFinish));
            alert.setMessage(getString(R.string.result) + score);
            alert.setPositiveButton(getString(R.string.finish), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }
        question = questions[questionIndex].getQuestion();
        questionTextView.setText(question);
        statsTextView.setText(score + "" + "/ 6");
    }

    private void evaluateAnswer(boolean userAnswer) {
        boolean currentQuestionAnswer = questions[questionIndex].isAnswer();
        if (currentQuestionAnswer == userAnswer) {
            score = score + 1;
        }
    }
}
