public class BankAccount extends PaymentMethod {
    private String accountNumber;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getPaymentMethodDetails() {
        return "Bank Account: " + accountNumber;
    }
}
