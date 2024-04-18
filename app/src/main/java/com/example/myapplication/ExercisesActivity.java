package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ExercisesActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private Button[] optionButtons = new Button[4];

    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String currentLetter;
    private String correctAnswer;
    private String[] options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        optionButtons[0] = findViewById(R.id.btnOption1);
        optionButtons[1] = findViewById(R.id.btnOption2);
        optionButtons[2] = findViewById(R.id.btnOption3);
        optionButtons[3] = findViewById(R.id.btnOption4);


        showNextQuestion();

        for (Button optionButton : optionButtons) {
            optionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button clickedButton = (Button) v;
                    String selectedAnswer = clickedButton.getText().toString();
                    checkAnswer(selectedAnswer);

                    showNextQuestion();
                }
            });
        }
    }

    private void showNextQuestion() {

        Random random = new Random();
        int randomIndex = random.nextInt(letters.length);
        currentLetter = letters[randomIndex].toLowerCase();
        correctAnswer = currentLetter.toLowerCase();

        String question = "What is the capital letter for this letter: " + currentLetter;
        textViewQuestion.setText(question);


        options = new String[4];
        int correctIndex = random.nextInt(4);
        options[correctIndex] = correctAnswer;
        for (int i = 0; i < 4; i++) {
            if (i != correctIndex) {
                options[i] = getRandomLetter().toLowerCase();
            }
        }

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText(options[i].toLowerCase());
        }
    }

    private String getRandomLetter() {
        Random random = new Random();
        int randomIndex = random.nextInt(letters.length);
        return letters[randomIndex].toLowerCase();
    }

    private void checkAnswer(String selectedAnswer) {
        if (selectedAnswer.equals(correctAnswer)) {
            Toast.makeText(ExercisesActivity.this, "Correct Answer !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ExercisesActivity.this, "Wrong Answer !", Toast.LENGTH_SHORT).show();
        }
    }
}

