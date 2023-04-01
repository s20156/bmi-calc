package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // for bill amount input
import android.widget.SeekBar; // for changing the tip percentage
import android.widget.SeekBar.OnSeekBarChangeListener; // SeekBar listener
import android.widget.TextView; // for displaying text

import java.text.NumberFormat; // for currency formatting
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bmiButton;
    private Button recipeButton;
    private Button bhButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.main_layout);
        bmiButton = (Button) findViewById(R.id.bmiButton);
        bhButton = (Button) findViewById(R.id.benedictHarris);
        recipeButton = (Button) findViewById(R.id.recipe);
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBmiActivity();
            }
        });

        bhButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBHActivity();
            }
        });
        recipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecipeActivity();
            }
        });
    };

    public void openBmiActivity() {
        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);
    }
    public void openBHActivity() {
        Intent intent = new Intent(this, BenedictHarris.class);
        startActivity(intent);
    }
    public void openRecipeActivity() {
        Intent intent = new Intent(this, Recipe.class);
        startActivity(intent);
    }
}


/*************************************************************************
 * (C) Copyright 1992-2016 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
