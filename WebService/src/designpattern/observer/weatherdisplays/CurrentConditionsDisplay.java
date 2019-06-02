package designpattern.observer.weatherdisplays;

import designpattern.observer.interfaces.DisplayElement;
import designpattern.observer.interfaces.Observer;
import designpattern.observer.interfaces.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private double temperature;
    private double humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.format("Current conditions: %.1fC degrees and %.1f%% humidity\n", temperature, humidity);
    }
}