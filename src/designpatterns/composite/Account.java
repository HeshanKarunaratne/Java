package designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heshan Karunaratne
 */
abstract class Account {
    public abstract float getBalance();
}

class DepositAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public DepositAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class SavingsAccount extends Account {

    private String accountNo;
    private float accountBalance;

    public SavingsAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    @Override
    public float getBalance() {
        return accountBalance;
    }
}

class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() {
        totalBalance = 0;
        for (Account f : accountList) {
            totalBalance += f.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        accountList.remove(account);
    }
}

class Client {
    public static void main(String[] args) {
        CompositeAccount component = new CompositeAccount();

        component.addAccount(new DepositAccount("DA001", 100));
        component.addAccount(new DepositAccount("DA002", 230));
        component.addAccount(new SavingsAccount("SA001", 155));

        float totalBalance = component.getBalance();
        System.out.println("Total Balance: " + totalBalance);
    }
}