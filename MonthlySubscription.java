public class MonthlySubscription extends MainSubscription {

    public MonthlySubscription(User user, SubscriptionPlan plan) {
        super(user, plan);
    }

    @Override
    public void displaySubscriptionInfo() {
        System.out.println("Monthly Subscription for " + user.getName());
        System.out.println(plan.toString());
        System.out.println("Status: " + getStatus());
    }

    @Override
    public double calculateDiscount() {
        return plan.getPrice() * 0.95; 
    }
}
