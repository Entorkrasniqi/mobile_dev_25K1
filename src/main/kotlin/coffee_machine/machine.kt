package org.example.coffee_machine

class Kahvinkeitin(
    private val vesiSailionKapasiteetti: Int = 300,
    private val kahviSailionKapasiteetti: Int = 100
) {
    private var vesiMaara: Int = 0
    private var kahviMaara: Int = 0
    private var paalla: Boolean = true

    val vetta: Int
        get() = vesiMaara

    val kahvia: Int
        get() = kahviMaara

    val espressoja: Int
        get() {
            if (!paalla) return 0
            val vesistaEspressoja = vesiMaara / 30
            val kahvistaEspressoja = kahviMaara / 16
            return minOf(vesistaEspressoja, kahvistaEspressoja)
        }

    val tavallisia: Int
        get() {
            if (!paalla) return 0
            val vesistaTavallisia = vesiMaara / 200
            val kahvistaTavallisia = kahviMaara / 15
            return minOf(vesistaTavallisia, kahvistaTavallisia)
        }

    fun painaOnOffNappia() {
        paalla = !paalla
    }

    fun taytaVesiSailio() {
        vesiMaara = vesiSailionKapasiteetti
    }

    fun taytaKahviSailio() {
        kahviMaara = kahviSailionKapasiteetti
    }

    fun teeEspresso(): Boolean {
        if (!paalla) return false
        if (vesiMaara < 30 || kahviMaara < 16) return false

        vesiMaara -= 30
        kahviMaara -= 16
        return true
    }

    fun teeTavallinenKahvi(): Boolean {
        if (!paalla) return false
        if (vesiMaara < 200 || kahviMaara < 15) return false

        vesiMaara -= 200
        kahviMaara -= 15
        return true
    }

    override fun toString(): String {
        val tila = if (paalla) "päällä" else "pois päältä"
        return "Kahvinkeitin on $tila. Vettä $vesiMaara/$vesiSailionKapasiteetti, kahvia $kahviMaara/$kahviSailionKapasiteetti."
    }
}

fun main() {
    val k = Kahvinkeitin()
    println(k)
    k.taytaVesiSailio()
    k.taytaKahviSailio()
    println(k)
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    println("tee espresso: ${k.teeEspresso()}")
    println(k)
    k.painaOnOffNappia()
    println("tee tavallinen kahvi: ${k.teeTavallinenKahvi()}")
    println(k)
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println(k)
    }
    println("espressoja: ${k.espressoja}")
    println("tavallisia: ${k.tavallisia}")
    k.taytaVesiSailio()
    println(k)
    for (i in 0..4) {
        println("tee espresso: ${k.teeEspresso()}")
        println(k)
    }
}