package com.example.andrjokelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        String jokeRecieved = getIntent().getStringExtra("Joke");
        TextView jokeTV = findViewById(R.id.joke_txt);

        jokeTV.setText(jokeRecieved);
    }
}