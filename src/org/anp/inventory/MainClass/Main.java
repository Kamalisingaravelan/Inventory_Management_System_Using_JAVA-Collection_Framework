package org.anp.inventory.MainClass;

import org.anp.inventory.Controller.*;
import org.anp.inventory.Model.*;
import org.anp.inventory.Service.*;
import org.anp.inventory.repository.*;
import SaleProcessingThread.SaleProcessingThread;

import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepo = new ProductRepository();
        SupplierRepository supplierRepo = new SupplierRepository();
        SaleRepository saleRepo = new SaleRepository();
        SavingRepository savingRepo = new SavingRepository();

        InventoryController inventoryController = new InventoryController(new InventoryService(productRepo));
        SupplierController supplierController = new SupplierController(new SupplierService(supplierRepo));
        SalesController salesController = new SalesController(new SalesService(saleRepo));
        SavingController savingController = new SavingController(new SavingService(savingRepo));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Inventory Management Menu ====");
            System.out.println("1. Add Product\n2. List Products\n3. Add Supplier\n4. List Suppliers");
            System.out.println("5. Make Sale\n6. List Sales\n7. View Savings\n8. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter Product ID: "); 
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: "); 
                    String pname = sc.nextLine();
                    System.out.print("Enter Quantity: "); 
                    int pqty = sc.nextInt();
                    System.out.print("Enter Price: "); 
                    double price = sc.nextDouble();
                    sc.nextLine();

                    boolean exists = false;
                    for (Product p : inventoryController.listProducts()) {
                        if (p.getId() == pid) exists = true;
                    }
                    if (!exists) inventoryController.addProduct(new Product(pid, pname, pqty, price));

                    System.out.println("✅ Product added successfully!");
                    break;

                case 2:
                    if (inventoryController.listProducts().isEmpty()) {
                        System.out.println("⚠️ No products available in inventory!");
                    } else {
                        System.out.println("Here are the Products in Inventory:");
                        for (Product p : inventoryController.listProducts()) System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Enter Supplier ID: "); 
                    int sid = sc.nextInt();
                    sc.nextLine();

                    Supplier existingSupplier = null;
                    for (Supplier s : supplierController.listSuppliers()) {
                        if (s.getSupplierId() == sid) {
                            existingSupplier = s;
                            break;
                        }
                    }

                    if (existingSupplier == null) {
                        System.out.print("Enter Supplier Name: "); 
                        String sname = sc.nextLine();
                        System.out.print("Enter Supplier Phone: "); 
                        String phone = sc.nextLine();
                        existingSupplier = new Supplier(sid, sname, phone);
                        supplierController.addSupplier(existingSupplier);
                        System.out.println("✅ Supplier added successfully!");
                    } else {
                        System.out.println("ℹ️ Supplier with ID " + sid + " already exists: " + existingSupplier.getName());
                    }

                    while (true) {
                        System.out.print("Do you want to add a product for this supplier? (y/n): ");
                        String ans = sc.nextLine();
                        if (!ans.equalsIgnoreCase("y")) break;

                        System.out.print("Enter Product ID: "); 
                        int spid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Product Name: "); 
                        String spname = sc.nextLine();
                        System.out.print("Enter Quantity: "); 
                        int sqty = sc.nextInt();
                        System.out.print("Enter Price: "); 
                        double sprice = sc.nextDouble();
                        sc.nextLine();

                        Product sProduct = new Product(spid, spname, sqty, sprice);

                        // Add to global inventory if not exists
                        boolean alreadyInInventory = false;
                        for (Product p : inventoryController.listProducts()) {
                            if (p.getId() == spid) alreadyInInventory = true;
                        }
                        if (!alreadyInInventory) inventoryController.addProduct(sProduct);

                        // Add to supplier safely
                        if (existingSupplier.addProduct(sProduct)) {
                            System.out.println("✅ Product added to supplier " + existingSupplier.getName());
                        } else {
                            System.out.println("⚠️ Product with ID " + sProduct.getId() + " already exists for this supplier.");
                        }
                    }
                    break;

                case 4:
                    if (supplierController.listSuppliers().isEmpty()) {
                        System.out.println("⚠️ No suppliers available!");
                    } else {
                        System.out.println("Here are the Suppliers and their Products:");
                        for (Supplier s : supplierController.listSuppliers()) {
                            System.out.println(s);
                            if (s.getProducts().isEmpty()) {
                                System.out.println("   -> No products assigned");
                            } else {
                                for (Product p : s.getProducts()) System.out.println("   -> " + p);
                            }
                        }
                    }
                    break;

                case 5:
                    if (inventoryController.listProducts().isEmpty()) {
                        System.out.println("⚠️ No products available to make a sale!");
                        break;
                    }

                    // Show products without suppliers (Unknown)
                    System.out.println("Here are products initially added (Unknown Supplier):");
                    for (Product p : inventoryController.listProducts()) {
                        boolean belongsToSupplier = false;
                        for (Supplier s : supplierController.listSuppliers()) {
                            if (s.getProducts().contains(p)) belongsToSupplier = true;
                        }
                        if (!belongsToSupplier) System.out.println(p);
                    }

                    // Show all suppliers
                    System.out.println("\nHere are New Suppliers and their Products:");
                    for (Supplier s : supplierController.listSuppliers()) System.out.println(s);

                    System.out.print("Enter Supplier ID (or 0 for Unknown): ");
                    int sellSupplierId = sc.nextInt();
                    sc.nextLine();

                    Supplier chosenSupplier = null;
                    if (sellSupplierId == 0) {
                        chosenSupplier = new Supplier(0, "Unknown", "N/A");
                    } else {
                        for (Supplier s : supplierController.listSuppliers()) {
                            if (s.getSupplierId() == sellSupplierId) {
                                chosenSupplier = s;
                                break;
                            }
                        }
                    }

                    if (chosenSupplier == null) {
                        System.out.println("⚠️ Invalid Supplier ID!");
                        break;
                    }

                    System.out.println("Available Products to Sell:");
                    if (chosenSupplier.getSupplierId() == 0) {
                        for (Product p : inventoryController.listProducts()) {
                            boolean belongsToSupplier = false;
                            for (Supplier s : supplierController.listSuppliers()) {
                                if (s.getProducts().contains(p)) belongsToSupplier = true;
                            }
                            if (!belongsToSupplier) System.out.println(p);
                        }
                    } else {
                        for (Product p : chosenSupplier.getProducts()) System.out.println(p);
                    }

                    System.out.print("Enter Product ID to sell: ");
                    int sellProductId = sc.nextInt();
                    sc.nextLine();

                    Product chosenProduct = null;
                    if (chosenSupplier.getSupplierId() == 0) {
                        for (Product p : inventoryController.listProducts()) {
                            boolean belongsToSupplier = false;
                            for (Supplier s : supplierController.listSuppliers()) {
                                if (s.getProducts().contains(p)) belongsToSupplier = true;
                            }
                            if (!belongsToSupplier && p.getId() == sellProductId) {
                                chosenProduct = p;
                                break;
                            }
                        }
                    } else {
                        for (Product p : chosenSupplier.getProducts()) {
                            if (p.getId() == sellProductId) {
                                chosenProduct = p;
                                break;
                            }
                        }
                    }

                    if (chosenProduct == null) {
                        System.out.println("⚠️ Invalid Product ID!");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();
                    sc.nextLine();

                    if (chosenProduct.getQuantity() >= sellQty) {
                        chosenProduct.setQuantity(chosenProduct.getQuantity() - sellQty);

                        Sale sale = new Sale(chosenProduct, chosenSupplier, sellQty);
                        salesController.addSale(sale);

                        // Start thread to process savings
                        SaleProcessingThread saleThread = new SaleProcessingThread(sale, savingController);
                        saleThread.start();

                        // ✅ Print success message once
                        System.out.println("✅ Sale processed successfully for Product: " 
                            + chosenProduct.getName() + ", Quantity: " + sellQty);

                    } else {
                        System.out.println("⚠️ Insufficient stock!");
                    }
                    break;


                case 6:
                    if (salesController.listSales().isEmpty()) {
                        System.out.println("⚠️ No sales have been made yet!");
                    } else {
                        System.out.println("Here are the Sales:");
                        for (Sale s : salesController.listSales()) System.out.println(s);
                    }
                    break;

                case 7:
                    if (savingController.getSupplierSavings().isEmpty()) {
                        System.out.println("⚠️ No savings recorded yet!");
                    } else {
                        System.out.println("Savings by Supplier:");
                        for (Map.Entry<Integer, Double> entry : savingController.getSupplierSavings().entrySet()) {
                            String supplierName;
                            if (entry.getKey() == 0) supplierName = "Unknown";
                            else {
                                supplierName = supplierController.listSuppliers().stream()
                                        .filter(s -> s.getSupplierId() == entry.getKey())
                                        .map(Supplier::getName)
                                        .findFirst().orElse("Unknown");
                            }
                            System.out.println("Supplier " + supplierName + " -> " + entry.getValue());
                        }
                        System.out.println("Total Savings -> " + savingController.getTotalSavings());
                    }
                    break;

                case 8:
                    running = false;
                    System.out.println("Thank you! Visit again.");
                    break;

                default:
                    System.out.println("⚠️ Invalid option!");
            }
        }
        sc.close();
    }
}
