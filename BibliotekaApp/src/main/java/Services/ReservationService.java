package Services;

import Controllers.BookController;
import Controllers.ReaderController;
import Controllers.ReservationController;
import Models.Rent;
import Models.Reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class ReservationService {
    private final BookController _bookController;
    private final ReservationController _reservationController;
    private final ReaderController _readerController;
    private final Scanner _scanner;

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public ReservationService(BookController bookController, ReservationController reservationController, ReaderController readerController, Scanner scanner){
        _bookController = bookController;
        _reservationController = reservationController;
        _readerController = readerController;
        _scanner = scanner;
    }

    public boolean ReserveBook(int bookId, int readerId){
        var book = _bookController.Get(bookId);
        if(!book.isRented()) {
            System.out.println("Book is available, you can rent it.");
            return false;
        }

        var reader = _readerController.Get(readerId);
        var counter = _reservationController.GetAll().size();
        reader.addReservation(reader.getId());

        var date = new java.util.Date();
        var c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 2);
        var endDate = c.getTime();
        var reservation = new Reservation(counter, date, endDate, bookId, readerId);
        reader.addReservation(reservation.getId());
        book.addReservation(reservation.getId());

        if(_bookController.Patch(book) && _readerController.Patch(reader) && _reservationController.Post(reservation)){
            System.out.println("The book has been reserved");

            return true;
        }

        System.out.println("The book has NOT been rented");

        return false;
    }

    public int GetReservation(int readerId){
        var reservations =  _reservationController.GetAll();
        for(var reservation : reservations){
            if(reservation.getReader() == readerId){
                return reservation.getReader();
            }
        }

        return -1;
    }

    public void ShowReservations() {
        var reservations = _reservationController.GetAll();
        System.out.println("Id   |    StartDate    |    EndDate   "); // 4 10 13 10 11 5
        for(var reservation : reservations) {
            var output = String.format("%-4.4s | %-15.15s | %-12.12s ", reservation.getId(), reservation.getStartDate(), reservation.getEndDate());
            System.out.println(output);
        }

        ReservationMenu();
    }

    private void ReservationMenu() {
        System.out.println("" +
                "[1] Show reservation \n" +
                "[2] Reserve book\n" +
                "[0] Back");
        int index;
        switch(_scanner.nextInt()){
            case 1:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                PrintReservationMenu(index);
                break;
            case 2:
                System.out.print("Book id: ");
                var bookIndex = _scanner.nextInt();
                System.out.print("Reader id: ");
                var readerIndex = _scanner.nextInt();
                ReserveBook(bookIndex, readerIndex);
                break;
            case 0:
        }
    }

    private void PrintReservationMenu(int rentId) {
        PrintReservation(rentId);
        System.out.println("" +
                "[0] Back");

        switch (_scanner.nextInt()) {
            case 0:
                ShowReservations();
        }
    }

    public void PrintReservation(int rentId) {
        var reservation = _reservationController.Get(rentId);
        System.out.println("[1] Id: " + reservation.getId());
        System.out.println("[2] StartDate: " + reservation.getStartDate());
        System.out.println("[3] EndDate: " + reservation.getEndDate());
        for(var reader : _readerController.GetAll()){
            if(reader.getReservations() != null && reader.getReservations().contains(rentId)){
                reader.Print();
                return;
            }
        }
    }
}
