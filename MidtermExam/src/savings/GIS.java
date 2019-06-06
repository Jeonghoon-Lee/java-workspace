package savings;

import interfaces.SavingAccount;

public class GIS implements SavingAccount {
    @Override
    public void getAccountType() {
        System.out.println("I want to invest to GIS");
    }
}
