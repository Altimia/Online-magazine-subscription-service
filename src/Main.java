import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

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
        // removed
    }

    public void handleUserInput() {
        boolean exit = false;
        while (!exit) {
            cli.displayMenu();
            String choice = cli.takeUserInput();
            switch (choice) {
                case "1":
                    // Add a new customer
                    String name = cli.promptForName();
                    String email = cli.promptForEmail();
                    List<String> interestedSupplements = cli.promptForInterestedSupplements();
                    Customer newCustomer = new Customer(name, email, interestedSupplements);
                    this.customers.add(newCustomer);
                    this.subscriptionManager.addSubscription(new Subscription(newCustomer));
                    break;
                case "2":
                    // Remove an existing customer
                    email = cli.promptForEmail();
                    Customer customerToRemove = this.customers.stream().filter(c -> c.getEmail().equals(email)).findFirst().orElse(null);
                    if (customerToRemove != null) {
                        this.customers.remove(customerToRemove);
                        Subscription subscriptionToRemove = this.subscriptionManager.getSubscriptionByCustomerEmail(email).orElse(null);
                        if (subscriptionToRemove != null) {
                            this.subscriptionManager.removeSubscription(subscriptionToRemove);
                        }
                    }
                    break;
                case "3":
                    // View details of all customers
                    this.customers.forEach(c -> System.out.println(c.toString()));
                    break;
                case "4":
                    // Edit the details of a customer
                    String editEmail = cli.promptForEmail();
                    Customer customerToEdit = this.customers.stream().filter(c -> c.getEmail().equals(editEmail)).findFirst().orElse(null);
                    if (customerToEdit != null) {
                        name = cli.promptForName();
                        email = editEmail;
                        interestedSupplements = cli.promptForInterestedSupplements();
                        customerToEdit.setName(name);
                        customerToEdit.setEmail(email);
                        customerToEdit.setInterestedSupplements(interestedSupplements);
                    }
                    break;
                case "5":
                    // Subscribe a customer to a supplement
                    email = cli.promptForEmail();
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
                    email = cli.promptForEmail();
                    Customer customerToUpdatePayment = this.customers.stream().filter(c -> c.getEmail().equals(email)).findFirst().orElse(null);
                    if (customerToUpdatePayment != null) {
                        String paymentMethodType = cli.promptForPaymentMethodType();
                        if (paymentMethodType.equals("Bank Account")) {
                            String accountNumber = cli.promptForAccountNumber();
                            BankAccount bankAccount = new BankAccount(accountNumber);
                            customerToUpdatePayment.setPaymentMethod(bankAccount);
                        } else if (paymentMethodType.equals("Credit Card")) {
                            String cardNumber = cli.promptForCardNumber();
                            CreditCard creditCard = new CreditCard(cardNumber);
                            customerToUpdatePayment.setPaymentMethod(creditCard);
                        }
                    }
                    break;
                case "8":
                    // Set the weekly cost of the main magazine
                    double newWeeklyCost = cli.promptForCost();
                    this.magazine.setWeeklyCost(newWeeklyCost);
                    break;
                case "9":
                    // Add a new supplement
                    String supplementName = cli.promptForSupplement();
                    double supplementCost = cli.promptForCost();
                    Supplement newSupplement = new Supplement(supplementName, supplementCost);
                    this.magazine.addSupplement(newSupplement);
                    break;
                case "10":
                    // Remove an existing supplement
                    supplementName = cli.promptForSupplement();
                    Supplement supplementToRemove = this.magazine.getSupplementByName(supplementName);
                    if (supplementToRemove != null) {
                        this.magazine.removeSupplement(supplementToRemove);
                    }
                    break;
                case "11":
                    // Modify the details of a supplement
                    supplementName = cli.promptForSupplement();
                    Supplement supplementToEdit = this.magazine.getSupplementByName(supplementName);
                    if (supplementToEdit != null) {
                        supplementName = cli.promptForSupplement();
                        supplementCost = cli.promptForCost();
                        supplementToEdit.setName(supplementName);
                        supplementToEdit.setCost(supplementCost);
                    }
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
