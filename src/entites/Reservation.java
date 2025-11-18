package entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
	private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Integer rooNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reservation() {
	}

	public Reservation(Integer roonumber, LocalDate checkin, LocalDate checkout) {
		this.rooNumber =  roonumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRooNumber() {
		return rooNumber;
	}

	public void setRooNumber(Integer rooNumber) {
		this.rooNumber = rooNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public long duration() {
		return ChronoUnit.DAYS.between(checkout, checkin);
	}
	
	public void updateDates(LocalDate checkin, LocalDate checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	
	@Override
	public String toString() {
		return "Room " + 
				rooNumber +
				", check-in: " +
				fmt.format(checkin) +
				", check-out: " +
				fmt.format(checkin) +
				", " +
				duration() +
				"nights";
	}
	
}
