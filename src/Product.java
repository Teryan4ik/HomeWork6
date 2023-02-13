import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Product {

    private final String type;
    private int price;
    private boolean discount;
    private LocalDate createDate;


    public Product(String type, int price, boolean discount, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public Product(String type, int price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
    }

    public Product(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public static void findProductBuyPrice(List<Product> list, String name, int cost) {
        List<Product> productList = list.stream()
                .filter(product -> product.getType().equals(name) & product.getPrice() > cost)
                .collect(Collectors.toList());
        System.out.println(productList);
    }

    public static void findProductBuyDiscount(List<Product> list, String name, Boolean discount) {
        List<Product> productList = list.stream()
                .filter(product -> product.getType().equals(name) & product.isDiscount() == discount).
                peek(p -> p.setPrice((int) (p.getPrice() * 0.9))).collect(Collectors.toList());
        System.out.println(productList);
    }

    public static void findCheapProduct(List<Product> list, String name) {
        List<Product> productList = Collections.singletonList(list.stream()
                .filter(product -> product.getType().equals(name))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Продукт " + name + " не знайдено")));
        System.out.println(productList);
    }

    public static void findLastAddProduct(List<Product> list, int count) {
        List<Product> productList = list.stream()
                .skip(Math.max(0, list.size() - count))
                .toList();
        System.out.println(productList);
    }

    public static void findProductBuyYearAndPrice(List<Product> list, int year, String name, int price) {
        int collect2 = list.stream()
                .filter(product -> product.getCreateDate() ==
                        product.getCreateDate().withYear(year)
                        & product.getType().equals(name)
                        & product.getPrice() < price).mapToInt(Product::getPrice).sum();
        System.out.println("Добавлено в " + year + " продукт " + name + " на сумму: " + collect2);
    }

    public static void groupByProduct(List<Product> list) {
        Map<String, List<Product>> mapOfLists = list.stream()
                .collect(Collectors.groupingBy(Product::getType));
        System.out.println(mapOfLists);
    }
    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", date=" + createDate +
                '}';
    }
    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}
