package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Book extends Resource {
	public Book(int id, Set<String> author, String release, String title) {
		super(id, author, release, title);
		IsRented = false;
		RentId = -1;
	}

	public Book() {
		Authors = new HashSet<>();
		Reservations = new ArrayList<>();
		RentId = -1;
		IsRented = false;
	}

	public boolean IsRented;
	public List<Integer> Reservations;
	public int RentId;

	@JsonGetter("Reservations")
	public List<Integer> getReservation() {
		return Reservations;
	}

	@JsonSetter("Reservations")
	public void setReservation(List<Integer> reservation) {
		this.Reservations = reservation;
	}

	@JsonGetter("IsRented")
	public boolean isRented() {
		return IsRented;
	}

	@JsonSetter("IsRented")
	public void setRented(boolean rented) {
		IsRented = rented;
	}

	@JsonGetter("Rent")
	public int getRent() {
		return RentId;
	}

	@JsonSetter("Rent")
	public void setRent(int rent) {
		this.RentId = rent;
	}

	public void addReservation(int reservationId){
		if(Reservations == null){
			Reservations = new ArrayList<>();
		}

		Reservations.add(reservationId);
	}
}