package com.example.tipper;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Recipe extends AppCompatActivity {
    public Recipe() {
    }

    private List<String> ingredients = List.of("Eggs: 2", "Bread: 2 loaves", "Green Onions: 1", "Butter: 1 Tablespoon");

    private List<String> steps = List.of("Break eggs and put them in a bowl. Mix thoroughly", "Heat up pan with butter", "Fry egg slurry in a pan until cooked, but still moist", "Garnish with green onions");
    ;

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public String generateIngredientsText () {
        return String.join("\n", this.ingredients);
    }

    public String generateRecipe () {
        return String.join("\n", this.steps);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_layout);
        TextView ingredientsList = findViewById(R.id.recipeIngredients);
        TextView stepsList = findViewById(R.id.recipeSteps);

        ingredientsList.setText(generateIngredientsText());
        stepsList.setText(generateRecipe());
    }
}
