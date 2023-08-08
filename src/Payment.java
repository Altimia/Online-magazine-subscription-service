public class Payment {
    private Customer customer;
    private PaymentMethod paymentMethod;

    public Payment(Customer customer, PaymentMethod paymentMethod) {
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }

    // getters and setters for customer and paymentMethod

    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
