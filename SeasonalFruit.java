package assignment1;

public class SeasonalFruit extends Fruit{
    // constructor
    public SeasonalFruit(String name, double weight, int pricePerKg) {
        super(name, weight, pricePerKg);
    }

    // methods
    public int getCost() {
        int ogCost = super.getCost();
        int cost = (int) (0.85 * ogCost);
        return cost;
    }
}
