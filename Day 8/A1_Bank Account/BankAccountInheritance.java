class BankAccount {
    String accountNumber = "123456";
    String balance = "1000";
}

class CheckingAccount extends BankAccount {
    String limit = "10000";
}

class SavingsAccount extends BankAccount {

}
class CertificateOfDeposit extends BankAccount {

}


/**
 * utility class
 */
final class BankAccountInheritance {
    /**
     * main method - driver method
     * @param args just args
     */
    public static void main(final String[] args) {
        CheckingAccount cA = new CheckingAccount();
        System.out.println("Im at checking account can see account number, " + cA.accountNumber + "\n");

        SavingsAccount sA = new SavingsAccount();
        System.out.println("Im at saving account can see account number, " + sA.accountNumber + "\n");

        CertificateOfDeposit cod = new CertificateOfDeposit();
        System.out.println("Im at certificate of deposit can see account number, " + cod.accountNumber + "\n");
    }
}