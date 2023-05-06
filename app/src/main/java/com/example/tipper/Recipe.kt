package com.example.tipper

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.List

class Recipe : AppCompatActivity() {
    var ingredients =
        List.of("Eggs: 2", "Bread: 2 loaves", "Green Onions: 1", "Butter: 1 Tablespoon")
    var steps = List.of(
        "Break eggs and put them in a bowl. Mix thoroughly",
        "Heat up pan with butter",
        "Fry egg slurry in a pan until cooked, but still moist",
        "Garnish with green onions"
    )

    fun generateIngredientsText(): String {
        return java.lang.String.join("\n", ingredients)
    }

    fun generateRecipe(): String {
        return java.lang.String.join("\n", steps)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_layout)
        val ingredientsList = findViewById<TextView>(R.id.recipeIngredients)
        val stepsList = findViewById<TextView>(R.id.recipeSteps)
        ingredientsList.text = generateIngredientsText()
        stepsList.text = generateRecipe()
    }
}