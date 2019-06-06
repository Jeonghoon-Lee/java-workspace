package savings;

import interfaces.SavingAccount;

public class NormalSaving implements SavingAccount {
    @Override
    public void getAccountType() {
        System.out.println("Saving account was opened");
    }
}
