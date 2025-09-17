

public class Product {
    int id;
    private double price;
    private double discount;
    private String name;
    private int qttMinimumForDiscount;

    public Product(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQttMinimumForDiscount() {
        return this.qttMinimumForDiscount;
    }

    public void setQttMinimumForDiscount(int qttMinimumForDiscount) {
        this.qttMinimumForDiscount = qttMinimumForDiscount;
    }

    public String toString() {
        return "Product: {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", discount=" + discount +
                ", qttMinimumForDiscount=" + qttMinimumForDiscount +
                '}';
    }
}
