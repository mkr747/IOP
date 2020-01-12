package Models; /**
 * 
 */

import Controllers.*;

public class Librarian extends LoggablePerson {
    public Librarian() {}

    public Librarian(int id, String name, String surname, String email, String login, String password) {
        super(id, name, surname, email, login, password);
    }
}