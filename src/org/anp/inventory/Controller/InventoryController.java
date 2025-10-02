package org.anp.inventory.Controller;

import org.anp.inventory.Model.Product;
import org.anp.inventory.Service.InventoryService;
import java.util.List;

public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) { this.inventoryService = inventoryService; }

    public void addProduct(Product product) { inventoryService.addProduct(product); }
    public List<Product> listProducts() { return inventoryService.getAllProducts(); }
}
