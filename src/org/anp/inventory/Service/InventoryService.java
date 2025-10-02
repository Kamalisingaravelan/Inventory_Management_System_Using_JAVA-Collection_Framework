// ProductService.java
package org.anp.inventory.Service;

import org.anp.inventory.Model.Product;
import org.anp.inventory.repository.ProductRepository;
import java.util.List;

public class InventoryService {
    private ProductRepository repo;

    public InventoryService(ProductRepository repo) {
        this.repo = repo;
    }

    public void addProduct(Product product) {
        repo.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return repo.getAllProducts();
    }

    public Product findProduct(int id) {
        return repo.findById(id);
    }
}
