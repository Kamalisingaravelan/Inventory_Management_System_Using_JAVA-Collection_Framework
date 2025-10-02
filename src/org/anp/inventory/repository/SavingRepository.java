package org.anp.inventory.repository;

import java.util.HashMap;
import java.util.Map;

public class SavingRepository {
    private Map<Integer, Double> supplierSavings = new HashMap<>();

    public void addSaving(int supplierId, double amount) {
        supplierSavings.put(supplierId, supplierSavings.getOrDefault(supplierId, 0.0) + amount);
    }

    public Map<Integer, Double> getSupplierSavings() {
        return supplierSavings;
    }

    public double getTotalSavings() {
        return supplierSavings.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}
