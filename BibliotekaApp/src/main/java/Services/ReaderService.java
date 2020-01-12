package Services;

import Controllers.ReaderController;
import Controllers.RentController;
import Controllers.ReservationController;
import Models.Reader;

import java.util.HashSet;
import java.util.Scanner;

public class ReaderService {
    private final ReaderController _readerController;
    private final RentController _rentController;
    private final ReservationController _reservationController;
    private final Scanner _scanner;

    public ReaderService(ReaderController readerController,
                         ReservationController reservationController,
                         RentController rentController,
                         Scanner scanner) {
        _readerController = readerController;
        _reservationController = reservationController;
        _rentController = rentController;
        _scanner = scanner;
    }

    public void ShowReaders() {
        var readers = _readerController.GetAll();
        System.out.println("Id   |    Name    |    Surname    |    Email   |   Address   | Rents | Reservations"); // 4 10 13 10 11 5
        for(var reader : readers) {
            var output = String.format("%-4.4s | %-10.10s | %-13.13s | %-10.10s | %-11.11s | %-5.5s | %-12.12s", reader.getId(), reader.getName(), reader.getSurname(), reader.getEmail(), reader.getAddress(), reader.getRents() != null ? reader.getRents().size() : 0, reader.getReservations() != null ? reader.getReservations().size() : 0);
            System.out.println(output);
        }

        ReaderMenu();
    }

    private void ReaderMenu() {
        System.out.println("" +
                "[1] Show reader \n" +
                "[2] Add reader\n" +
                "[3] Remove reader\n" +
                "[4] Edit reader\n" +
                "[0] Back");
        int index;
        switch(_scanner.nextInt()){
            case 1:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                PrintReaderMenu(index);
                break;
            case 2:
                AddReader();
                break;
            case 3:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                _readerController.Delete(index);
                break;
            case 4:
                System.out.print("Index: ");
                index = _scanner.nextInt();
                EditReader(index);
                break;
            case 0:
        }
    }

    private void PrintReaderMenu(int readerId) {
        PrintReader(readerId);
        System.out.println("" +
                "[0] Back");

        switch (_scanner.nextInt()) {
            case 0:
                ShowReaders();
        }
    }

    private void EditReader(int index) {
        PrintReader(index);
        var reader = _readerController.Get(index);
        System.out.println("[0] Finish editing");
        boolean editing = true;
        while(editing){
            switch (_scanner.nextInt()){
                case 1:
                    System.out.println("You cannot change Id");
                    break;
                case 2:
                    System.out.print("Name: ");
                    var name = _scanner.nextLine();
                    reader.setName(name);
                    break;
                case 3:
                    System.out.print("Surname: ");
                    var surname = _scanner.nextLine();
                    reader.setSurname(surname);
                    break;
                case 4:
                    System.out.print("Email: ");
                    var email = _scanner.nextLine();
                    reader.setEmail(email);
                    break;
                case 0:
                    _readerController.Patch(reader);
                    editing = false;
            }
        }
    }

    private void AddReader() {
        System.out.print("Name: ");
        String name = _scanner.nextLine();
        name = _scanner.nextLine();
        System.out.print("Surname: ");
        String surname = _scanner.nextLine();
        System.out.print("Email: ");
        String email = _scanner.nextLine();
        System.out.print("Address: ");
        String address = _scanner.nextLine();

        var counted = _readerController.GetAll().size();
        var reader = new Reader(counted, name , surname, email, address, new HashSet<Integer>(), new HashSet<Integer>());
        String submit = "";
        do {
            System.out.println("Submit y/n");
            if(submit.equals("n")) {
                System.out.println("Naaaaaathing added");
                ShowReaders();
            }
        }
        while(!(submit = _scanner.next()).equals("y"));

        System.out.println("Success = " + _readerController.Post(reader));
        ShowReaders();
    }

    public void PrintReader(int readerId) {
        var reader = _readerController.Get(readerId);
        System.out.println("[1] Id: " + reader.getId());
        System.out.println("[2] Name: " + reader.getName());
        System.out.println("[3] Surname: " + reader.getSurname());
        System.out.println("[4] Email: " + reader.getEmail());
        System.out.println("[5] Address:" + reader.getAddress());
        if(reader.getRents() != null) {
            System.out.println("Rents:");
            for (var i : reader.getRents()) {
                var rent = _rentController.Get(i);
                rent.Print();
            }
        }

        if(reader.getReservations() != null) {
            System.out.println("Reservations:");
            for (var i : reader.getReservations()) {
                var reservation = _reservationController.Get(readerId);
                reservation.Print();
            }
        }
    }
}
