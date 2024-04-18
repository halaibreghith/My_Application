package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the ListView
        ListView listView = findViewById(R.id.listView);

        // Define the items to display in the ListView
        String[] items = {"Letters", "Exercises"}; // Add more options if needed

        // Create an ArrayAdapter to bind the items to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set item click listener to handle item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item clicks
                if (position == 0) {
                    // Open LettersActivity
                    Intent intent = new Intent(MainActivity.this, LettersActivity.class);
                    startActivity(intent);
                } else if (position == 1) {
                    // Open ExercisesActivity
                    Intent intent = new Intent(MainActivity.this, ExercisesActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
