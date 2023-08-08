import java.util.Scanner;

public class CLI {
    private Scanner scanner;

    public CLI() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        // logic to display menu options
    }

    public String takeUserInput() {
        // logic to take user input
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        // logic to display message
        System.out.println(message);
    }
}
