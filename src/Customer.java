public class Customer {
    private String name;
    private String email;
    private List<String> interestedSupplements;

    public Customer(String name, String email, List<String> interestedSupplements) {
        this.name = name;
        this.email = email;
        this.interestedSupplements = interestedSupplements;
    }

    // getters and setters for name, email, and interestedSupplements

    public void addSupplement(String supplement) {
        this.interestedSupplements.add(supplement);
    }

    public void removeSupplement(String supplement) {
        this.interestedSupplements.remove(supplement);
    }

    public void editDetails(String name, String email, List<String> interestedSupplements) {
        this.name = name;
        this.email = email;
        this.interestedSupplements = interestedSupplements;
    }
}
