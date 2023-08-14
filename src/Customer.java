import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<String> interestedSupplements;

    public Customer(String name, String email, List<String> interestedSupplements) {
        this.name = name;
        this.email = email;
        this.interestedSupplements = interestedSupplements;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getInterestedSupplements() {
        return this.interestedSupplements;
    }

    public void setInterestedSupplements(List<String> interestedSupplements) {
        this.interestedSupplements = interestedSupplements;
    }
}
