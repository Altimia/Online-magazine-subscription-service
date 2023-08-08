public class EmailNotification {
    private Customer customer;
    private Subscription subscription;

    public EmailNotification(Customer customer, Subscription subscription) {
        this.customer = customer;
        this.subscription = subscription;
    }

    // getters and setters for customer and subscription

    public void sendWeeklyEmail() {
        // logic to send weekly email
    }

    public void sendMonthlyEmail() {
        // logic to send monthly email
    }
}
