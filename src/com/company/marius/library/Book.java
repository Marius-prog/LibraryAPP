package com.company.marius.library;

public class Book extends LibraryItem {
    private String title, author, isbn, description, nameOfOccupyingReader;

    public Book(String title, int id, String author, String isbn, String description) {
        super.setId(id);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.nameOfOccupyingReader = "";
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameOfOccupyingReader() {
        return nameOfOccupyingReader;
    }

    public void setNameOfOccupyingReader(String nameOfOccupyingReader) {
        this.nameOfOccupyingReader = nameOfOccupyingReader;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public String bookExtendedInfo(){
        return "Title: " + title
                + " , Author: " + author
                + " , Id: " + super.getId()
                + " , Isbn:" + isbn
                + " , description: " + description;
    }
}
