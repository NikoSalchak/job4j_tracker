package ru.job4j.pojo;

public class Book {
    private String nameOfBook;
    private int pageCount;

    public Book(String nameOfBook, int pageCount) {
        this.nameOfBook = nameOfBook;
        this.pageCount = pageCount;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
