package com.example.andr2_kotlin_062022_hw1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class TrainingDataClass(
    var whenIllFoundDeveloperJob: Date = Date(2022, 8, 1),
    var howMuchMoneyWillIEarn: String = "In relation to.."
): Parcelable {
    val yourDeveloperName = "Serge Kotlin"
    var yourDestination = "California"
    val slogan = "If you want to make God laugh, tell him your plans.."
}

val note = TrainingDataClass(Date(2022, 8, 22), "MAXIMUM")
val noteList: List<TrainingDataClass> = // хитрость, как сделать Лист изменяемым
    (listOf(note, note.copy(howMuchMoneyWillIEarn = "for start - 1000$")) as MutableList)
// Все коллекции Kotlin по-умолчанию неизменяемые. Им нужно явно прописывать .toMutableList()

// Функциональное программирование - это удобство. Как переменные и конструкторы рядом.
val array = arrayOf(1, 2, 3, 4) // Пример
val filteredArray = array.filter {it == 2} // Список, где каждое значание равно 2
