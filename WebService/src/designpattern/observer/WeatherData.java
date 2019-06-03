package designpattern.observer;

import designpattern.observer.interfaces.Observer;
import designpattern.observer.interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList observers;

    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData() {
        this.observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> ((Observer) o).update(temperature, humidity, pressure));

//        for (int i = 0; i < observers.size(); i++) {
//            Observer observer = (Observer)observers.get(i);
//            observer.update(temperature, humidity, pressure);
//        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
