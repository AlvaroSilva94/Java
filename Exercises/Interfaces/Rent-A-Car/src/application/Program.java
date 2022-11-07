package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.PTTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	System.out.println("Enter the retal data!");
	System.out.print("Model of the vehicle: ");
	String carModel = sc.nextLine();
	System.out.println("Pickup time (dd/MM/yyyy hh:mm): ");
	LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
	System.out.println("Dropoff time (dd/MM/yyyy hh:mm): ");
	LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);
	
	CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
	
	System.out.print("Enter price per hour: ");
	double pricePerHour = sc.nextDouble();
	System.out.print("Enter price per day: ");
	double pricePerDay = sc.nextDouble();
	
	RentalService rentalService = new RentalService(pricePerHour, pricePerDay,new PTTaxService());
	
	rentalService.processInvoice(cr);
	
	System.out.println("Invoice:");
	System.out.println("Basic Payment: " + cr.getInvoice().getBasicPayment());
	System.out.println("Tax: " + cr.getInvoice().getTax());
	System.out.println("Total payment: " + cr.getInvoice().getTotalPayment());
	
	sc.close();
	}

}
