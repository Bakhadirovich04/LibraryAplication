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

    static {
        users.add(new User(UUID.randomUUID().toString(), Role.ADMIN, "admin", "admin", "admin", "admin", new ArrayList<History>(), new ArrayList<Borrow>(), 50000.0));
        users.add(new User(UUID.randomUUID().toString(), Role.USER, "a", "a", "a", "a", new ArrayList<History>(), new ArrayList<Borrow>(), 250000.0));
        users.add(new User(UUID.randomUUID().toString(), Role.USER, "b", "b", "b", "b", new ArrayList<History>(), new ArrayList<Borrow>(), 150000.0));
    }
    static {
        sections.add(new Section(UUID.randomUUID().toString(),"Harry",new ArrayList<Book>(),SectionState.ENABLED));
        sections.add(new Section(UUID.randomUUID().toString(),"Potter",new ArrayList<Book>(),SectionState.ENABLED));
    }
}
