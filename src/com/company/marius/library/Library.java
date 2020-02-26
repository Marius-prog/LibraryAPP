package com.company.marius.library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private String usersFileName = "users.ser";
    private String booksFileName = "books.ser";


    public Library() {

    }

    public void printAllUsers() {

    }

    public void printAllBooks() {

    }

    public int checkIfUserExistsAndReturnIdx(int id) {
        return 0;
    }

    public void deleteUser(int idx) {

    }

    public void addUser(User user) {
        users.add(user);
        this.saveUsers();
    }

    private void saveUsers() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(usersFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(users);
            fos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        books.add(book);
        this.saveBooks();
    }

    void saveBooks() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(booksFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(books);
            fos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int checkIfBookExistsAndReturnIdx(int id) {
        Book book;
        for (int i = 0; i < books.size() ; i++) {
            book = books.get(i);
            if(book.getId() == id)
                return i;
        }
        return -1;
    }

    public void deleteBook(int idx) {
        books.remove(idx);
        this.saveBooks();
    }

    public Book getBookById(int id) {
        Book bookUnderInvestigation = null;
        for (int i = 0; i < books.size() ; i++) {
            bookUnderInvestigation = books.get(i);
            if(bookUnderInvestigation.getId() == id)
                return bookUnderInvestigation;
        }
        return bookUnderInvestigation;
    }

    public List<Book> searchBookByAuthor(String authorName) {
        List<Book> booksForAuthor = new ArrayList<>();
        for (Book book: books)
            if(book.getAuthor().contains(authorName))
                booksForAuthor.add(book);
        return booksForAuthor;
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> booksWithTitle = new ArrayList<>();
        for (Book book: books)
            if(book.getTitle().contains(title))
                booksWithTitle.add(book);
        return booksWithTitle;
    }

    public List<Book> getAllBooksForUser(String userName) {
        List<Book> booksBorrowedByUser = new ArrayList<>();
        for (Book book: books)
            if(book.getNameOfOccupyingReader().equals(userName))
                booksBorrowedByUser.add(book);
        return booksBorrowedByUser;
    }
}
