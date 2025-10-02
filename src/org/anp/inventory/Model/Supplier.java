package org.anp.inventory.Model;

import java.util.HashSet;
import java.util.Set;

public class Supplier {
    private int supplierId;
    private String name;
    private String phone;
    private Set<Product> products;

    public Supplier(int supplierId, String name, String phone) {
        this.supplierId = supplierId;
        this.name = name;
        this.phone = phone;
        this.products = new HashSet<>(); // Use HashSet to prevent duplicates
    }

    public int getSupplierId() { return supplierId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public Set<Product> getProducts() { return products; }

    // Add product safely
    public boolean addProduct(Product product) {
        return this.products.add(product); // returns false if already exists
    }

    @Override
    public String toString() {
        return "Supplier [ID=" + supplierId + ", Name=" + name + ", Phone=" + phone + "]";
    }
}
