package com.example.tipper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BenedictHarris extends AppCompatActivity {
    private double weight = 0.0;
    private double height = 0.15;
    private int age = 0;
    private boolean isMale = false;

    private TextView heightTextView;
    private TextView weightTextView;
    private TextView ageTextView;
    private TextView totalTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benedict_harris_layout);

        Switch genderSwitch = findViewById(R.id.genderSwitch);
        weightTextView = (TextView) findViewById(R.id.weightTextView);
        heightTextView = (TextView) findViewById(R.id.heightTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format(String.valueOf(0)));

        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);
        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        EditText ageEditText =
                (EditText) findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);

        genderSwitch.setOnCheckedChangeListener(switchChangeListener);
    }

    // listeners object for TextViews weight and height text-changed events
    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                weight = Double.parseDouble(s.toString());
                weightTextView.setText(String.format(String.valueOf(weight)));

            } catch (NumberFormatException e) {
                weightTextView.setText("");
                weight = 0.0;

            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
    private final TextWatcher heightEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                height = Double.parseDouble(s.toString());
                heightTextView.setText(String.format(String.valueOf(height)));
            } catch (NumberFormatException e) {
                heightTextView.setText("");
                height = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private final TextWatcher ageEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                age = Integer.parseInt(s.toString());
                ageTextView.setText(String.format(String.valueOf(age)));
            } catch (NumberFormatException e) {
                age = 0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private final CompoundButton.OnCheckedChangeListener switchChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            try {
                isMale = isChecked;
            } catch (Exception e) {
                isMale = false;
            }
            calculate();
        }
    };

    public void calculate() {
        double total = 0.00;

        if (isMale) {
            total = 66.47 + (13.7 * weight) + (5.0 * height) - (6.76 * age);
        } else {
            total = 655.1 + (9.567 * weight) + (1.95 * height) - (4.68 * age);
        }

        totalTextView.setText(String.format(String.valueOf(total)));
    }
}
