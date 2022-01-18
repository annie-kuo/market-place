package assignment1;

public class Jam extends MarketProduct{
    // fields
    private int numJars;
    private int pricePerJar;

    // constructor
    public Jam(String name, int numJars, int price) {
        super(name);
        this.numJars = numJars;
        this.pricePerJar = price;
    }

    // get/set methods
    public int getCost() {
        int cost = (int) (this.pricePerJar * this.numJars);
        return cost;
    }

    // methods
    public boolean equals(Object product) {
        if (product instanceof Jam) {
            Jam jam2 = (Jam) product;
            boolean sameName = this.getName().equals(jam2.getName());
            boolean sameCost = this.getCost() == jam2.getCost();
            boolean sameNum = this.numJars == jam2.numJars;

            boolean isEqual = (sameName && sameCost && sameNum);
            return isEqual;
        } else {
            return false;
        }
    }
}
