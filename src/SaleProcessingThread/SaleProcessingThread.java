package SaleProcessingThread;

import org.anp.inventory.Model.Sale;
import org.anp.inventory.Controller.SavingController;

public class SaleProcessingThread extends Thread {
    private Sale sale;
    private SavingController savingController;

    public SaleProcessingThread(Sale sale, SavingController savingController) {
        this.sale = sale;
        this.savingController = savingController;
    }

    @Override
    public void run() {
        // Optional: simulate processing delay
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Update savings with supplier ID
        int supplierId = (sale.getSupplier() == null) ? 0 : sale.getSupplier().getSupplierId();
        savingController.addSaving(supplierId, sale.getQuantity() * sale.getProduct().getPrice());

        // ❌ Removed print statement to avoid duplicate message
    }
}
