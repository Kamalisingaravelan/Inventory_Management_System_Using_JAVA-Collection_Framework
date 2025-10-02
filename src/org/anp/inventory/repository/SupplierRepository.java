// SupplierRepository.java
package org.anp.inventory.repository;

import org.anp.inventory.Model.Supplier;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepository {
    private List<Supplier> suppliers = new ArrayList<>();

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return suppliers;
    }

    public Supplier findById(int id) {
        for (Supplier s : suppliers) {
            if (s.getSupplierId() == id) return s;
        }
        return null;
    }
}
