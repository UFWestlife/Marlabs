package eCommerce;
import eCommerce.Product.Category;

import java.util.HashMap;
import java.util.List;

public class ProductPool {
    HashMap<Category, List<Product>> map;

    public ProductPool() {
        map = new HashMap<>();
    }

    public HashMap<Category, List<Product>> getProductPool() {
        return map;
    }
}
