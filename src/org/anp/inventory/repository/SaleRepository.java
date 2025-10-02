package org.anp.inventory.repository;

import org.anp.inventory.Model.Sale;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {
    private List<Sale> sales = new ArrayList<>();

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public List<Sale> getAllSales() {
        return sales;
    }
}
