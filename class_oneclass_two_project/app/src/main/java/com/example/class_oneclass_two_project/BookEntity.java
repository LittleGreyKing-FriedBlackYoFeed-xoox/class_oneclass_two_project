package com.example.class_oneclass_two_project;

public class BookEntity {
    private int id;
    private String book_name;
    private String press;
    private double price;
    private int pages;
    private String writer;

    public BookEntity(int id, String book_name, String press, double price, int pages, String writer) {
        this.id = id;
        this.book_name = book_name;
        this.press = press;
        this.price = price;
        this.pages = pages;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", press='" + press + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", writer='" + writer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
