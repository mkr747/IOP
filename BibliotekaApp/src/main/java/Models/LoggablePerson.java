package Models; /**
 * 
 */

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author mkretkow
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class LoggablePerson extends Person {
	private String Login;
	private String Password;

	public LoggablePerson() {}

	public LoggablePerson(int id, String name, String surname, String email, String login, String password) {
		super(id, name, surname, email);
		Login = login;
		Password = password;
	}

	@JsonGetter("Login")
	public String getLogin() {
		return Login;
	}

	@JsonSetter("Login")
	public void setLogin(String login) {
		Login = login;
	}

	@JsonGetter("Password")
	public String getPassword() {
		return Password;
	}

	@JsonSetter("Password")
	public void setPassword(String password) {
		Password = password;
	}
}