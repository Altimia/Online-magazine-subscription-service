public class Payment {
    private Customer customer;
    private String paymentMethod;

    public Payment(Customer customer, String paymentMethod) {
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }

    // getters and setters for customer and paymentMethod

    public void updatePaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
