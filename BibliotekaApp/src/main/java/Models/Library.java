package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class Library {
    public List<Administrator> Administrators;
    public List<Librarian> Librarians;
    public List<Reader> Readers;
    public List<Book> Books;
    public List<Magazine> Magazines;
    public List<Rent> Rents;
    public List<Reservation> Reservations;

    public List<Administrator> getAdministrators() {
        return Administrators;
    }

    public Library() {
    }

    public void setAdministrators(List<Administrator> administrators) {
        Administrators = administrators;
    }

    public Library(List<Administrator> administrators, List<Librarian> librarians, List<Reader> readers, List<Book> books, List<Magazine> magazines, List<Rent> rents, List<Reservation> reservations) {
        Administrators = administrators;
        Librarians = librarians;
        Readers = readers;
        Books = books;
        Magazines = magazines;
        Rents = rents;
        Reservations = reservations;
    }

    @JsonSetter("librarians")
    public void setLibrarians(List<Librarian> librarians) {
        Librarians = librarians;
    }

    @JsonGetter("readers")
    public List<Reader> getReaders() {
        return Readers;
    }

    @JsonGetter("readers")
    public void setReaders(List<Reader> readers) {
        Readers = readers;
    }

    @JsonGetter("books")
    public List<Book> getBooks() {
        return Books;
    }

    @JsonSetter("books")
    public void setBooks(List<Book> books) {
        Books = books;
    }

    @JsonGetter("magazines")
    public List<Magazine> getMagazines() {
        return Magazines;
    }

    @JsonSetter("magazines")
    public void setMagazines(List<Magazine> magazines) {
        Magazines = magazines;
    }

    @JsonGetter("rents")
    public List<Rent> getRents() {
        return Rents;
    }

    @JsonSetter("rents")
    public void setRents(List<Rent> rents) {
        Rents = rents;
    }

    @JsonGetter("reservations")
    public List<Reservation> getReservations() {
        return Reservations;
    }

    @JsonSetter("reservations")
    public void setReservations(List<Reservation> reservations) {
        Reservations = reservations;
    }
}
