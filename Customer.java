package assignment1;

public class Customer {
    // fields
    private String name;
    private int balance;
    private Basket myBasket;

    // constructor
    public Customer(String name, int initialBalance) {
        this.name = name;
        this.balance = initialBalance;
        this.myBasket = new Basket();
    }

    // get/set methods
    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public Basket getBasket() {
        return this.myBasket;
    }

    // methods
    public int addFunds(int toAdd) {
        if (toAdd < 0) {
            throw new IllegalArgumentException("Please input a non-negative amount.");
        } else {
            this.balance += toAdd;
            return this.balance;
        }
    }

    public void addToBasket(MarketProduct toAdd) {
        this.myBasket.add(toAdd);
    }

    public boolean removeFromBasket(MarketProduct toRemove) {
        boolean success = this.myBasket.remove(toRemove);
        return success;
    }

    public String checkOut() {
        if (this.balance < this.myBasket.getTotalCost()) {
            throw new IllegalStateException();
        } else {
            System.out.println(this.myBasket);
            this.balance -= this.myBasket.getTotalCost();
            // create basket backup
            Basket tempBasket = new Basket();
            MarketProduct[] tempProducts = (this.myBasket).getProducts();
            for (int i = 0; i < (this.myBasket).getNumOfProducts(); i++) {
                tempBasket.add(tempProducts[i]);
            }
            this.myBasket.clear();
            return tempBasket.toString();
        }
    }
}
