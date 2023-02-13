import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        List<Product> productList2 = Arrays.asList(
                new Product("Book", 70, true, LocalDate.of(2023, 10, 14)),
                new Product("Book", 350, false, LocalDate.of(2023, 10, 6)),
                new Product("Book", 270, true, LocalDate.of(2023, 10, 4)),
                new Product("Book", 560, true, LocalDate.of(2023, 10, 8)),
                new Product("Book", 64, false, LocalDate.of(2023, 10, 19)),
                new Product("Toy", 270, true, LocalDate.of(2023, 10, 10)),
                new Product("Ball", 270, true, LocalDate.of(2023, 10, 1)),
                new Product("Toy", 25, true, LocalDate.of(2023, 10, 21)),
                new Product("Cup", 15, true, LocalDate.of(2023, 10, 17)),
                new Product("Boot", 64, true, LocalDate.of(2023, 10, 14)),
                new Product("Telephone", 657, true, LocalDate.of(2023, 10, 9)));


        Product.findProductBuyPrice(productList2, "Book", 250);
        Product.findProductBuyDiscount(productList2, "Book", true);
        Product.findCheapProduct(productList2, "Book");
        Product.findLastAddProduct(productList2, 3);
        Product.findProductBuyYearAndPrice(productList2, 2023, "Book", 75);
        Product.groupByProduct(productList2);

    }
}