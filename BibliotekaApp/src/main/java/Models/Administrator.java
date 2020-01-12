package Models;

public class Administrator extends LoggablePerson {
    public Administrator() { }

    public Administrator(int id, String name, String surname, String email, String login, String password) {
        super(id, name, surname, email, login, password);
    }
}