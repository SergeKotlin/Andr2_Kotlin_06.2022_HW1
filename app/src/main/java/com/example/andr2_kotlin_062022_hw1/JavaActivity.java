package com.example.andr2_kotlin_062022_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JavaActivity extends AppCompatActivity {
    private Button plusBtn;
    private TextView counterTextView;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        initViews();
        setUniqueDecoration();

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                updateCounterTextView(counter);
            }
        });
    }

    private void setUniqueDecoration() {
        counterTextView.setTextColor(Color.GREEN);
    }

    private void updateCounterTextView(int counter) {
        counterTextView.setText(String.valueOf(counter));
    }

    private void initViews() {
        plusBtn = findViewById(R.id.plus_btn);
        counterTextView = findViewById(R.id.counter_text_view);
    }
}