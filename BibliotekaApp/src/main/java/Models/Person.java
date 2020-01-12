package Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public abstract class Person extends ModelBase {
	public Person() { }

	public Person(int Id, String name, String surname, String email) {
		super(Id);
		Name = name;
		Surname = surname;
		Email = email;
	}

	@JsonGetter("Name")
	public String getName() {
		return Name;
	}

	@JsonSetter("Name")
	public void setName(String name) {
		Name = name;
	}

	@JsonGetter("Surname")
	public String getSurname() {
		return Surname;
	}

	@JsonSetter("Surname")
	public void setSurname(String surname) {
		Surname = surname;
	}

	@JsonGetter("Email")
	public String getEmail() {
		return Email;
	}

	@JsonSetter("Email")
	public void setEmail(String email) {
		Email = email;
	}

	private String Name;

	private String Surname;

	private String Email;
}