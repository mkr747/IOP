import Controllers.ReaderController;
import Models.Book;
import Models.Reader;
import Services.BookService;
import Services.ReaderService;
import Services.RentService;
import Services.ReservationService;

import java.util.Scanner;

public class Menu {
    private final RentService _rentService;
    private final BookService _bookService;
    private final ReaderService _readerService;
    private final ReservationService _reservationService;
    private final Scanner _scanner;

    public Menu(RentService rentService,
                ReaderService readerService,
                BookService bookService,
                ReservationService reservationService,
                Scanner scanner){
        _rentService = rentService;
        _bookService = bookService;
        _readerService = readerService;
        _reservationService = reservationService;
        _scanner = scanner;
    }

    public void ShowMainMenu() {
        int bookIndex, readerIndex;

        while(true) {
            System.out.println("" +
                    "[1] Show books \n" +
                    "[2] Show readers \n" +
                    "[3] Show rented books \n" +
                    "[4] Show reserved books\n" +
                    "[5] Reserve book\n" +
                    "[6] Rent book\n" +
                    "[7] Return book\n" +
                    "[0] Exit");

            switch (_scanner.nextInt()) {
                case 1:
                    _bookService.ShowBooks();
                    break;
                case 2:
                    _readerService.ShowReaders();
                    break;
                case 3:
                    _rentService.ShowRents();
                    break;
                case 4:
                    _reservationService.ShowReservations();
                    break;
                case 5:
                    System.out.print("Book id: ");
                    bookIndex = _scanner.nextInt();
                    System.out.print("Reader id: ");
                    readerIndex = _scanner.nextInt();
                    _reservationService.ReserveBook(bookIndex, readerIndex);
                    break;
                case 6:
                    System.out.print("Book id: ");
                    bookIndex = _scanner.nextInt();
                    System.out.print("Reader id: ");
                    readerIndex = _scanner.nextInt();
                    _rentService.RentBook(bookIndex, readerIndex);
                    break;
                case 7:
                    System.out.print("Rent index: ");
                    var rentIndex = _scanner.nextInt();
                    _rentService.ReturnBook(rentIndex);
                case 0:
                default:
                    System.exit(1);
            }
        }
    }
}
