class Account {
    static final int MAX_BALANCE = 1_000_000;
    public final String owner;     // public
    private int balance = 0;       // really private
    private final int pin = 1234;

    Account(String owner) { this.owner = owner; }

    void depositMoney(int amount) {  // camelCase
        balance += amount;
    }
}
//-
class Main { public static void main(String[] args) {
//+

var acct = new Account("ada");
acct.depositMoney(50);
// acct.balance  -> compile error: private access
//-
//? int x = acct.balance;
}}
