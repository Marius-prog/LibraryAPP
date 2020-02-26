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

    private void saveBooks() {
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
}
