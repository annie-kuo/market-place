public class Egg extends MarketProduct {
    // fields
    private int numOfEggs;
    private int pricePerDozen;

    // constructor
    public Egg(String name, int num, int price) {
        super(name);
        this.numOfEggs = num;
        this.pricePerDozen = price;
    }

    // get/set methods
    public int getCost() {
        double forDozen = this.pricePerDozen;
        int cost = (int) ((forDozen / 12) * this.numOfEggs);
        return cost;
    }

    // methods
    public boolean equals(Object product) {
        if (product instanceof Egg) {
            Egg egg2 = (Egg) product;
            boolean sameName = this.getName().equals(egg2.getName());
            boolean sameCost = this.getCost() == egg2.getCost();
            boolean sameNum = this.numOfEggs == egg2.numOfEggs;

            boolean isEqual = (sameName && sameCost && sameNum);
            return isEqual;
        } else {
            return false;
        }

    }
}
