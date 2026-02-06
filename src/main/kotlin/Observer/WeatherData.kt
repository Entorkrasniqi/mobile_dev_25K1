package org.example.Observer

data class WeatherData (val temperature: Float, val humidity:
Float, val pressure: Float)

// --- The Subject (or Observable)
// TODO: This class should be able to register, remove, and notify observers.
class WeatherStation {
    private val observers = mutableSetOf<Observer>()
    private var currentData: WeatherData? = null
// create interface observer
    interface Observer {
        fun onUpdate(weatherData: WeatherData)
    }
//register observer function
    fun registerObserver(observer: Observer) {
        observers.add(observer)
    }
// create remove observer function
    fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }
    // create notify observer function
    fun notifyObserver() {
        currentData?.let { data ->
            for (observer in observers) {
                observer.onUpdate(data)
            }
        }
    }
    fun measurementsChanged(newData: WeatherData) {
        this.currentData = newData
        println("WeatherStation: Got new Data -> $currentData")
        notifyObserver()  // Call this to notify all observers
    }
}

// --- The Observers ---
// TODO: This class should update its display when it receives new data.
class CurrentConditionsDisplay : WeatherStation.Observer {
    override fun onUpdate(weatherData: WeatherData) {
        println("Current conditions: ${weatherData.temperature}°F and ${weatherData.humidity}% humidity")
    }
}


// TODO: This class should calculate and display the average temperature.

class StatisticsDisplay {
    private val temperatures = mutableListOf<Float>()
    fun display() {
    // TODO: Calculate the average and print it. println("StatisticsDisplay: IMPLEMENT ME") } }
    }
}

fun main() {
    // 1. Create the WeatherStation (the subject).
    val weatherStation = WeatherStation()
    // 2. Create the display devices (the observers).
    val currentDisplay = CurrentConditionsDisplay()
    val statsDisplay = StatisticsDisplay()

    // 3. TODO: Register the observers with the weather station.

    // Simulate new weather measurements.
    println("--- Simulating new measurement ---")
    weatherStation.measurementsChanged(WeatherData(25.0f, 65f, 1012f))
    println("\n--- Simulating another measurement ---")
    weatherStation.measurementsChanged(WeatherData(27.5f, 70f, 1011f))
    // 4. TODO: Unregister one of the observers.
    println("\n--- Simulating a final measurement ---")
    weatherStation.measurementsChanged(WeatherData(26.0f, 90f, 1013f))
}
