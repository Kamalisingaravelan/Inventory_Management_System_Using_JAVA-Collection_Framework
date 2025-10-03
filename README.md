<img width="3291" height="332" alt="image" src="https://github.com/user-attachments/assets/5af85feb-ea8f-4f19-a5c3-6705ba2b60a1" />Inventory_Management_System_Using_JAVA-Collection_Framework
  A Java-based Inventory Management System implemented using Collection Framework for storing and managing product details

# Inventory Management System (Java)

A **Java-based CLI application** that manages inventory details such as products, quantities, and prices.  
This version uses **Collection Framework** to store and process data efficiently.

## Project Structure
- Model: Product, Supplier, Sale, Saving
- Repository: Handles data storage using lists
- Service: Business logic for inventory, sales, suppliers, savings
- Controller: Connects service with main UI
- Main: Provides console-based menu
- Thread: SaleProcessingThread handles sales asynchronously


## System Workflow 
- User adds products and suppliers
- User makes a sale by selecting a product and quantity
- SaleProcessingThread processes the sale
- Stock quantity is updated
- Sale details and total savings are recorded
- User can view reports via menu


## Features
- Add new products to the inventory
- Update product details (quantity, price)
- Delete products
- Search products by name or ID
- Sales processing handled in a separate thread
- User-friendly CLI menu system

## Tech Stack
- Java (Core, MVC, OOP, Multithreading)
- Collection Framework (`ArrayList`, `HashMap`, etc.)

## Installation/Setup instructions
  ### Install Eclipse IDE
  - Start the Eclipse IDE Installer
  - Configure the installation location
  - Launch the Eclipse IDE
  - Configure workspace


## Future Improvements
- Add JDBC + MySQL integration (next version)
- Implement GUI using JavaFX or Swing

# Conclusion 
- The Inventory Management System provides a modular and efficient way to manage products, suppliers, and sales.
- Threading enhances performance by processing sales in the background.
- Can be further extended with database integration and GUI.

**Author**

Kamali Singaravelan
