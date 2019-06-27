package headfirst.observer.builtin;

public class WeatherStation {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        // create the WeatherData builtin (broadcaster)
        WeatherData weatherData = new WeatherData();

        // register these following display elements as weather observers
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

    }
}
