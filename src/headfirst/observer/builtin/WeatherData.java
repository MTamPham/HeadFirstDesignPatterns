package headfirst.observer.builtin;

import java.util.Observable;

public class WeatherData extends Observable {
    // the Subject's state
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChanged() {
        // must call this method to signify that the state has changed before calling notifyObservers()
        setChanged();
        // there are two method to notify observers
        // if we pass a data object to notifyObservers(arg) method, we PUSH data to observers
        // otherwise, observers have to pull the data they want from Observable object passed to it
        // notice we aren't sending a data object with notifyObservers() call
        // that means we're using PULL
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
