package com.example.andr2_kotlin_062022_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button javaBtn;
    private Button kotlinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setClickListeners();
    }

    private void setClickListeners() {
        javaBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, JavaActivity.class);
            startActivity(intent);
        });

        kotlinBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, KotlinActivity.class);
            startActivity(intent);
        });
    }

    private void initViews(){
        javaBtn = findViewById(R.id.java_btn);
        kotlinBtn = findViewById(R.id.kotlin_btn);
    }
}

/* Задание.
✓ 1. Создать новый проект в Android Studio без поддержки Kotlin.
2. Сконфигурировать Kotlin в новом проекте (лучше вручную).
        3. Перевести MainActivity на Kotlin.
        4. Добавить кнопку в разметку и повесить на неё clickListener в Activity.
        5. Потренироваться в создании классов и функций, описанных в уроке, и убедиться, что всё работает. Например, создать тестовое приложение:
        a. Сформировать data class с двумя свойствами и вывести их на экран приложения.
        b. Создать Object. В Object вызвать copy и вывести значения скопированного класса на экран.
        c. Вывести значения из разных циклов в консоль, используя примеры из методических материалов.
        6. Изучить API погоды «Яндекса», посмотреть примеры и зарегистрироваться в качестве разработчика, получить свой ключ разработчика.
        7. Изучить API базы данных с фильмами и зарегистрироваться в качестве разработчика, получить свой ключ разработчика.
        8. Определиться с экранами и инструментарием своего будущего приложения с фильмами на основе возможностей API.
        Задача для дополнительного обучения
        Переведите проект с заметками на Kotlin. Курс «Базовый уровень».*/