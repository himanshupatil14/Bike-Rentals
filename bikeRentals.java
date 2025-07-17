package oopsProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// --- Bike Class ---
class Bike 
{
    private String bikeId;
    private String company;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;
    
    //Parameterize Constructor
    public Bike(String bikeId, String company, String model, double basePricePerDay) 
    {
        this.bikeId = bikeId;
        this.company = company;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }
    
    //Getter
    public String getBikeId() 
    { 
    	return bikeId; 
    }
    public String getCompany() 
    { 
    	return company; 
    }
    public String getModel() 
    { 
    	return model; 
    }
    public boolean isAvailable() 
    { 
    	return isAvailable; 
    }
    public void rent() 
    { 
    	isAvailable = false; 
    }
    public void returnBike() 
    { 
    	isAvailable = true; 
    }
    
    //Calculate total Price

    public double calculatePrice(int rentalDays) 
    {
        return basePricePerDay * rentalDays;
    }
}

// --- Customer Class ---
class Customer 
{
    private String customerName;
    private String custPhoneNo;
    private String documentName;
    private String customerAddress;
    
    
    public Customer(String customerName, String custPhoneNo, String documentName, String customerAddress) 
    {
        this.customerName = customerName;
        this.custPhoneNo = custPhoneNo;
        this.documentName = documentName;
        this.customerAddress = customerAddress;
    }
    
    
    //Getter for Customer
    public String getCustomerName() 
    { 
    	return customerName; 
    }
    public String getCustPhoneNo() 
    { 
    	return custPhoneNo; 
    }
    public String getDocumentName() 
    { 
    	return documentName; 
    }
    public String getCustomerAddress() 
    { 
    	return customerAddress; 
    }
}

// --- Rental Class ---
class Rental {
    private Bike bike;
    private Customer customer;
    private int days;

    public Rental(Bike bike, Customer customer, int days) {
        this.bike = bike;
        this.customer = customer;
        this.days = days;
    }

    public Bike getBike() 
    { 
    	return bike; 
    }
    public Customer getCustomer() 
    { 
    	return customer; 
    }
    public int getDays() 
    { 
    	return days; 
    }
}

// --- BikeRentalSystem Class ---

class BikeRentalSystem {
	//List = Flexible Size
    private List<Bike> bikes;
    private List<Customer> customers;
    private List<Rental> rentals;

    public BikeRentalSystem() 
    {
        bikes = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addBike(Bike bike) 
    {
        bikes.add(bike);
    }

    public void addCustomer(Customer customer) 
    {
        customers.add(customer);
    }

    public void rentBike(Bike bike, Customer customer, int days) 
    {
        if (bike.isAvailable()) 
        {
            bike.rent();
            rentals.add(new Rental(bike, customer, days));
        } 
        else 
        {
            System.out.println("Bike is not available for rent.");
        }
    }

    public void returnBike(Bike bike) 
    {
        bike.returnBike();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) 
        {
            if (rental.getBike() == bike) 
            {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) 
        {
            rentals.remove(rentalToRemove);
            System.out.println("Bike returned successfully.");
        } 
        else 
        {
            System.out.println("Bike was not rented.");
        }
    }

    public void menu() 
    {
        Scanner scan = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\n--- Bike Rental System ---");
            System.out.println("1. Rent a Bike");
            System.out.println("2. Return a Bike");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            // consume newline
            scan.nextLine(); 

            if (choice == 1) 
            {
                System.out.print("Enter Name: ");
                String name = scan.nextLine();
                System.out.print("Enter Phone No: ");
                String phone = scan.nextLine();
                System.out.print("Enter Document: ");
                String doc = scan.nextLine();
                System.out.print("Enter Address: ");
                String address = scan.nextLine();

                System.out.println("\nAvailable Bikes:");
                for (Bike bike : bikes) 
                {
                    if (bike.isAvailable()) 
                    {
                        System.out.println(bike.getBikeId() + " - " + bike.getCompany() + " - " + bike.getModel());
                    }
                }

                System.out.print("Enter Bike ID to Rent: ");
                String bikeId = scan.nextLine();

                Bike selectedBike = null;
                for (Bike bike : bikes) 
                {
                    if (bike.getBikeId().equals(bikeId) && bike.isAvailable()) 
                    {
                        selectedBike = bike;
                        break;
                    }
                }

                if (selectedBike != null) 
                {
                    System.out.print("Enter number of rental days: ");
                    int days = scan.nextInt();
                    scan.nextLine();

                    double totalPrice = selectedBike.calculatePrice(days);
                    Customer customer = new Customer(name, phone, doc, address);
                    addCustomer(customer);

                    System.out.println("\n--- Rental Details ---");
                    System.out.println("Customer Name: " + customer.getCustomerName());
                    System.out.println("Phone: " + customer.getCustPhoneNo());
                    System.out.println("Bike: " + selectedBike.getCompany() + " " + selectedBike.getModel());
                    System.out.println("Days: " + days);
                    System.out.printf("Total Price: ₹%.2f\n", totalPrice);
                    System.out.print("Confirm rental (Y/N)? ");
                    String confirm = scan.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) 
                    {
                        rentBike(selectedBike, customer, days);
                        System.out.println("Bike rented successfully!");
                        System.out.println("Thank You");
                        System.out.println("------------------------------------------");
                    } 
                    else 
                    {
                        System.out.println("Rental cancelled.");
                        System.out.println("------------------------------------------");
                    }
                } 
                else 
                {
                    System.out.println("Invalid bike ID or bike not available.");
                    System.out.println("------------------------------------------");
                }

            } else if (choice == 2) 
            {
                System.out.print("Enter Bike ID to return: ");
                String returnId = scan.nextLine();

                Bike bikeToReturn = null;
                for (Bike bike : bikes) 
                {
                    if (bike.getBikeId().equals(returnId) && !bike.isAvailable()) 
                    {
                        bikeToReturn = bike;
                        break;
                    }
                }

                if (bikeToReturn != null) 
                {
                    returnBike(bikeToReturn);
                } 
                else 
                {
                    System.out.println("Invalid Bike ID or bike is not rented.");
                    System.out.println("------------------------------------------");
                }

            } else if (choice == 3) 
            {
                System.out.println("Exiting Bike Rental System. Thank you!");
                System.out.println("------------------------------------------");
                break;
            } 
            else 
            {
                System.out.println("Invalid option.");
                System.out.println("------------------------------------------");
            }
        }

    }
}

// --- Main Class ---
public class bikeRentals {
    public static void main(String[] args) {
        BikeRentalSystem system = new BikeRentalSystem();
        system.addBike(new Bike("H101", "Bajaj", "Pulsar NS125", 300));
        system.addBike(new Bike("H102", "Honda", "CB350", 350));
        system.addBike(new Bike("H103", "Benelli", "Leoncino500", 500));
        system.addBike(new Bike("H104", "TVS", "Jupiter", 250));
        

        system.menu();
    }
}
