public class CreditCard extends PaymentMethod {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String getPaymentMethodDetails() {
        return "Credit Card: " + cardNumber;
    }
}
