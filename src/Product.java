import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private static int countAllProducts = 0;
    final private int id;
    private ProductType productType;
    private BigDecimal price;
    private boolean discount;
    private LocalDate addDate;

    public Product(ProductType productType, BigDecimal price, boolean discount, LocalDate addDate) {
        this.id = countAllProducts;
        this.productType = productType;
        this.price = price;
        this.discount = discount;
        this.addDate = addDate;
        countAllProducts++;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productType=" + productType +
                ", price=" + price +
                ", discount=" + discount +
                ", addDate=" + addDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && discount == product.discount && productType == product.productType && Objects.equals(price, product.price) && Objects.equals(addDate, product.addDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType, price, discount, addDate);
    }
}