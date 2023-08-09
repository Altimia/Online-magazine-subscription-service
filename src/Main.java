import java.util.ArrayList;
import java.util.List;

public class Main {
    private Magazine magazine;
    private List<Customer> customers;
    private CLI cli;

    public Main() {
        this.magazine = new Magazine(5.0);
        this.customers = new ArrayList<>();
        this.cli = new CLI();
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
    }

    public void generateEmails() {
        // logic to generate emails
    }

    public void handleUserInput() {
        // logic to handle user input
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.initializeMagazine();
        main.initializeCustomers();
        main.generateEmails();
        main.handleUserInput();
    }
}
