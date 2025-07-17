#  Bike Rental System in Java
A simple console-based Bike Rental System written in Java to demonstrate core Object-Oriented Programming (OOP) concepts such as **Encapsulation**, **Abstraction**, **Composition**, and **List-based data management** using ArrayList.

This project allows users to rent and return bikes, manage customer details, and calculate rental costs through an interactive menu.
##  OOP Concepts Used
-  **Encapsulation**: All class fields are private and accessed via getter/setter methods.
-  **Abstraction**: The system hides internal logic from the user and provides a menu-driven interface.
-  **Composition**: The Rental class is composed of Bike and Customer objects.
-  **Modular Design**: Code is divided into logical classes (Bike, Customer, Rental, System, Main).

##  Features

- Add multiple bikes to the system
- Rent a bike by entering customer details
- Show only available bikes for rent
- Calculate total rental price based on per-day rate
- Return a bike and remove it from active rentals
- Input validation and status messages for user guidance

---

##  Sample Console Output
--- Bike Rental System ---
1. Rent a Bike
2. Return a Bike
3. Exit
- Enter your choice: 1

- Enter Name: Himanshu
- Enter Phone No: 8390870115
- Enter Document: Aadhar Card
- Enter Address: Pune

--- Available Bikes ---
- H101 - Bajaj - Pulsar NS125
- H102 - Honda - CB350
- H103 - TVS - Jupiter
  
 Enter Bike ID to Rent: H101
 Enter number of rental days: 3


--- Rental Details ---
 Customer Name: Himanshu
 Phone: 8390870115
 Bike: Bajaj Pulsar NS125
 Days: 3
 Total Price: ₹900.00
 
 Confirm rental (Y/N)? Y
 Bike rented successfully!
 Thank You









