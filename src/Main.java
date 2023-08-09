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
        // logic to initialize customers
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
