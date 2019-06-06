package savings;

import interfaces.SavingAccount;

public class MutualFund implements SavingAccount {
    @Override
    public void getAccountType() {
        System.out.println("I want to open MutualFund");
    }
}
