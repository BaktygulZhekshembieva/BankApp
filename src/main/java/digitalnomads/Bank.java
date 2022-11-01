package digitalnomads;

public interface Bank {

    double getBalance();
    void deposit(double amount) throws Exception; //method popolnit' sch'et
    void withDraw(double amount) throws Exception; //method snyat' s karty

//                              otprovitel,  poluchatel,  skol'ko
    static void transferFounds(Bank sender, Bank recipient, double transferAmount) throws Exception {
        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);
    }

}
