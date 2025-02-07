package entity;

import java.time.LocalDateTime;

public class History {
    private String id;
    private User user;
    private Book book;
    private LocalDateTime borrowedDate;
    private LocalDateTime returnDate;

    public History() {
    }

    public History(String id, User user, Book book, LocalDateTime borrowedDate, LocalDateTime returnDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }


    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "History{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", book=" + book +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
