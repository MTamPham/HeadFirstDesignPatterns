package headfirst.observer.scratch;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    // a list to hold observers
    private List observers;
    // the Subject's state
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = this.observers.indexOf(o);
        if (index >= 0) {
            this.observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < this.observers.size(); i++) {
            Observer observer = (Observer) this.observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
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
