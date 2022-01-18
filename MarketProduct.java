public abstract class MarketProduct {
    // field
    private String name;

    // constructor
    public MarketProduct(String name) {
        this.name = name;
    }

    // get/set methods
    final public String getName() {
        return this.name;
    }

    public abstract int getCost();

    // methods
    public abstract boolean equals(Object product);
}
