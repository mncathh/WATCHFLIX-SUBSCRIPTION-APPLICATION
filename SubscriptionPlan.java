public class SubscriptionPlan {
    private String name;
    private double price; 
    private int duration; 

    public SubscriptionPlan(String name, double price, int duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price; 
    }

    public String getFormattedPrice() {
        return "Php " + price; 
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name + " - " + getFormattedPrice() + " for " + duration + " month(s)";
    }
}
