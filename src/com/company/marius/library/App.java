package com.company.marius.library;

import java.util.InputMismatchException;
import java.util.List;
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
                    + "\t- 2: books menu\n"
                    + "\t- q: to quit the program");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("q"));
        if (choice.equals("1")) librarianUsersMenu(sc);
        else if (choice.equals("2")) librariansBooksMenu(sc);
        else System.out.println("bye bye!");
        System.exit(0);
    }

    private static void librarianUsersMenu(Scanner sc) {
        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: add user\n"
                    + "\t- 2: list all users\n"
                    + "\t- 3: remove user\n"
                    + "\t- q: to quit the program");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("q"));

        if (choice.equals("1"))
            addUser(sc);
        else if (choice.equals("2"))
            library.printAllUsers();
        else if (choice.equals("3"))
            deleteUser(sc);
        else System.out.println("bye bye!");
        //System.exit(0);

    }

    private static void librariansBooksMenu(Scanner sc) {

        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 1: add book\n"
                    + "\t- 2: list all books\n"
                    + "\t- 3: remove book\n"
                    + "\t- q: to quit the program");
            choice = sc.nextLine();
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("q"));

        if (choice.equals("1"))
            addBook(sc);
        else if (choice.equals("2"))
            library.printAllBooks();
        else if (choice.equals("3"))
            deleteBook(sc);
        else System.out.println("bye bye!");
        System.exit(0);
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

    private static void deleteBook(Scanner sc) {

        int id = handleNumericInput(sc, "\nEnter ID: ");
        int idx = library.checkIfBookExistsAndReturnIdx(id);
        if (idx != -1) {
            library.deleteBook(idx);
            System.out.println("Book deleted!");
        } else {
            System.out.println("Book does not exist with this id!");
        }
    }

    ////////////////// USERS METHODS ///////////////////////////

    private static void handleUser(Scanner sc) {

        String choice;
        do {
            System.out.println("\nPress: \n"
                    + "\t- 0: list all books in library\n"
                    + "\t- 1: for more information about a book\n"
                    + "\t- 2: to borrow a book\n"
                    + "\t- 3: search by title or author\n"
                    + "\t- 4: list books you borrowed\n"
                    + "\t- 5: return a book"
            );

            choice = sc.nextLine();
        } while (!choice.equals("0")
                && !choice.equals("1")
                && !choice.equals("2")
                && !choice.equals("3")
                && !choice.equals("4")
                && !choice.equals("5")
        );

        switch (choice) {
            case "0":
                library.printAllBooks();
                break;
            case "1":
                userPrintAllBookInfo(sc);
                break;
            case "2":
                userBorrowsBook(sc);
                break;
            case "3":
                searchBookByTitleOrAuthor(sc);
                break;
            case "4":
                userChecksTheBooksHeBorrowed(sc);
                break;
            case "5":
                userReturnsBook(sc);
                break;
        }
    }

    private static void userReturnsBook(Scanner sc) {
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        System.out.print("Please enter the book id you want to return: ");
        int id = handleNumericInput(sc, "\nEnter ID: ");
        handleBookReturn(name, id);
    }

    private static void handleBookReturn(String name, int id) {
        Book book = library.getBookById(id);
        if (book != null)
            if (!book.getNameOfOccupyingReader().equals(name))
                System.out.println("This book was not borrowed by you!");
            else if (book.getNameOfOccupyingReader().equals(""))
                System.out.println("Please provide a valid name!");
            else {
                book.setNameOfOccupyingReader("");
                library.saveBooks();  //!!!!!!!!!!!!!!!!!!!
                System.out.println("Book was returned successfully!");
            }
        else System.out.println("Could not find book with id: " + id);
    }

    private static void userChecksTheBooksHeBorrowed(Scanner sc) {
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        List<Book> booksForUser = library.getAllBooksForUser(name);
        if (booksForUser.size() == 0)
            System.out.println("No books for this user were found!");
        else
            booksForUser.forEach(System.out::println);
    }

    private static void searchBookByTitleOrAuthor(Scanner sc) {
        System.out.println("\nPress: \n"
                + "\t- 0: to search by author\n"
                + "\t- 1: to search by title");
        String choice = sc.nextLine();
        if (choice.equals("0")) {
            System.out.println("Please enter an author to search by: ");
            String author = sc.nextLine();
            if (author.equals("")) System.out.println("Please provide a valid author!");
            else {
                List<Book> booksForAuthor = library.searchBookByAuthor(author);
                if (booksForAuthor.size() == 0)
                    System.out.println("No books by this author!");
                else
                    System.out.println(booksForAuthor);
            }
        } else if (choice.equals("1")) {
            System.out.println("Please enter a title to search by: ");
            String title = sc.nextLine();
            if (title.equals("")) System.out.println("Please provide a valid title!");
            else {
                List<Book> booksWithTitle = library.searchBookByTitle(title);
                if (booksWithTitle.size() == 0)
                    System.out.println("No books with this title!");
                else
                    System.out.println(booksWithTitle);
            }
        } else {
            System.out.println("No such option!");
        }
    }

    private static void userBorrowsBook(Scanner sc) {
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        System.out.print("Please enter the book id you want to borrow: ");
        int id = handleNumericInput(sc, "\nEnter ID: ");
        handleBookBorrowing(name, id);
    }

    private static void handleBookBorrowing(String name, int id) {
        Book book = library.getBookById(id);
        if (book != null)
            if (book.getNameOfOccupyingReader().equals("")) {
                book.setNameOfOccupyingReader(name);
                library.saveBooks();   //!!!!!!!!!!!!!!!!!!
                System.out.println("Book assigned to user: " + book.getNameOfOccupyingReader());
            } else if (book.getNameOfOccupyingReader().equals(name))
                System.out.println("You already have this book!");
            else
                System.out.println("The book is taken by: " + book.getNameOfOccupyingReader());
        else System.out.println("Could not find book with id: " + id);
    }

    private static void userPrintAllBookInfo(Scanner sc) {

        int id = handleNumericInput(sc, "\nEnter ID: ");

            Book book = library.getBookById(id);
            if (book == null) System.out.println("No such book is in library !");
            System.out.println(book.bookExtendedInfo());

            System.out.println("---------------------------------");
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


}
