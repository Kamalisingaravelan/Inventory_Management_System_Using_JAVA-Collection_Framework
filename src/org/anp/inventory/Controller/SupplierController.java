package org.anp.inventory.Controller;

import org.anp.inventory.Model.Product;
import org.anp.inventory.Model.Supplier;
import org.anp.inventory.Service.SupplierService;

import java.util.List;

public class SupplierController {
    private SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    public void addSupplier(Supplier supplier) {
        service.addSupplier(supplier);
    }

    public void addProductToSupplier(int supplierId, Product product) {
        service.addProductToSupplier(supplierId, product);
    }

    public List<Supplier> listSuppliers() {
        return service.listSuppliers();
    }
}
