package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {
	public String Address;

	public Set<Integer> Rents;

	public Set<Integer> Reservations;
	@JsonGetter("Rents")
	public Set<Integer> getRents() {
		return Rents;
	}

	@JsonSetter("Rents")
	public void setRents(Set<Integer> rents) {
		Rents = rents;
	}

	@JsonGetter("Reservations")
	public Set<Integer> getReservations() {
		return Reservations;
	}

	@JsonSetter("Reservations")
	public void setReservations(Set<Integer> reservations) {
		Reservations = reservations;
	}

	@JsonGetter("Address")
	public String getAddress() {
		return Address;
	}

	@JsonSetter("Address")
	public void setAddress(String address) {
		Address = address;
	}

	public void addRent(int rent) {
		if(Rents == null){
			Rents = new HashSet<>();
		}

		this.Rents.add(rent);
	}

	public void addReservation(int reservation) {
		if(Reservations == null){
			Reservations = new HashSet<>();
		}

		this.Reservations.add(reservation);
	}


	public Reader() {
		this.Reservations = new HashSet<>();
		this.Rents = new HashSet<>();
	}

	public Reader(int Id, String name, String surname, String email, String address, Set<Integer> rents, Set<Integer> reservations) {
		super(Id, name, surname, email);
		Address = address;
		this.Rents = rents;
		Reservations = reservations;
	}

	public Reader(int id, String name, String surname, String email) {
		super(id, name, surname, email);
	}

	public void Print() {
		System.out.println("Reader: ");
		System.out.println("	Id: " + getId());
		System.out.println("	Name: " + getName());
		System.out.println("	Surname: " + getSurname());
		System.out.println("	Email: " + getEmail());
		System.out.println("	Address:" + getAddress());
	}
}