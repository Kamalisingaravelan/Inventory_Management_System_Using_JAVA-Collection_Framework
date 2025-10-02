package org.anp.inventory.Service;

import org.anp.inventory.Model.Sale;
import org.anp.inventory.repository.SaleRepository;
import java.util.List;

public class SalesService {
    private SaleRepository repo;

    public SalesService(SaleRepository repo) {
        this.repo = repo;
    }

    public void addSale(Sale sale) {
        repo.addSale(sale);
    }

    public List<Sale> listSales() {
        return repo.getAllSales();
    }
}
