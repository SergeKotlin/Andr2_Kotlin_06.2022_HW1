package com.example.andr2_kotlin_062022_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button

open class MainActivity : AppCompatActivity() {
    // Все классы по-умолчанию final. Т.о для насладования явно прописывается open
    private var javaBtn: Button? = null
    internal var kotlinBtn: Button? = null // internal - видимость внутри модуля (узко-полезно, при разраб. библиотек)
    private val data = TrainingDataClass().copy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setClickListeners()
        showDestinationInfo()
        showObjectVariables()
    }

    private fun setClickListeners() {
        javaBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, JavaActivity::class.java)
            startActivity(intent)
        }
        kotlinBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, KotlinActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        javaBtn = findViewById(R.id.java_btn)
        kotlinBtn = findViewById(R.id.kotlin_btn)
    }

    private fun showDestinationInfo() {
        Log.d("@@@", "-------- Destination Info: --------" +
                "\nWhenIllFoundDeveloperJob: ${data.whenIllFoundDeveloperJob}" +
                "\nHowMuchMoneyWillIEarn: ${data.howMuchMoneyWillIEarn}")
    }

    private fun showObjectVariables() {
        Log.d("@@@", "-------- Лог проверки циклов --------")
        for (i in firstArray) { Log.d("@@@", "$i") }
        Log.d("@@@", "-------- другой: --------")
        for (i in firstArray.size-1 downTo 0 step 2) { Log.d("@@@", "${firstArray[i]}") }
        Log.d("@@@", "-------- Конец проверки. --------")
    }

    companion object Arrays { // статика
        const val sizeArray = 4 // const - скомпилировано на этапе компиляции, а не выполнения программы
        val firstArray = arrayOf(1, 2, 3, 4)
    }
}

/* Задание.
✓ 1. Создать новый проект в Android Studio без поддержки Kotlin.
✓ 2. Сконфигурировать Kotlin в новом проекте (лучше вручную).
✓ 3. Перевести MainActivity на Kotlin. (Shift, Shift -> enter "kotlin" -> "Convert Java File to Kotlin File")
✓ 4. Добавить кнопку в разметку и повесить на неё clickListener в Activity.
 ✓ 5. Потренироваться в создании классов и функций, описанных в уроке, и убедиться, что всё работает. Например, создать тестовое приложение:
    ✓ a. Сформировать data class с двумя свойствами и вывести их на экран приложения.
    ✓ b. Создать Object. В Object вызвать copy и вывести значения скопированного класса на экран.
    ✓ c. Вывести значения из разных циклов в консоль, используя примеры из методических материалов.
✓ 6. 7. вместо 6.
✓ 7. Изучить API базы данных с фильмами и зарегистрироваться в качестве разработчика, получить свой ключ разработчика.
✓ 8. Определиться с экранами и инструментарием своего будущего приложения с фильмами на основе возможностей API.
✓ Задача для дополнительного обучения
    ✓ Переведите проект с заметками на Kotlin. Курс «Базовый уровень».*/
//______
// Serega, sure.
// Thx, Kira