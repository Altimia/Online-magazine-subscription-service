import java.util.ArrayList;
import java.util.List;

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
}
