Inventory_Management_System_Using_JAVA-Collection_Framework
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

**Author**

Kamali Singaravelan
