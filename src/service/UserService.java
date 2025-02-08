package service;

import static db.DataSource.*;

public class UserService {
    public static void service(){
        while (true) {
            System.out.println("==================================");
            System.out.print("""
                    User Menu👇
                    0.Return to Main Menu
                    1.Show sections
                    2.Show section
                    3.Borrow
                    4.Return Book
                    2.Current Borrowed Books
                    6.History
                    """);
            System.out.println("==================================");
            System.out.print("Select Comanda: ");
            switch (intScanner.nextInt()) {
                case 0 -> {System.out.println("Goodbye👋👋👋\nYou have returned to the Main menu↪️↪️↪️");return;}
                case 1 -> {showSections();}
                case 2 -> {showSection();}
                case 3 -> {borrow();}
                case 4 -> {returnBook();}
                case 5 -> {currentBorrowedBooks();}
                case 6 -> {history();}
                default -> {System.out.println("No such action");}
            }
        }
    }

    private static void history() {
    }

    private static void currentBorrowedBooks() {

    }

    private static void returnBook() {

    }

    private static void borrow() {

    }

    private static void showSection() {
    }

    private static void showSections() {
        System.out.println("**********************************");
        System.out.println("         ⬇️Sections⬇️");
        System.out.println("**********************************");
    }
}
