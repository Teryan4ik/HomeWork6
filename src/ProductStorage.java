import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductStorage {
    final private List<Product> storage;

    public ProductStorage() {
        this.storage = new ArrayList<>();
    }

    public void addProduct(Product value) {
        if (value != null) {
            storage.add(value);
        } else {
            throw new RuntimeException("Your product does not exist!");
        }
    }

    public List<Product> getAllProductsByCategory(ProductType category) {
        return storage.stream()
                .filter(product -> product.getProductType().equals(category))
                .filter(product -> product.getPrice().doubleValue() > 250)
                .collect(Collectors.toList());
    }

    public List<Product> getDiscountBooks() {
        return storage.stream()
                .filter(product -> product.getProductType().equals(ProductType.BOOK))
                .filter(Product::isDiscount)
                .peek(book -> book.setPrice(BigDecimal.valueOf(book.getPrice().doubleValue() * 0.9)))
                .collect(Collectors.toList());
    }

    public Product getCheapestBook() {
        return storage.stream()
                .filter(product -> product.getProductType().equals(ProductType.BOOK))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product [ Category : " + ProductType.BOOK.name() + " ] not found "));
    }

    public List<Product> getLastTreeProducts() {
        return storage.stream()
                .sorted(Comparator.comparing(Product::getAddDate))
                .skip(storage.stream().count() - 3)
                .collect(Collectors.toList());
    }

    public double getTotalPriceOfCategory(ProductType category, double priceLimit) {
        return storage.stream()
                .filter(product -> product.getProductType().equals(category))
                .filter(product -> product.getAddDate().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getPrice().doubleValue() < priceLimit)
                .map(Product::getPrice)
                .map(BigDecimal::doubleValue)
                .reduce(Double::sum)
                .get();
    }

    public Map<String, HashSet<Product>> groupProductsByType() {
        HashMap<String, HashSet<Product>> groupedStorage = new HashMap<>();
        Stream.of(ProductType.values())
                .map(Enum::toString)
                .forEach(type -> groupedStorage.put(type, new HashSet<>()));
        storage.stream()
                .forEach(product -> groupedStorage.get(product.getProductType().name()).add(product));
        return groupedStorage;
    }

    @Override
    public String toString() {
        return "ProductStorage{" +
                "storage=" + storage +
                '}';
    }
}
