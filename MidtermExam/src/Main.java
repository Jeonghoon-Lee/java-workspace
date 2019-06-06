import savings.GIS;
import savings.MutualFund;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        // Create dummy customer
        Customer c1 = new Customer("James", bank);
        c1.getAccountType();

        Customer c2 = new Customer("Mary", bank);
        c2.setAccount(new MutualFund());
        c2.getAccountType();

        Customer c3 = new Customer("Jackson", bank);
        c3.setAccount(new GIS());
        c3.getAccountType();

        // Update stock value
        bank.updateStockValue(25463.95, 7530.8);
        System.out.println();
        // Update + stock value
        bank.updateStockValue(25483.95, 7530.8);
        System.out.println();
        // Update - stock value
        bank.updateStockValue(25483.95, 7510.8);
        System.out.println();

        // Thread
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new UpdateDowJones(bank));
        executor.execute(new UpdateNasdaq(bank));

        executor.shutdown();
    }
}
