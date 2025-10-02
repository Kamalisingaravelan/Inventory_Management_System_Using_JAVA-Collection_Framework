package org.anp.inventory.Controller;

import org.anp.inventory.Model.Sale;
import org.anp.inventory.Service.SalesService;

import java.util.List;

public class SalesController {
    private SalesService service;

    public SalesController(SalesService service) {
        this.service = service;
    }

    public void addSale(Sale sale) {
        service.addSale(sale);
    }

    public List<Sale> listSales() {
        return service.listSales();
    }
}
