import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public Optional<Customer> getCustomerByEmail(String email) {
        return this.customers.stream()
            .filter(customer -> customer.getEmail().equals(email))
            .findFirst();
    }
}
