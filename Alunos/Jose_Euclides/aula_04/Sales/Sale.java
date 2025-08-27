package Sales;

import java.time.LocalDate;
import Product.Product;

public class Sale {
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Product product;
    private int qtt;
    private double priceTotal;

    public Sale(Product product, int qtt) {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
        this.product = product;
        this.qtt = qtt;

        if(qtt > product.getQttMinimumForDiscount()) {
            this.priceTotal = ((qtt * product.getPrice()) * (1 - (product.getDiscount() / 100)));
        } else {
            this.priceTotal = (qtt * product.getPrice());  // 50 * ((10 / 100) - 100)
        }

    }

    public int getQtt() {
        return qtt;
    }

    public void setQtt(int qtt) {
        this.qtt = qtt;
    }

    public double getPriceTotal() {
        return this.priceTotal;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", product=" + (product != null ? product.toString() : "null") +
                ", qtt=" + qtt +
                ", priceTotal=" + priceTotal +
                '}';
    }
}
