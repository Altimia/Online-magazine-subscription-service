import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubscriptionManager {
    private List<Subscription> subscriptions;

    public SubscriptionManager() {
        this.subscriptions = new ArrayList<>();
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
}
