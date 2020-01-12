package Services;

import Controllers.*;
import Models.Book;

import java.util.HashSet;
import java.util.Scanner;

public class BookService {
    private final BookController _bookController;
    private final RentController _rentController;
    private final ReservationController _reservationController;
    private final ReservationService _reservationService;
    private final RentService _rentService;
    private final Scanner _scanner;


    public BookService(RentController rentController,
                       ReservationController reservationController,
                       BookController bookController,
                       ReservationService reservationService,
                       RentService rentService,
                       Scanner scanner) {
        _bookController = bookController;
        _reservationController = reservationController;
        _reservationService = reservationService;
        _rentService = rentService;
        _rentController = rentController;
        _scanner = scanner;
    }

    public void ShowBooks() {
        var books = _bookController.GetAll();
        System.out.println("Id   |          Title          |         Author          | Release date | IsReserved | IsRented "); // 4 25 25 12 10
        for (var book : books) {
            var output = String.format("%-4.4s | %-23.23s | %-23.23s | %-12.12s | %-10.10s | %-7.7s", book.getId(), book.getTitle(), book.getAuthor(), book.getRelease(), book.getReservation() != null, book.getRent() != -1);
            System.out.println(output);
        }

        RentReservationMenu();
    }

    private void RentReservationMenu() {
        System.out.println("" +
                "[1] Show book \n" +
                "[2] Add book\n" +
                "[3] Remove book\n" +
                "[4] Edit book\n" +
                "[0] Back");
        int index;
        Book book;
        switch (_scanner.nextInt()) {
            case 1:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                book = _bookController.Get(index);
                PrintBookMenu(book);
                break;
            case 2:
                AddBook();
                break;
            case 3:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                _bookController.Delete(index);
                ShowBooks();
                break;
            case 4:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                EditBook(index);
                break;
            case 0:
        }
    }

    private void EditBook(int index) {
        var book = _bookController.Get(index);
        PrintBook(book);
        System.out.println("[0] Finish editing");
        boolean editing = true;
        while (editing) {
            _scanner.nextLine();
            var menu = _scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("You cannot change Id");
                    break;
                case 2:
                    System.out.print("Title: ");
                    var title = _scanner.nextLine();
                    book.setTitle(title);
                    break;
                case 3:
                    System.out.println("Authors (author separate by newline; end writing with 0): ");
                    String author;
                    var authors = new HashSet<String>();
                    while (!(author = _scanner.nextLine()).equals("0")) {
                        authors.add(author);
                    }

                    book.setAuthor(authors);
                    break;
                case 4:
                    System.out.print("Release date: ");
                    book.setRelease(_scanner.nextLine());
                    break;
                case 0:
                    _bookController.Patch(book);
                    editing = false;
            }
        }
    }

    private void AddBook() {
        System.out.println("Title: ");
        String title = _scanner.nextLine();
        title = _scanner.nextLine();
        System.out.println("Authors (author separate by newline; end writing with 0): ");
        String author;
        var authors = new HashSet<String>();
        while (!(author = _scanner.nextLine()).equals("0")) {
            authors.add(author);
        }

        System.out.println("Release date: ");
        var date = _scanner.nextLine();
        var counted = _bookController.GetAll().size();
        var book = new Book(counted, authors, date, title);
        String submit = "";
        do {
            System.out.println("Submit y/n");
            if (submit.equals("n")) {
                System.out.println("Naaaaaathing added");
                ShowBooks();
            }
        }
        while (!(submit = _scanner.next()).equals("y"));

        System.out.println("Success = " + _bookController.Post(book));
        ShowBooks();
    }

    private void PrintBookMenu(Book book) {
        PrintBook(book);
        System.out.println("" +
                (book.isRented() ? "[1] Reserve book\n" : "[1] Rent book\n") +
                "[0] Back");

        switch (_scanner.nextInt()) {
            case 1:
                System.out.print("Reader id: ");
                var reader = _scanner.nextInt();
                var success = book.isRented() ? _reservationService.ReserveBook(book.getId(), reader) : _rentService.RentBook(book.getId(), reader);
                System.out.println("Success: " + success);
                break;
            case 0:
                ShowBooks();
        }
    }

    private void PrintBook(Book book) {
        System.out.println("[1] Id: " + book.getId());
        System.out.println("[2] Title: " + book.getTitle());
        System.out.println("[3] Authors: " + book.getAuthor());
        System.out.println("[4] Release date: " + book.getRelease());

        if(book.getReservation() != null) {
            System.out.println("Reservations:");
            for (var i : book.getReservation()) {
                var reservation = _reservationController.Get(i);
                reservation.Print();
                System.out.println();
            }
        }

        if (book.getRent() != -1) {
            System.out.println("Rent:");
            _rentService.PrintRentLine(_rentController.Get(book.getRent()));
        }
    }
}

