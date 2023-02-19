// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.*;

/**
 * This is the main class for the BankApp program.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-11-15T09:10:00Z
 */
public class BankApp {
    /**
     * The main method of the BankApp program. This method initializes a few BankAccount objects, asks the user
     * for their name, and then allows the user to perform some operations on their account (deposit and withdraw
     * funds).
     *
     * @param args Command-line arguments, which are not used in this program.
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public static void main(String[] args) {
        // init accounts
        BankAccount acc1 = new BankAccount("111", "Batman");
        BankAccount acc2 = new BankAccount("222", "Robin");

        // ask for user's name
        Scanner input = new Scanner(System.in);
        String userName = "";
        while (userName.isEmpty() || userName.matches(".*\\d+.*")) {
            System.out.print("Input your name for your bank account (your bank account number will be 333): ");
            userName = input.nextLine();
            if (userName.isEmpty() || userName.matches(".*\\d+.*")) System.out.println("Invalid name! Please enter a valid name without numbers or special characters.");
        }

        BankAccount usrAcc = new BankAccount("333", userName);

        // show amounts
        displayAccount(acc1);
        displayAccount(acc2);
        displayAccount(usrAcc);

        // deposit
        acc1.deposit(100);
        acc2.deposit(50);
        usrAcc.deposit(75);
        displayAccount(acc1);
        displayAccount(acc2);
        displayAccount(usrAcc);

        // withdraw
        if (!acc1.withdraw(75)) System.out.println("Insufficient funds in account " + acc1.getAccountNumber());
        if (!acc2.withdraw(75)) System.out.println("Insufficient funds in account " + acc2.getAccountNumber());
        if (!usrAcc.withdraw(25)) System.out.println("Insufficient funds in account " + usrAcc.getAccountNumber());
        displayAccount(acc1);
        displayAccount(acc2);
        displayAccount(usrAcc);

        // close the Scanner object when it is no longer needed
        input.close();
    }

    /**
     * Displays the information for a {@link BankAccount} object.
     *
     * @param acc the {@link BankAccount} to display information for
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public static void displayAccount(BankAccount acc) {System.out.println(acc.toString());}
}

/**
 * Class for representing a bank account.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-11-15T09:10:00Z
 */
class BankAccount {
    private final String accountNumber;
    private final String accountName;
    private double balance;

    /**
     * Constructs a new BankAccount instance with the given account number and name.
     *
     * @param numberIn the account number of the new BankAccount instance
     * @param nameIn the name of the new BankAccount instance
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public BankAccount(String numberIn, String nameIn) {
        this.accountNumber = numberIn;
        this.accountName = nameIn;
        this.balance = 0;
    }

    /**
     * Returns the name of the BankAccount instance.
     *
     * @return the name of the BankAccount instance
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public String getAccountName() {return this.accountName;}

    /**
     * Returns the account number of the BankAccount instance.
     *
     * @return the account number of the BankAccount instance
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public String getAccountNumber() {return this.accountNumber;}

    /**
     * Returns the current balance of the BankAccount instance.
     *
     * @return the current balance of the BankAccount instance
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public double getBalance() {return this.balance;}

    /**
     * Returns a string representation of the BankAccount instance in the format:
     *
     * Account Number: [accountNumber]
     * Name: [accountName]
     * Balance: [balance]
     *
     * @return a string representation of the BankAccount instance
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public String toString() {return("\nAccount Number: " + this.accountNumber + "\nName: " + this.accountName + "\nBalance: " + this.balance);}

    /**
     * Deposits the given amount into the BankAccount instance's balance.
     *
     * @param amountIn the amount to deposit into the BankAccount instance's balance
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public void deposit(double amountIn) {this.balance = this.balance + amountIn;}

    /**
     * Withdraws the given amount from the BankAccount instance's balance, if sufficient funds are available.
     *
     * @param amountIn the amount to withdraw from the BankAccount instance's balance
     * @return true if the withdrawal was successful, false if insufficient funds were available
     * @author Adam Tazul - 2274640 - SimPilotAdamT
     * @since 2022-11-15T09:10:00Z
     */
    public boolean withdraw(double amountOut) {
        if(amountOut > this.balance) return false;
        else {
            this.balance = this.balance - amountOut;
            return true;
        }
    }
}
