package org.example.Observer

data class WeatherData (val temperature: Float, val humidity:
Float, val pressure: Float)

class WeatherStation{
    private var currentData: WeatherData? = null

    fun measurementsChanged(newData: WeatherData) {
        this.currentData = newData
    }

}