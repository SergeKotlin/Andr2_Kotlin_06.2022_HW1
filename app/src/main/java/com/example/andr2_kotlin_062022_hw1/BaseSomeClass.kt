package com.example.andr2_kotlin_062022_hw1

open class BaseSomeClass(override val a: Int) : BaseHandling {
    // Все классы по умолчанию final. Т.о для насладования явно прописывается open
    // По умолчанию классы наследуются от Any (в Java от Object)
}