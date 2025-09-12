import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubscriptionManager {
    private List<SubscriptionPlan> availablePlans;
    private MainSubscription activeSubscription; 

    public SubscriptionManager() {
        availablePlans = new ArrayList<>();
        availablePlans.add(new SubscriptionPlan("Basic", 249, 1)); 
        availablePlans.add(new SubscriptionPlan("Standard", 399, 2)); 
        availablePlans.add(new SubscriptionPlan("Premium", 549, 4)); 
    }

    public SubscriptionPlan chooseSubscriptionPlan() {
        Scanner laguda = new Scanner(System.in); 
        System.out.println("\n ========================================================= ");
        System.out.println("|         Choose Your Subscription Plan                    |");
        System.out.println(" ========================================================= ");
        for (int i = 0; i < availablePlans.size(); i++) {
            System.out.printf("%d. %-50s\n", (i + 1), availablePlans.get(i).toString());
        }
        System.out.println(" ========================================================= ");
        System.out.print("| Please enter your choice (1-" + availablePlans.size() + "): ");
        int choice = laguda.nextInt();
        System.out.println(" ========================================================= \n");
        return availablePlans.get(choice - 1);
    }

    public void createSubscription(User user, String subscriptionType) {
        SubscriptionPlan plan = chooseSubscriptionPlan();
        MainSubscription subscription;

        if (subscriptionType.equalsIgnoreCase("Monthly")) {
            subscription = new MonthlySubscription(user, plan);
        } else {
            subscription = new YearlySubscription(user, plan);
        }

        subscription.startSubscription();
        activeSubscription = subscription;  
        System.out.println(">> Subscription successfully created!");
        System.out.println(">> Subscription price: " + plan.getFormattedPrice() + "\n");
    }

    public void viewSubscription() {
        if (activeSubscription != null) {
            System.out.println(" ========================================================= ");
            System.out.println("|           Current Subscription Details                  |   ");
            System.out.println(" ========================================================= ");
            activeSubscription.displaySubscriptionInfo();
            System.out.println(" ========================================================= \n");
        } else {
            System.out.println("\n>> No active subscription.\n");
        }
    }

    public void editSubscription(User user) {
        if (activeSubscription != null) {
            System.out.println(" ========================================================= ");
            System.out.println("|                   Edit Subscription                     |  ");
            System.out.println(" ========================================================= ");
            System.out.print("Choose new subscription type (Monthly/Yearly): ");
            Scanner laguda = new Scanner(System.in); 
            String subscriptionType = laguda.nextLine();
            createSubscription(user, subscriptionType);  
        } else {
            System.out.println("\n>> No active subscription to edit.\n");
        }
    }

    public void cancelSubscription() {
        if (activeSubscription != null) {
            activeSubscription.cancelSubscription();
            activeSubscription = null;  
            System.out.println(" ========================================================= ");
            System.out.println("|                 Subscription Cancelled                  |  ");
            System.out.println(" ========================================================= ");
            System.out.println(">> Subscription successfully cancelled.\n");
        } else {
            System.out.println("\n>> No active subscription to cancel.\n");
        }
    }
}
