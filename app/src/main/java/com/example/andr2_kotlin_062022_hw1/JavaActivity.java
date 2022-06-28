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
        updateCounterTextView(counter);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                updateCounterTextView(counter);
                setJavaFail();
            }
        });

        // Потоко-безопасная проверка на Nullable для Java,
        // Кэшируем проверяемую переменную
        final Button tmpPlusBtn = plusBtn;
        if (tmpPlusBtn != null) {
            tmpPlusBtn.setText("+");
        }
    }

    private void initViews() {
        plusBtn = findViewById(R.id.plus_btn);
        counterTextView = findViewById(R.id.counter_text_view);
    }

    private void setUniqueDecoration() {
        counterTextView.setTextColor(Color.GREEN);
    }

    private void updateCounterTextView(int counter) {
        counterTextView.setText(String.valueOf(counter));
    }

    private void setJavaFail() {
        // (It's Joke.. Don't worry)
        if  (counter > 2 & counter < 5) {
            final int usageColor = MyClassExternalSingleton.INSTANCE.giveBangColor();
            counterTextView.setTextColor(usageColor);
        }
    }
}