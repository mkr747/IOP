package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;

public class Reservation extends Deadline {
	@JsonGetter("Book")
	public int getBook() {
		return Book;
	}

	@JsonSetter("Book")
	public void setBook(int book) {
		this.Book = book;
	}

	@JsonGetter("Reader")
	public int getReader() {
		return Reader;
	}

	@JsonSetter("Reader")
	public void setReader(int reader) {
		this.Reader = reader;
	}

	public Integer Book;

	public int Reader;

	public Reservation() { }

	public Reservation(int id, Date startDate, Date endDate, int book, int reader) {
		super(id, startDate, endDate);
		this.Book = book;
		this.Reader = reader;
	}

	public void Print() {
		System.out.print("Reservation Id: " + getId());
	}
}