package org.example.fractional

class Fraction(numerator: Int, denominator: Int, private val sign: Int = 1) : Comparable<Fraction> {
    val numerator: Int
    val denominator: Int

    init {
        require(denominator != 0) { "Denominator cannot be zero" }

        val gcd = gcd(Math.abs(numerator), Math.abs(denominator))
        this.numerator = Math.abs(numerator) / gcd
        this.denominator = Math.abs(denominator) / gcd
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    override fun toString(): String {
        val signChar = if (sign < 0) "-" else ""
        return "$signChar$numerator/$denominator"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraction) return false
        return this.numerator == other.numerator &&
               this.denominator == other.denominator &&
               this.sign == other.sign
    }

    override fun hashCode(): Int {
        var result = numerator
        result = 31 * result + denominator
        result = 31 * result + sign
        return result
    }

    override fun compareTo(other: Fraction): Int {
        // ommon denominator and compare
        val thisValue = this.sign * this.numerator * other.denominator
        val otherValue = other.sign * other.numerator * this.denominator
        return thisValue.compareTo(otherValue)
    }

    fun negate(): Fraction {
        return Fraction(numerator, denominator, -sign)
    }

    // add method
    fun add(other: Fraction): Fraction {
        val newNumerator = this.sign * this.numerator * other.denominator +
                          other.sign * other.numerator * this.denominator
        val newDenominator = this.denominator * other.denominator
        val newSign = if (newNumerator < 0) -1 else 1
        return Fraction(Math.abs(newNumerator), newDenominator, newSign)
    }

    fun mult(other: Fraction): Fraction {
        val newNumerator = this.numerator * other.numerator
        val newDenominator = this.denominator * other.denominator
        val newSign = this.sign * other.sign
        return Fraction(newNumerator, newDenominator, newSign)
    }

    fun div(other: Fraction): Fraction {
        require(other.numerator != 0) { "Cannot divide by zero" }
        val newNumerator = this.numerator * other.denominator
        val newDenominator = this.denominator * other.numerator
        val newSign = this.sign * other.sign
        return Fraction(newNumerator, newDenominator, newSign)
    }

    operator fun unaryMinus(): Fraction {
        return negate()
    }

    operator fun plus(other: Fraction): Fraction {
        return add(other)
    }

    operator fun minus(other: Fraction): Fraction {
        return add(other.negate())
    }

    operator fun times(other: Fraction): Fraction {
        return mult(other)
    }
}
