package com.example.andr2_kotlin_062022_hw1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// (Shift, Shift -> enter "kotlin" -> "Convert Java File to Kotlin File")
class KotlinActivity : AppCompatActivity() { // public по-умолчанию // наследуемся от конструктора
    // ? м.б Null;
    // !! обещаю, что не Null
    // lateinit костыль прокрастинатора, "попозже задам"
    private var plusBtn: Button? = null
    private var counterTextView: TextView? = null
    private var counter = 0 // для лонг следует явно прописать "0L", иначен не скастует

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        initViews()
        setUniqueDecoration()

//              Если у интерфейса только один метод, то возможно лямбда выражение
//        plusBtn!!.setOnClickListener { updateCounterTextView(++counter) }
//              - при чём, если у лямбда лишь 1 аргумент (view),
//              к нему остаётся неявное обращение через "it".
//        plusBtn!!.setOnClickListener() { view: View -> updateCounterTextView(++counter) }
//        plusBtn!!.setOnClickListener({ view: View -> updateCounterTextView(++counter) })
        plusBtn!!.setOnClickListener(object : View.OnClickListener {  // object - синглотон, "анонимный разовый класс" (но это не точно)
            override fun onClick(p0: View) {
                updateCounterTextView(++counter)
                setKotlinFail()

            }
        })

        // Потоко-безопасная проверка на Nullable для Kotlin
        plusBtn?.text = "+"
        // или
        plusBtn?.let {
            it.text="+" // под капотом, вспоминаем, для property уже заданы сеттер и геттер. Просто полей нет (как в Java)
        }
    }

    private fun initViews() {
        plusBtn = findViewById(R.id.plus_btn)
        counterTextView = findViewById(R.id.counter_text_view)
    }

    private fun setUniqueDecoration() { counterTextView!!.setTextColor(Color.BLUE) }

    private fun setKotlinFail() {
        // (It's Joke.. Don't worry)
        if (counter in 3..6) {
            counterTextView!!.setTextColor(MyClassExternalSingleton.giveBangColor())
        }
    }

    private fun updateCounterTextView(counter: Int): Unit {
        // :Unit тип возвращаемоего значения. Не указано - тогда как бы void в Java.
        // P.s Unit, Nothing - тип "ничего"
        counterTextView!!.text = counter.toString()
    }
}

object MyClassExternalSingleton {
    init { // в этом блоке описываются действия при создании объекта
        Log.d("@@@", "Добро пожаловать во внешний синглтон. Побалуемся с цветами")
    }

    fun giveBangColor(): Int  {
        val usageColor = Color.CYAN
        Log.d("@@@", "Исправлены цвета $usageColor на странице")
        return usageColor
    }
}

class Usage (private val num: Long) : View.OnClickListener {
    constructor() : this(0) // опциональные конструкторы
    constructor(name: String) : this(0)
    constructor(num:Long, name: String) : this(num)

    val doubleNum = doSomething(num, Any())

    override fun onClick(v: View) {
//        doSomething(num, Any()) // здесь num не видно, поэтому в конструкторе класса добавили "private val"
        doSomething( // по приколу изменим порядок аргументов
            obj = Any(),
            num = num
        )

        doSomething(0L) // в случаее со вторым аргументом Null
    }

    private fun doSomething(num: Long, obj: Any? = null): String = "Learn Kotlin for HaPpY ${num + 2}"
}