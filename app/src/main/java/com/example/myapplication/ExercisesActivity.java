package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExercisesActivity extends AppCompatActivity {

    private TextView textViewCapitalLetter, textViewQuestion;
    private RadioGroup radioGroupLetters;
    private Button btnNext;
    private char currentLetter = 'A';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        textViewCapitalLetter = findViewById(R.id.textViewCapitalLetter);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroupLetters = findViewById(R.id.radioGroupLetters);
        btnNext = findViewById(R.id.btnNext);

        // Set initial letter
        setLetter(currentLetter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load next letter
                loadNextLetter();
            }
        });
    }

    private void setLetter(char letter) {
        // Set capital letter
        textViewCapitalLetter.setText(String.valueOf(letter));

        // Set question
        textViewQuestion.setText(getString(R.string.question, Character.toLowerCase(letter)));

        // Clear radio group selection
        radioGroupLetters.clearCheck();

        // Set options for small letters
        for (int i = 0; i < radioGroupLetters.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) radioGroupLetters.getChildAt(i);
            radioButton.setText(String.valueOf((char) (letter + i))); // Assuming options start from the capital letter
        }
    }

    private void loadNextLetter() {
        if (currentLetter == 'Z')
            currentLetter = 'A';
        else
            currentLetter++;
        setLetter(currentLetter);
    }
}
