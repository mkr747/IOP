package Services;

import Controllers.BookController;
import Controllers.ReaderController;
import Controllers.RentController;
import Models.Rent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class RentService {
    private final BookController _bookController;
    private final RentController _rentController;
    private final ReaderController _readerController;
    private final Scanner _scanner;

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public RentService(BookController bookController,
                       RentController rentController,
                       ReaderController readerController,
                       Scanner scanner){
        _bookController = bookController;
        _rentController = rentController;
        _readerController = readerController;
        _scanner = scanner;
    }

    public boolean RentBook(int bookIndex, int readerIndex) {
        var book = _bookController.Get(bookIndex);
        var reader = _readerController.Get(readerIndex);
        if(book.isRented() || book.getReservation() != null) {
            System.out.println("Book isn't available");
            return false;
        }

        System.out.println("Length of rent in days:");
        var days = _scanner.nextInt();
        var date = new Date();
        var counter = _rentController.GetAll().size();
        var c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, days);
        var endDate = c.getTime();
        var rent = new Rent(counter, date, endDate, book.getId(), reader.getId());
        reader.addRent(rent.getId());
        book.setRented(true);
        book.setRent(rent.getId());

        if(_bookController.Patch(book) && _readerController.Patch(reader) && _rentController.Post(rent)){
            System.out.println("The book has been rented");
            String form =  dateFormat.format(rent.getEndDate().getTime());
            System.out.println(String.format("Deadline for rent %s ends on %s", book.getId(), form));
        }

        return true;
    }

    public void PrintRentLine(Rent rent) {
        System.out.print("Id: " + rent.getId());
        System.out.print(", Rent duration: " + rent.getStartDate());
        System.out.println(" - " + rent.getEndDate());
    }

    public void ReturnBook(int rentId){
        var rent = _rentController.Get(rentId);
        var book = _bookController.Get(rent.getBook());
        var reader = _readerController.Get(rent.getReader());

        reader.Rents.remove(rent.getId());
        book.setRent(-1);
        book.setRented(false);

        if(_rentController.Delete(rentId) && _readerController.Patch(reader) && _bookController.Patch(book)) {
            System.out.println(String.format("The book %s has been returned", book.getTitle()));
        }
    }

    public int GetRent(int readerId){
        var rents =  _rentController.GetAll();
        for(var rent : rents){
            if(rent.getReader() == readerId){
                return rent.getReader();
            }
        }

        return -1;
    }

    public void ShowRents() {
        var rents = _rentController.GetAll();
        System.out.println("Id   |    StartDate    |    EndDate   "); // 4 10 13 10 11 5
        for(var rent : rents) {
            var output = String.format("%-4.4s | %-15.15s | %-12.12s ", rent.getId(), rent.getStartDate(), rent.getEndDate());
            System.out.println(output);
        }

        RentMenu();
    }

    private void RentMenu() {
        System.out.println("" +
                "[1] Show rent \n" +
                "[2] Rent book\n" +
                "[3] Return book\n" +
                "[0] Back");
        int index;
        switch(_scanner.nextInt()){
            case 1:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                PrintRentMenu(index);
                break;
            case 2:
                System.out.print("Book id: ");
                var bookIndex = _scanner.nextInt();
                System.out.print("Reader id: ");
                var readerIndex = _scanner.nextInt();
                RentBook(bookIndex, readerIndex);
                break;
            case 3:
                System.out.print("Rent index: ");
                index = _scanner.nextInt();
                ReturnBook(index);
                break;
            case 0:
        }
    }

    private void PrintRentMenu(int rentId) {
        var rent = _rentController.Get(rentId);
        rent.Print();
        System.out.println("" +
                "[0] Back");

        switch (_scanner.nextInt()) {
            case 0:
                ShowRents();
        }
    }
}