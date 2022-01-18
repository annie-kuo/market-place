public class Basket {
    // fields
    private MarketProduct[] products;
    private int numProducts;

    // constructor
    public Basket() {
        this.products = new MarketProduct[10];
        this.numProducts = 0;
    }

    // get/set methods
    public MarketProduct[] getProducts() {
        MarketProduct[] productsCopy = new MarketProduct[this.numProducts];

        for (int i = 0; i < this.numProducts; i++) {
            productsCopy[i] = products[i];
        }
        return productsCopy;
    }

    public void add(MarketProduct newProduct) {
        if (this.products.length == this.numProducts) {
            resize();
        }

        this.products[this.numProducts] = newProduct;
        this.numProducts += 1;
    }

    public int getNumOfProducts() {
        return this.numProducts;
    }

    public int getSubTotal() {
        int cost = 0;
        for (int i = 0; i < this.numProducts; i++) {
            int individualCost = this.products[i].getCost();
            cost += individualCost;
        }
        return cost;
    }

    public int getTotalTax() {
        int cost = 0;
        for (int i = 0; i < this.numProducts; i++) {
            if (this.products[i] instanceof Jam) {
                int individualCost = (this.products[i]).getCost();
                cost += individualCost;
            }
        }
        int taxes = (int) (0.15 * cost);
        return taxes;
    }

    public int getTotalCost() {
        int preTax = this.getSubTotal();
        int taxes = this.getTotalTax();
        int postTax = preTax + taxes;
        return postTax;
    }

    // methods
    private void resize() {
        MarketProduct[] bigger = new MarketProduct[this.numProducts * 2];
        for (int i = 0; i < this.numProducts; i++) {
            bigger[i] = this.products[i];
        }
        this.products = bigger;
    }

    public boolean remove(MarketProduct product) {
        boolean productFound = false;

        // find product in the array
        for (int i = 0; i < this.numProducts; i++) {
            if ((this.products[i]).equals(product)) {
                productFound = true;
                // remove product
                for (int x = i; x < this.numProducts - 1; x++) {
                    this.products[x] = this.products[x + 1];
                }
                break;
            }
        }
        if (productFound) {
            this.products[this.numProducts - 1] = null;
            this.numProducts -= 1;
        }
        return productFound;
    }

    public void clear() {
        this.products = new MarketProduct[10];
        this.numProducts = 0;
    }

    private static String toDollars(int inCents) {
        if (inCents <= 0) {
            return "-";
        }

        double inDollars = inCents / 100.00;
        String cost = "" + inDollars;

        // edge case, eg. 5.00, 5.50
        if (inCents % 10 == 0) {
            cost += "0";
        }

        return cost;
    }

    public String toString() {
        String receipt = "";
        for (int i = 0; i < this.numProducts; i++) {
            MarketProduct item = this.products[i];
            String cost = toDollars(item.getCost());
            receipt += item.getName() + "\t" + cost + "\n";
        }
        String subtotalCost = "Subtotal\t" + toDollars(this.getSubTotal());
        String totalTax = "Total Tax\t" + toDollars(this.getTotalTax());
        String totalCost = "Total Cost\t" + toDollars(this.getTotalCost());
        receipt += "\n" + subtotalCost + "\n" + totalTax + "\n\n" + totalCost;

        return receipt;
    }


}
