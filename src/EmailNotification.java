public class EmailNotification {
    private Customer customer;
    private Subscription subscription;

    public EmailNotification(Customer customer, Subscription subscription) {
        this.customer = customer;
        this.subscription = subscription;
    }

    // getters and setters for customer and subscription

    public void sendWeeklyEmail() {
        // Create email content
        String emailContent = "Dear " + customer.getName() + ",\n\nYour magazine is ready. Here are the supplements you are subscribed to:\n";
        for (String supplement : subscription.getSubscribedSupplements()) {
            emailContent += "- " + supplement + "\n";
        }
        emailContent += "\nBest regards,\nMagazine Team";

        // Send email (this will depend on the email service you're using)
        // For example, if you're using JavaMail:
        // sendEmail(customer.getEmail(), "Your Weekly Magazine", emailContent);
    }
/* 
    public void sendMonthlyEmail() {
        // Create email content
        String emailContent = "Dear " + customer.getName() + ",\n\nHere are the charges for this month:\n";
        emailContent += "Magazine: " + subscription.getMagazine().getWeeklyCost() * 4 + "\n";
        for (String supplement : subscription.getSubscribedSupplements()) {
            emailContent += "- " + supplement + ": " + subscription.getSupplementCost(supplement) * 4 + "\n";
        }
        emailContent += "\nBest regards,\nMagazine Team";

        // Send email (this will depend on the email service you're using)
        // For example, if you're using JavaMail:
        // sendEmail(customer.getEmail(), "Your Monthly Charges", emailContent);
    }*/
}
