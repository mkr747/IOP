package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Date;


public class Rent extends Deadline {
	public int BookId;
	public int ReaderId;

	public Rent() { }

	public Rent(int id, Date startDate, Date endDate, int bookId, int readerId) {
		super(id, startDate, endDate);
		this.BookId = bookId;
		this.ReaderId = readerId;
	}

	@JsonGetter("Book")
	public int getBook() {
		return BookId;
	}

	@JsonSetter("Book")
	public void setBook(int book) {
		this.BookId = book;
	}

	@JsonGetter("Reader")
	public int getReader() {
		return ReaderId;
	}

	@JsonSetter("Reader")
	public void setReader(int reader) {
		this.ReaderId = reader;
	}

	public Rent(int id, Date startDate, Date endDate) {
		super(id, startDate, endDate);
	}

	public void Print() {
		System.out.print("Id: " + getId());
		System.out.print(", Rent duration: " + getStartDate());
		System.out.println(" - " + getEndDate());
	}
}