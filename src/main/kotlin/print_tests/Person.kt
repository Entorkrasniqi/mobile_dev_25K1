package org.example.print_tests

data class Person(val name: String, val age: Int)

fun main() {
    val p1 = Person("Alice", 25)
    val p2 = Person("Alice", 25)
    val p3 = p1

    println(p1 == p2)   // What prints?
    println(p1 === p2)  // What prints?
    println(p1 === p3)  // What prints?
    println(p1 === p3)  // What prints?

}
