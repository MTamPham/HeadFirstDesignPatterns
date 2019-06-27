package headfirst.observer.scratch;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        // register the display as an headfirst.observer
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.tempSum += temp;
        this.numReadings++;
        if (temp > this.maxTemp) {
            this.maxTemp = temp;
        }
        if (temp < this.minTemp) {
            this.minTemp = temp;
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (this.tempSum / this.numReadings)
                + "/" + this.maxTemp + "/" + this.minTemp);
    }
}
