package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listView);


        String[] items = {"Letters", "Exercises"};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);


        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {

            if (position == 0) {

                Intent intent = new Intent(MainActivity.this, LettersActivity.class);
                startActivity(intent);
            } else if (position == 1) {

                Intent intent = new Intent(MainActivity.this, ExercisesActivity.class);
                startActivity(intent);
            }
        });
    }
}