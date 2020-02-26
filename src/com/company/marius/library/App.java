package com.company.marius.library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Library library = new Library();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            String initialMenuOptions = "Press: \n"
                    + "\t- 1: librarian menu\n"
                    + "\t- 2: user menu\n"
                    + "\t- q: quit the program\n";
            System.out.println(initialMenuOptions);
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    handleLibrarian(sc);
                    break;
                case "2":
                    handleUser(sc);
                    break;
                case "q":
                    System.out.println("bye bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("incorrect value entered !!");
                    System.out.println("repeat pleace !!");
            }
        } while (true);
    }
//////////////////////////// LIBRARIAN METHODS /////////////////
    private static void handleLibrarian(Scanner sc) {
        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: users menu\n"
                    + "\t- 2: books menu");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2"));
        if (choice.equals("1")) librarianUsersMenu(sc);
        else librariansBooksMenu(sc);
    }

    private static void librarianUsersMenu(Scanner sc) {
        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: add user\n"
                    + "\t- 2: list all users\n"
                    + "\t- 3: remove user");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));

        if (choice.equals("1"))
            addUser(sc);
        else if (choice.equals("2"))
            library.printAllUsers();
        else
            deleteUser(sc);
    }

    private static void librariansBooksMenu(Scanner sc) {

        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: add book\n"
                    + "\t- 2: list all books\n"
                    + "\t- 3: remove book");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));

        if (choice.equals("1"))
            addBook(sc);
        else if (choice.equals("2"))
            library.printAllBooks();
        else
            deleteBook(sc);
    }

    private static void addUser(Scanner sc) {
        int id = handleNumericInput(sc, "\nEnter ID: ");

        System.out.println("\nEnter User's name: ");
        String name = sc.nextLine();

        String msg = "\nEnter User's mobile number: ";
        int mobileNumber = handleNumericInput(sc, msg);

        User user = new User(name, id, mobileNumber);
        library.addUser(user);
    }

    private static void deleteUser(Scanner sc) {

        int id = handleNumericInput(sc, "\nEnter ID: ");
        int idx = library.checkIfUserExistsAndReturnIdx(id);
        if (idx != -1) {
            library.deleteUser(idx);
            System.out.println("User deleted!");
        } else {
            System.out.println("User does not exist with this id!");
        }
    }

    private static int handleNumericInput(Scanner sc, String message) {
        int id = 0;
        boolean intputInvalid = true;
        while (intputInvalid) {
            System.out.println(message);
            try {
                id = sc.nextInt();
                sc.nextLine();
                intputInvalid = false;
            } catch (InputMismatchException ignored) {
                System.out.println("Incorrect value, please retry!");
                sc.nextLine();
            }
        }
        return id;
    }





    private static void deleteBook(Scanner sc) {

    }

    private static void addBook(Scanner sc) {
        int id = handleNumericInput(sc, "\nEnter ID: ");

        System.out.println("\nEnter title: ");
        String title = sc.nextLine();

        System.out.println("\nEnter author: ");
        String author = sc.nextLine();

        System.out.println("\nEnter isbn: ");
        String isbn = sc.nextLine();

        System.out.println("\nEnter description: ");
        String description = sc.nextLine();

        Book book = new Book(title, id, author, isbn, description);
        library.addBook(book);

    }


    private static void handleUser(Scanner sc) {

    }
}
