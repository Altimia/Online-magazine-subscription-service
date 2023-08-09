import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

public class SubscriptionManager {
    private List<Subscription> subscriptions;
    private CustomerManager customerManager;

    public SubscriptionManager(CustomerManager customerManager) {
        this.subscriptions = new ArrayList<>();
        this.customerManager = customerManager;
    }

    public void addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public void removeSubscription(Subscription subscription) {
        this.subscriptions.remove(subscription);
    }

    public List<Subscription> getSubscriptions() {
        return this.subscriptions;
    }

    public Optional<Subscription> getSubscriptionByCustomerEmail(String email) {
        return this.subscriptions.stream()
            .filter(subscription -> subscription.getCustomer().getEmail().equals(email))
            .findFirst();
    }

    public List<Subscription> getSubscriptionsBySupplement(String supplement) {
        return this.subscriptions.stream()
            .filter(subscription -> subscription.getSubscribedSupplements().contains(supplement))
            .collect(Collectors.toList());
    }

    public void subscribeCustomerToSupplement(String email, String supplement) {
        Optional<Subscription> subscription = getSubscriptionByCustomerEmail(email);
        if (subscription.isPresent()) {
            subscription.get().subscribe(supplement);
        }
    }

    public void unsubscribeCustomerFromSupplement(String email, String supplement) {
        Optional<Subscription> subscription = getSubscriptionByCustomerEmail(email);
        if (subscription.isPresent()) {
            subscription.get().unsubscribe(supplement);
        }
    }

    public void assignAssociateCustomerToPayingCustomer(String payingCustomerEmail, String associateCustomerEmail) {
        Optional<Subscription> subscription = getSubscriptionByCustomerEmail(payingCustomerEmail);
        Optional<Customer> associateCustomer = this.customerManager.getCustomerByEmail(associateCustomerEmail);
        if (subscription.isPresent() && associateCustomer.isPresent()) {
            subscription.get().assignAssociateCustomer(associateCustomer.get());
        }
    }

    public void removeAssociateCustomerFromPayingCustomer(String payingCustomerEmail) {
        Optional<Subscription> subscription = getSubscriptionByCustomerEmail(payingCustomerEmail);
        if (subscription.isPresent()) {
            subscription.get().removeAssociateCustomer();
        }
    }
}