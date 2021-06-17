package com.th1024.bean;

/**
 * @author TuHong
 * @create 2021-04-22 21:50
 */
public class Book {

    private Integer id;
    private String bookName;
    private String author;
    private Double price;
    private Integer stock;
    private Integer sales;
    private Address address;

    public Book() {
    }

    public Book(Integer id, String bookName, String author, Double price, Integer stock, Integer sales, Address address) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                ", address=" + address +
                '}';
    }
}
