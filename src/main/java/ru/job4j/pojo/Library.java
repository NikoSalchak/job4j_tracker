package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Herbert Schildt java-2019", 1882);
        Book secondBook = new Book("Nineteen eighty four", 328);
        Book thirdBook = new Book("Syerra Headfirst", 708);
        Book fourthBook = new Book("Clean code", 464);
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;
        for (Book lib : books) {
            System.out.println(lib.getNameOfBook() + " - " + lib.getPageCount());
        }
        System.out.println("Swap cells 0 and 3");
        Book temp = books[0];
        books[0] = fourthBook;
        books[3] = temp;
        for (Book lib : books) {
            System.out.println(lib.getNameOfBook() + " - " + lib.getPageCount());
        }
        System.out.println("Show only Clean code book");
        for (Book lib : books) {
            if ("Clean code".equals(lib.getNameOfBook())) {
                System.out.println(lib.getNameOfBook() + " - " + lib.getPageCount());
            }
        }
    }
}
