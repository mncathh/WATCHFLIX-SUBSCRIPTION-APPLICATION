import java.util.Scanner;

public class WatchflixApp {

    public static void main(String[] args) {
        Scanner laguda = new Scanner(System.in);
        SubscriptionManager manager = new SubscriptionManager();

        System.out.println(" ========================================================= ");
        System.out.println("|                                                         |");
        System.out.println("|    WELCOME TO WATCHFLIX SUBSCRIPTION APPLICATION        |");
        System.out.println("|                                                         |");
        System.out.println(" ========================================================= ");

        System.out.print("| Please enter your name: ");
        String userName = laguda.nextLine();
        User user = new User(userName);

        System.out.println(" ========================================================= ");
        System.out.println("| Hello, " + user.getName() + "! Let's manage your subscription.");
        System.out.println(" ========================================================= \n");

        while (true) {
            System.out.println(" ========================================================= ");
            System.out.println("|                  SUBSCRIPTION MENU                      |");
            System.out.println("|---------------------------------------------------------|");
            System.out.println("| 1. Create Subscription                                  |");
            System.out.println("| 2. View Subscription                                    |");
            System.out.println("| 3. Edit Subscription                                    |");
            System.out.println("| 4. Cancel Subscription                                  |");
            System.out.println("| 5. Exit                                                 |");
            System.out.println(" ========================================================= ");
            System.out.print("| Please choose an option: ");
            int choice = laguda.nextInt(); laguda.nextLine(); 
            System.out.println(" ========================================================= \n");

            switch (choice) {
                case 1:
                    System.out.print("| Choose subscription type (Monthly/Yearly): ");
                    String subscriptionType = laguda.nextLine();
                    manager.createSubscription(user, subscriptionType);
                    break;

                case 2:
                    manager.viewSubscription();
                    break;

                case 3:
                    manager.editSubscription(user);
                    break;

                case 4:
                    manager.cancelSubscription();
                    break;

                case 5:
                    System.out.println(" ========================================================= ");
                    System.out.println("|        Thank you for using WATCHFLIX! Goodbye.          |");
                    System.out.println(" ========================================================= ");
                    return;

                default:
                    System.out.println("|            Invalid choice. Please try again.            |");
                    System.out.println(" ========================================================= \n");
            }
        }
    }
}
