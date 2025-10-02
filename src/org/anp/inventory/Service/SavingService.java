package org.anp.inventory.Service;

import org.anp.inventory.repository.SavingRepository;
import java.util.Map;

public class SavingService {
    private SavingRepository savingRepo;

    public SavingService(SavingRepository savingRepo) {
        this.savingRepo = savingRepo;
    }

    public void addSaving(int supplierId, double amount) {
        savingRepo.addSaving(supplierId, amount);
    }

    public Map<Integer, Double> getSupplierSavings() {
        return savingRepo.getSupplierSavings();
    }

    public double getTotalSavings() {
        return savingRepo.getTotalSavings();
    }
}
