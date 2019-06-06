import interfaces.StockObserver;
import interfaces.StockPrice;

import java.util.ArrayList;

public class Bank implements StockPrice {
    private static Bank uniqueInstance;

    private ArrayList customers;

    private double dowJones;
    private double nasdaq;

    public static synchronized Bank getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Bank();
        return uniqueInstance;
    }

    private Bank() {
        this.customers = new ArrayList();
    }

    public double getDowJones() {
        return dowJones;
    }

    public double getNasdaq() {
        return nasdaq;
    }

    public synchronized void setDowJones(double dowJones) {
        this.dowJones = dowJones;
    }

    public synchronized void setNasdaq(double nasdaq) {
        this.nasdaq = nasdaq;
    }

    @Override
    public void registerObserver(StockObserver o) {
        customers.add(o);
    }

    @Override
    public void removeObserver(StockObserver o) {
        customers.remove(o);
    }

    @Override
    public void notifyObservers() {
        customers.forEach(o -> ((StockObserver) o).update(dowJones, nasdaq));
    }

    public void stockValueChanged() {
        notifyObservers();
    }

    public synchronized void updateStockValue(double dowJones, double nasdaq) {
        this.dowJones = dowJones;
        this.nasdaq = nasdaq;
        // update stock values
        stockValueChanged();
    }
}
