package designpattern.observer;

import designpattern.observer.weatherdisplays.CurrentConditionsDisplay;
import designpattern.observer.weatherdisplays.StatisticsDisplay;

import java.util.Scanner;

public class WeatherStation {

    public static double getRandomTemp() {
        return Math.random() * 71 - 35;      // -35 ~ 35 Celsius
    }

    public static double getRandomHumidity() {
        return Math.random() * 101;     // 0 ~ 100 percentage
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        // set initial weather data
        weatherData.setMeasurements(25, 30.5, 30.4);

        // update weather data
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("\nType any key to get new Weather data (X to Exit): ");
                String userInput = sc.nextLine();

                if ((userInput != null) && userInput.equalsIgnoreCase("X")) break;
                // set new weather data
                weatherData.setMeasurements(getRandomTemp(), getRandomHumidity(), 30.4f);
            }
        }
    }
}