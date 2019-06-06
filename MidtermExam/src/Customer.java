import interfaces.StockObserver;
import interfaces.SavingAccount;
import interfaces.StockPrice;
import savings.NormalSaving;

public class Customer implements StockObserver {
    private double dowJones = Double.MAX_VALUE;
    private double nasdaq = Double.MAX_VALUE;

    private String name;

    // bank
    private StockPrice stockPrice;

    private SavingAccount account;

    public Customer(String name, StockPrice stockPrice) {
        this.name = name;
        this.account = new NormalSaving();

        this.stockPrice = stockPrice;
        stockPrice.registerObserver(this);
    }

    public SavingAccount getAccount() {
        return account;
    }

    public void getAccountType() {
        account.getAccountType();
    }

    public void setAccount(SavingAccount account) {
        this.account = account;
    }

    private void display() {
        System.out.format("Customer %s -> Dow Jones: %.2f, NASDAQ: %.2f\n", name, dowJones, nasdaq);
    }

    @Override
    public void update(double dowJones, double nasdaq) {
        // check if new value is less than previous value
        boolean isPriceDown = (this.dowJones > dowJones) || (this.nasdaq > nasdaq);

        this.dowJones = dowJones;
        this.nasdaq = nasdaq;

        if (isPriceDown)
            display();
    }
}
