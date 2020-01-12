import Controllers.*;
import DataAccess.LibraryContext;
import Models.Reader;
import Models.Reservation;
import Services.BookService;
import Services.ReaderService;
import Services.RentService;
import Services.ReservationService;

import java.io.IOException;
import java.util.Scanner;

public class StartUp {

    private Menu _frontEnd;

    public void RegisterResources() throws IOException {
        var libraryContext = new LibraryContext("D:\\Politechnika\\IOP\\BibliotekaJava\\BibliotekaApp\\src\\main\\resources\\database.txt");
        Scanner scanner = new Scanner(System.in);
        BookController bookController = new BookController(libraryContext);
        MagazineController magazineController = new MagazineController(libraryContext);
        LibrarianController librarianController = new LibrarianController(libraryContext);
        RentController rentController = new RentController(libraryContext);
        ReaderController readerController = new ReaderController(libraryContext);
        ReservationController reservationController = new ReservationController(libraryContext);

        ReservationService reservationService = new ReservationService(bookController, reservationController, readerController, scanner);
        RentService rentService = new RentService(bookController, rentController, readerController, scanner);
        BookService bookService = new BookService(rentController, reservationController, bookController, reservationService, rentService, scanner);
        ReaderService readerService = new ReaderService(readerController, reservationController, rentController, scanner);

        _frontEnd = new Menu(rentService, readerService, bookService, reservationService, scanner);
    }

    public void Start() throws IOException {
        _frontEnd.ShowMainMenu();
    }
	
}
