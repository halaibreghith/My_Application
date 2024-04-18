package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class LettersActivity extends AppCompatActivity {

    private ImageView imageViewLetter;
    private Button btnPrev, btnNext;
    private int currentImageIndex = 0;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d, R.drawable.e, R.drawable.f ,R.drawable.g,R.drawable.h, R.drawable.i, R.drawable.j ,R.drawable.k,R.drawable.l, R.drawable.m, R.drawable.n ,R.drawable.o,R.drawable.p, R.drawable.q, R.drawable.r ,R.drawable.s, R.drawable.t ,R.drawable.u,R.drawable.v, R.drawable.w, R.drawable.x , R.drawable.y, R.drawable.z};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        imageViewLetter = findViewById(R.id.imageViewLetter);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);


        imageViewLetter.setImageResource(images[currentImageIndex]);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentImageIndex > 0) {
                    currentImageIndex--;
                    imageViewLetter.setImageResource(images[currentImageIndex]);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImageIndex < images.length - 1) {
                    currentImageIndex++;
                    imageViewLetter.setImageResource(images[currentImageIndex]);
                }
            }
        });
    }
}