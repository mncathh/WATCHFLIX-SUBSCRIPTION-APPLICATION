public abstract class MainSubscription {
    protected User user;
    protected SubscriptionPlan plan;
    protected String status;

    public MainSubscription(User user, SubscriptionPlan plan) {
        this.user = user;
        this.plan = plan;
        this.status = "Active";
    }

    public void startSubscription() {
        System.out.println("Subscription started for " + user.getName());
        displaySubscriptionInfo();
    }

    public String getStatus() {
        return status;
    }

    public void cancelSubscription() {
        status = "Cancelled";
        // System.out.println("Subscription for " + user.getName() + " has been cancelled.");
    }

    public abstract void displaySubscriptionInfo();

    public abstract double calculateDiscount();
}
