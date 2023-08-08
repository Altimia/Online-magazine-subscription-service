public class Subscription {
    private Customer customer;
    private List<String> subscribedSupplements;
    private Customer associateCustomer;

    public Subscription(Customer customer) {
        this.customer = customer;
        this.subscribedSupplements = new ArrayList<>();
    }

    // getters and setters for customer, subscribedSupplements, and associateCustomer

    public void subscribe(String supplement) {
        this.subscribedSupplements.add(supplement);
    }

    public void unsubscribe(String supplement) {
        this.subscribedSupplements.remove(supplement);
    }

    public void assignAssociateCustomer(Customer associateCustomer) {
        this.associateCustomer = associateCustomer;
    }

    public void removeAssociateCustomer() {
        this.associateCustomer = null;
    }
}
