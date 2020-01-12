package DataAccess;

import Models.*;

import java.io.IOException;
import java.util.List;

public class LibraryContext {
    private LibrarySerializer _serializer;

    public LibraryContext(String repoString) throws IOException {
        _serializer = new LibrarySerializer(repoString);
    }

    public List<? extends ModelBase> Get(Class<? extends ModelBase> clazz) {
        switch (clazz.getSimpleName()){
            case "Administrator":
                return _serializer.Library.Administrators;
            case "Book":
                return _serializer.Library.Books;
            case "Librarian":
                return _serializer.Library.Librarians;
            case "Magazine":
                return _serializer.Library.Magazines;
            case "Reader":
                return _serializer.Library.Readers;
            case "Rent":
                return _serializer.Library.Rents;
            case "Reservation":
                return _serializer.Library.Reservations;
            default:
                return null;
        }
    }

    public void Set(Class<? extends ModelBase> clazz, ModelBase update){
        switch (clazz.getSimpleName()){
            case "Administrator":
                _serializer.Library.Administrators.set(update.Id, (Administrator) update);
                break;
            case "Book":
                _serializer.Library.Books.set(update.Id, (Book) update);
                break;
            case "Librarian":
                _serializer.Library.Librarians.set(update.Id, (Librarian) update);
                break;
            case "Magazine":
                _serializer.Library.Magazines.set(update.Id, (Magazine) update);
                break;
            case "Reader":
                _serializer.Library.Readers.set(update.Id, (Reader) update);
                break;
            case "Rent":
                _serializer.Library.Rents.set(update.Id, (Rent) update);
                break;
            case "Reservation":
                _serializer.Library.Reservations.set(update.Id, (Reservation) update);
                break;
        }
    }

    public void Add(Class<? extends ModelBase> clazz, ModelBase update) {
        switch (clazz.getSimpleName()) {
            case "Administrator":
                _serializer.Library.Administrators.add((Administrator) update);
                break;
            case "Book":
                _serializer.Library.Books.add((Book) update);
                break;
            case "Librarian":
                _serializer.Library.Librarians.add((Librarian) update);
                break;
            case "Magazine":
                _serializer.Library.Magazines.add((Magazine) update);
                break;
            case "Reader":
                _serializer.Library.Readers.add((Reader) update);
                break;
            case "Rent":
                _serializer.Library.Rents.add((Rent) update);
                break;
            case "Reservation":
                _serializer.Library.Reservations.add((Reservation) update);
                break;
        }
    }

    public void Remove(Class<? extends ModelBase> clazz, int index){
        switch (clazz.getSimpleName()) {
            case "Administrator":
                _serializer.Library.Administrators.remove(index);
                for(int i = index; i < _serializer.Library.Administrators.size(); i++){
                    var element = _serializer.Library.Administrators.get(i);
                    element.setId(i);
                    _serializer.Library.Administrators.set(i, element);
                }

                break;
            case "Book":
                _serializer.Library.Books.remove(index);
                for(int i = index; i < _serializer.Library.Books.size(); i++){
                    var element = _serializer.Library.Books.get(i);
                    element.setId(i);
                    _serializer.Library.Books.set(i, element);
                }

                break;
            case "Librarian":
                _serializer.Library.Librarians.remove(index);
                for(int i = index; i < _serializer.Library.Librarians.size(); i++){
                    var element = _serializer.Library.Librarians.get(i);
                    element.setId(i);
                    _serializer.Library.Librarians.set(i, element);
                }

                break;
            case "Magazine":
                _serializer.Library.Magazines.remove(index);
                for(int i = index; i < _serializer.Library.Magazines.size(); i++){
                    var element = _serializer.Library.Magazines.get(i);
                    element.setId(i);
                    _serializer.Library.Magazines.set(i, element);
                }

                break;
            case "Reader":
                _serializer.Library.Readers.remove(index);
                for(int i = index; i < _serializer.Library.Readers.size(); i++){
                    var element = _serializer.Library.Readers.get(i);
                    element.setId(i);
                    _serializer.Library.Readers.set(i, element);
                }

                break;
            case "Rent":
                _serializer.Library.Rents.remove(index);
                for(int i = index; i < _serializer.Library.Rents.size(); i++){
                    var element = _serializer.Library.Rents.get(i);
                    element.setId(i);
                    _serializer.Library.Rents.set(i, element);
                }

                break;
            case "Reservation":
                _serializer.Library.Reservations.remove(index);
                for(int i = index; i < _serializer.Library.Reservations.size(); i++){
                    var element = _serializer.Library.Reservations.get(i);
                    element.setId(i);
                    _serializer.Library.Reservations.set(i, element);
                }

                break;
        }
    }

    public void SaveChanges() throws IOException {
        _serializer.SaveChanges();
    }

}
