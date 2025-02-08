package entity;

import entity.enums.Role;

import java.util.List;

public class User {
    private String id;
    private Role role=Role.USER;
    private String name;
    private String surname;
    private String email;
    private Integer countBook=0;
    private String password;
    private List<History> histories;
    private List<Borrow> borrowList;
    private Double balance = 100000.0;

    public User() {
    }

    public User(String id, Role role, String name, String surname, String email, String password, List<History> histories, List<Borrow> borrowList, Double balance) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.histories = histories;
        this.borrowList = borrowList;
        this.balance = balance;
    }

    public Integer getCountBook() {
        return countBook;
    }

    public void setCountBook(Integer countBook) {
        this.countBook = countBook;
    }

    public String getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", histories=" + histories +
                ", borrowList=" + borrowList +
                ", balance=" + balance +
                '}';
    }
}
