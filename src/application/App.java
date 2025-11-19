package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class App {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.nextLine(), fmt);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.nextLine(), fmt);
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			
			System.out.println();
			System.out.println("Enter date to update the reversation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.nextLine(), fmt);
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.nextLine(), fmt);
			
			reservation.updateDates(checkIn, checkOut);
		}
		catch(DomainExceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("invalide data");
		}
		
		
		sc.close();
		
	}
}
