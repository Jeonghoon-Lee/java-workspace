public class UpdateNasdaq implements Runnable {
    private Bank bank;

    public UpdateNasdaq(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<10; i++) {
                // 0.9 ~ 1.1
                bank.setNasdaq(bank.getNasdaq() * (1 + (-0.1 + (Math.random() * 0.2))));
                bank.stockValueChanged();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
