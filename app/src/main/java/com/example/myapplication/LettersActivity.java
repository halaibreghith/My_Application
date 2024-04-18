package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LettersActivity extends AppCompatActivity {

    private ImageView imageViewLetter;
    private Button btnPrev, btnNext;
    private TextView textViewLetter;
    private char currentLetter = 'A';
    private String[] images = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        imageViewLetter = findViewById(R.id.imageViewLetter);
        textViewLetter = findViewById(R.id.textViewLetter);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);

        // Load the first letter
        loadLetter(currentLetter);

        // Set click listeners for prev and next buttons
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load previous letter
                loadPreviousLetter();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load next letter
                loadNextLetter();
            }
        });
    }

    private void loadPreviousLetter() {
        if (currentLetter == 'A')
            currentLetter = 'Z';
        else
            currentLetter--;
        loadLetter(currentLetter);
    }

    private void loadNextLetter() {
        if (currentLetter == 'Z')
            currentLetter = 'A';
        else
            currentLetter++;
        loadLetter(currentLetter);
    }

    private void loadLetter(char letter) {
        // Load letter image
        int imageResource = getResources().getIdentifier(images[letter - 'a'], "drawable", getPackageName());
        imageViewLetter.setImageResource(imageResource);

        // Set letter text
        textViewLetter.setText(Character.toString(Character.toUpperCase(letter)));
    }

    private void updateLetter(char letter) {
        textViewLetter.setText(String.valueOf(letter));
        int imageResourceId = getImageResourceId(letter);
        if (imageResourceId != 0) {
            imageViewLetter.setImageResource(imageResourceId);
        } else {
            imageViewLetter.setImageResource(R.drawable.english);
        }
    }

    private int getImageResourceId(char letter) {
        switch (letter) {
            case 'a':
                return R.drawable.a;
            case 'b':
                return R.drawable.b;
            case 'c':
                return R.drawable.c;
            case 'd':
                return R.drawable.d;
            case 'e':
                return R.drawable.e;
            case 'f':
                return R.drawable.f;
            case 'g':
                return R.drawable.g;
            case 'h':
                return R.drawable.h;
            case 'i':
                return R.drawable.i;
            case 'j':
                return R.drawable.j;
            case 'k':
                return R.drawable.k;
            case 'l':
                return R.drawable.l;
            case 'm':
                return R.drawable.m;
            case 'n':
                return R.drawable.n;
            case 'o':
                return R.drawable.o;
            case 'p':
                return R.drawable.p;
            case 'q':
                return R.drawable.q;
            case 'r':
                return R.drawable.r;
            case 's':
                return R.drawable.s;
            case 't':
                return R.drawable.t;
            case 'u':
                return R.drawable.u;
            case 'v':
                return R.drawable.v;
            case 'w':
                return R.drawable.w;
            case 'x':
                return R.drawable.x;
            case 'y':
                return R.drawable.y;
            case 'z':
                return R.drawable.z;
            default:
                return R.drawable.english; // Return 0 if no image found
        }
    }
}
