package db;

import entity.*;
import entity.enums.Role;
import entity.enums.SectionState;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class DataSource {
    public static Scanner strScanner = new Scanner(System.in);
    public static Scanner intScanner = new Scanner(System.in);
    public static ArrayList<User> users = new ArrayList<>();
    public static User currentUser;
    public static User  getCurrentUser(){return currentUser;};
    public static void  setCurrentUser(User user){currentUser=user;};
    public static ArrayList<Section> sections = new ArrayList<>();
    public static Section currentSection;
    public static Book currentBook;

    static {
        users.add(new User(UUID.randomUUID().toString(), Role.ADMIN, "admin", "admin", "admin", "admin", new ArrayList<History>(), new ArrayList<Borrow>(), 50000.0));
        users.add(new User(UUID.randomUUID().toString(), Role.USER, "a", "a", "a", "a", new ArrayList<History>(), new ArrayList<Borrow>(), 250000.0));
        users.add(new User(UUID.randomUUID().toString(), Role.USER, "b", "b", "b", "b", new ArrayList<History>(), new ArrayList<Borrow>(), 150000.0));
    }
    static {
        ArrayList<Book> bookss1 = new ArrayList<>();
        Section harry = new Section(UUID.randomUUID().toString(), "Harry",bookss1, SectionState.ENABLED);
        Book book1 = new Book("Sariq devni minib","Hudoyberdi To'xtaboyev",harry,10);
        Book book2 = new Book("O'tgan kunlar","Abdulla qodiriy",harry,5);
        bookss1.add(book1);
        bookss1.add(book2);
        ArrayList<Book> bookss2 = new ArrayList<>();
        Section potter = new Section(UUID.randomUUID().toString(), "Potter", bookss2, SectionState.ENABLED);
        Book book3 = new Book("Farhod va Shirin","Alisher Navoiy",potter,10);
        Book book4 = new Book("Oq Kema","Chingiz Aytmatov",potter,5);
        bookss2.add(book3);
        bookss2.add(book4);
        sections.add(harry);
        sections.add(potter);
    }
}
