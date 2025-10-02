package org.anp.inventory.Model;

public class Sale {
    private Product product;
    private Supplier supplier;
    private int quantity;

    public Sale(Product product, Supplier supplier, int quantity) {
        this.product = product;
        this.supplier = supplier;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public Supplier getSupplier() { return supplier; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        String supplierName = (supplier == null || supplier.getSupplierId() == 0) ? "Unknown" : supplier.getName();
        return "Sale [Product=" + product.getName() +
               ", Supplier=" + supplierName +
               ", Quantity=" + quantity +
               ", Total=" + (quantity * product.getPrice()) + "]";
    }
}
