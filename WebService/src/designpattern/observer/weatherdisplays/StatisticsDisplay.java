package designpattern.observer.weatherdisplays;

import designpattern.observer.interfaces.DisplayElement;
import designpattern.observer.interfaces.Observer;
import designpattern.observer.interfaces.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {
    private double maxTemp;
    private double minTemp = Double.MAX_VALUE;
    private double sumTemp;
    private int numTempData;

    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.format("Avg/Max/Min temperature = %.1f/%.1f/%.1f\n", (sumTemp / numTempData), maxTemp, minTemp);
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        numTempData++;
        sumTemp += temp;

        if (temp < minTemp)
            minTemp = temp;

        if (temp > maxTemp)
            maxTemp = temp;

        display();
    }
}
