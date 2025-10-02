package org.anp.inventory.Service;

import org.anp.inventory.Model.Product;
import org.anp.inventory.Model.Supplier;
import org.anp.inventory.repository.SupplierRepository;

import java.util.List;

public class SupplierService {
    private SupplierRepository repo;

    public SupplierService(SupplierRepository repo) {
        this.repo = repo;
    }

    public void addSupplier(Supplier supplier) {
        repo.addSupplier(supplier);
    }

    public void addProductToSupplier(int supplierId, Product product) {
        Supplier supplier = repo.findById(supplierId);
        if (supplier != null) {
            supplier.addProduct(product);
        }
    }

    public List<Supplier> listSuppliers() {
        return repo.getAllSuppliers();
    }
}
