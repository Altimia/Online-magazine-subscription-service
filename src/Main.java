import java.util.List;
import java.util.Arrays;

public class Main {
    private Magazine magazine;
    private List<Customer> customers;
    private CLI cli;
    private SubscriptionManager subscriptionManager;

    public Main() {
        this.magazine = new Magazine(5.0);
        this.customers = new ArrayList<>();
        this.cli = new CLI();
        this.subscriptionManager = new SubscriptionManager(new CustomerManager());
    }

    public void initializeMagazine() {
        Supplement supplement1 = new Supplement("Supplement 1", 1.0);
        Supplement supplement2 = new Supplement("Supplement 2", 2.0);
        Supplement supplement3 = new Supplement("Supplement 3", 3.0);
        this.magazine.addSupplement(supplement1);
        this.magazine.addSupplement(supplement2);
        this.magazine.addSupplement(supplement3);
    }

    public void initializeCustomers() {
        List<String> interestedSupplements1 = Arrays.asList("Supplement 1", "Supplement 2");
        List<String> interestedSupplements2 = Arrays.asList("Supplement 2", "Supplement 3");
        List<String> interestedSupplements3 = Arrays.asList("Supplement 1", "Supplement 3");
        List<String> interestedSupplements4 = Arrays.asList("Supplement 1");
        List<String> interestedSupplements5 = Arrays.asList("Supplement 2");
        List<String> interestedSupplements6 = Arrays.asList("Supplement 3");

        Customer customer1 = new Customer("Customer 1", "customer1@example.com", interestedSupplements1);
        Customer customer2 = new Customer("Customer 2", "customer2@example.com", interestedSupplements2);
        Customer customer3 = new Customer("Customer 3", "customer3@example.com", interestedSupplements3);
        Customer customer4 = new Customer("Customer 4", "customer4@example.com", interestedSupplements4);
        Customer customer5 = new Customer("Customer 5", "customer5@example.com", interestedSupplements5);
        Customer customer6 = new Customer("Customer 6", "customer6@example.com", interestedSupplements6);

        this.customers.add(customer1);
        this.customers.add(customer2);
        this.customers.add(customer3);
        this.customers.add(customer4);
        this.customers.add(customer5);
        this.customers.add(customer6);

        // Initialize subscriptions for each customer
        this.subscriptionManager.addSubscription(new Subscription(customer1));
        this.subscriptionManager.addSubscription(new Subscription(customer2));
        this.subscriptionManager.addSubscription(new Subscription(customer3));
        this.subscriptionManager.addSubscription(new Subscription(customer4));
        this.subscriptionManager.addSubscription(new Subscription(customer5));
        this.subscriptionManager.addSubscription(new Subscription(customer6));
    }

    public void generateEmails() {
        // logic to generate emails
    }

    public void handleUserInput() {
        boolean exit = false;
        while (!exit) {
            cli.displayMenu();
            String choice = cli.takeUserInput();
            switch (choice) {
                case "1":
                    // Add a new customer
                    break;
                case "2":
                    // Remove an existing customer
                    break;
                case "3":
                    // View details of all customers
                    break;
                case "4":
                    // Edit the details of a customer
                    break;
                case "5":
                    // Subscribe a customer to a supplement
                    String email = cli.promptForEmail();
                    String supplement = cli.promptForSupplement();
                    subscriptionManager.subscribeCustomerToSupplement(email, supplement);
                    break;
                case "6":
                    // Unsubscribe a customer from a supplement
                    email = cli.promptForEmail();
                    supplement = cli.promptForSupplement();
                    subscriptionManager.unsubscribeCustomerFromSupplement(email, supplement);
                    break;
                case "7":
                    // Set or update a customer's payment method
                    break;
                case "8":
                    // Set the weekly cost of the main magazine
                    break;
                case "9":
                    // Add a new supplement
                    break;
                case "10":
                    // Remove an existing supplement
                    break;
                case "11":
                    // Modify the details of a supplement
                    break;
                case "12":
                    // Send weekly emails
                    break;
                case "13":
                    // Send monthly emails
                    break;
                case "14":
                    // Exit
                    exit = true;
                    break;
                default:
                    cli.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initializeMagazine();
        main.initializeCustomers();
        main.generateEmails();
        main.handleUserInput();
    }
}
