package org.example.examples

class ABC(val a:Int , val b:Int, val c:Int) {
    val d = 2 * c
    val e
        get() = d - 6
}

fun main(){
    val a = ABC(1,2,3)
    val b = ABC(1,2,3)
    //what does it print?
    // hashcode?
    val s = setOf(a, b)
    println(s.size)
}