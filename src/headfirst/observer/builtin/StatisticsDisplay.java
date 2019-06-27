package headfirst.observer.builtin;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private Observable observable;
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            float temp = weatherData.getTemperature();
            tempSum += temp;
            numReadings++;
            if (temp > maxTemp) {
                maxTemp = temp;
            }
            if (temp < minTemp) {
                minTemp = temp;
            }
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (this.tempSum / this.numReadings)
                + "/" + this.maxTemp + "/" + this.minTemp);
    }
}
