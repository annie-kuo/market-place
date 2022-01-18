public class Fruit extends MarketProduct{
    // fields
    private double weight;
    private int pricePerKg;

    // constructor
    public Fruit(String name, double weight, int price) {
        super(name);
        this.weight = weight;
        this.pricePerKg = price;
    }

    // get/set methods
    public int getCost() {
        int cost = (int) (this.pricePerKg * this.weight);
        return cost;
    }

    // methods
    public boolean equals(Object product) {
        if (product instanceof Fruit) {
            Fruit fruit2 = (Fruit) product;
            boolean sameName = this.getName().equals(fruit2.getName());
            boolean sameCost = this.getCost() == fruit2.getCost();
            boolean sameWeight = this.weight == fruit2.weight;
            boolean samePrice = this.pricePerKg == fruit2.pricePerKg;

            boolean isEqual = (sameName && sameCost && sameWeight && samePrice);
            return isEqual;
        } else {
            return false;
        }
    }
}
