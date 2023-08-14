import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class CLI {
    private Scanner scanner;

    public CLI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Add a new customer");
        System.out.println("2. Remove an existing customer");
        System.out.println("3. View details of all customers");
        System.out.println("4. Edit the details of a customer");
        System.out.println("5. Subscribe a customer to a supplement");
        System.out.println("6. Unsubscribe a customer from a supplement");
        System.out.println("7. Set or update a customer's payment method");
        System.out.println("8. Set the weekly cost of the main magazine");
        System.out.println("9. Add a new supplement");
        System.out.println("10. Remove an existing supplement");
        System.out.println("11. Modify the details of a supplement");
        System.out.println("12. Send weekly emails");
        System.out.println("13. Send monthly emails");
        System.out.println("14. Exit");
    }

    public String takeUserInput() {
        System.out.print("Your choice: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String promptForName() {
        System.out.print("Enter name: ");
        return scanner.nextLine();
    }

    public String promptForEmail() {
        System.out.print("Enter email: ");
        return scanner.nextLine();
    }

    public List<String> promptForInterestedSupplements() {
        System.out.print("Enter names of interested supplements (comma-separated): ");
        String supplements = scanner.nextLine();
        return Arrays.asList(supplements.split(","));
    }

    public String promptForSupplement() {
        System.out.print("Enter name of supplement: ");
        return scanner.nextLine();
    }
}
