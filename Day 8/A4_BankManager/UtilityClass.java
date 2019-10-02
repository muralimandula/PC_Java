class BankAccount {
    private int accNumber;
    private String holderName;
    private int balance;
    private int limit;
    private String accType;
    private int monthsOld;
    static int rateOfInterest = 12;  //per annum

    BankAccount() {

    }

    BankAccount(final int accN, final String name, final int bal, final int lim, final String type, final int old) {
        this.accNumber = accN;
        this.holderName = name;
        this.balance = bal;
        this.limit = lim;
        this.accType = type;
        this.monthsOld = old;
    }

    // String representation of the bank account information
    public String getAccountInfo() {
        return this.accNumber + "\t" + this.holderName + "\t" + this.balance + "\t" + this.limit + "\t" + this.monthsOld;
    }


    // Helper functions
    public String getAccType() {
        return this.accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public int getAccNumber() {
        return this.accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getMonthsOld() {
        return this.monthsOld;
    }

    public void setMonthsOld(int monthsOld) {
        this.monthsOld = monthsOld;
    }
  
}

class CheckingAccount extends BankAccount {

    boolean isSavings() {
        return (this.getAccType().toLowerCase()).equals("savings");
    }

    boolean isCurrent() {
        return (this.getAccType().toLowerCase()).equals("current");
    }

    boolean isDeposit() {
        return (this.getAccType().toLowerCase()).equals("deposit");
    }


}

class SavingsAccount extends BankAccount {

    int availableLimit(BankAccount acc) {
        return acc.getLimit() - acc.getBalance();
    }

    void doubleLimit(BankAccount acc) {
        int currentLimit = acc.getLimit();
        acc.setLimit(currentLimit * 2);
    }
}

class CertificateOfDeposit extends BankAccount {

    double calculateInterest(BankAccount acc) {


        int p = acc.getBalance();
        int t = acc.getMonthsOld();
        int r = rateOfInterest;

        return (p * (t/ (double)12) * r ) / 100.0;
    }

}



final class UtilityClass {
    public static void main(String[] args) {
     
        BankAccount myAcc = new BankAccount(20186065, "Muralidhar M", 10000, 100000, "deposit", 6);
        
        CertificateOfDeposit cod = new CertificateOfDeposit();

        System.out.println(cod.calculateInterest(myAcc));

        SavingsAccount sa = new SavingsAccount();
        System.out.println(sa.availableLimit(myAcc));
    }
}