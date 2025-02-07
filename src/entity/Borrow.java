package entity;

import entity.enums.BorrowState;

import java.time.LocalDateTime;

public class Borrow {
    private String id;
    private User user;
    private Book book;
    private BorrowState borrowState;
    private LocalDateTime borrowedTime;
    private LocalDateTime returnTime;

    public Borrow() {
    }

    public Borrow(String id, User user, Book book, BorrowState borrowState, LocalDateTime borrowedTime, LocalDateTime returnTime) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.borrowState = borrowState;
        this.borrowedTime = borrowedTime;
        this.returnTime = returnTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
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

    public BorrowState getBorrowState() {
        return borrowState;
    }

    public void setBorrowState(BorrowState borrowState) {
        this.borrowState = borrowState;
    }

    public LocalDateTime getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(LocalDateTime borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", book=" + book +
                ", borrowState=" + borrowState +
                ", borrowedTime=" + borrowedTime +
                ", returnTime=" + returnTime +
                '}';
    }
}
