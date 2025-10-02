package org.anp.inventory.Controller;

import org.anp.inventory.Service.SavingService;
import java.util.Map;

public class SavingController {
    private SavingService savingService;

    public SavingController(SavingService savingService) {
        this.savingService = savingService;
    }

    public void addSaving(int supplierId, double amount) {
        savingService.addSaving(supplierId, amount);
    }

    public Map<Integer, Double> getSupplierSavings() {
        return savingService.getSupplierSavings();
    }

    public double getTotalSavings() {
        return savingService.getTotalSavings();
    }
}
