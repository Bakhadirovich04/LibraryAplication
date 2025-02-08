package service;

import entity.Book;
import entity.Borrow;
import entity.History;
import entity.Section;
import entity.enums.BorrowState;
import entity.enums.SectionState;

import java.time.LocalDateTime;
import java.util.UUID;

import static db.DataSource.*;
/*
* Section to string
* book available degan joyi
* add book Admin Service*/
public class UserService {
    public static void service(){
        while (true) {
            System.out.println();
            System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
            System.out.print("""
                    ⬇️User Menu⬇️
                    0.Return to Main Menu
                    1.Show sections
                    2.Show section
                    3.Borrow
                    4.Return Book
                    5.Current Borrowed Books
                    6.History
                    """);
            System.out.println("⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️⬆️");
            System.out.print("Select Comanda: ");
            switch (intScanner.nextInt()) {
                case 0 -> {System.out.println("You have returned to the Main menu↪️↪️↪️");return;}
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
        System.out.println();
        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        System.out.println("**********************************************");
        System.out.println("           History process✔️.......");
        System.out.println("**********************************************");
        System.out.println("______________________________________________");
        System.out.println("           ⬇️️History of borrowed books⬇️");
        System.out.println("===============================================");
        if(getCurrentUser().getHistories().isEmpty()){
            System.out.println("No history of borrowed books..🚫🚫");
            return;
        }
        for (History history : getCurrentUser().getHistories()) {
            System.out.println(history);

        }

        System.out.println("===============================================");
    }

    private static void currentBorrowedBooks() {
        System.out.println();
        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        System.out.println("**********************************************");
        System.out.println("        Current Borrowed Book process✔️.......");
        System.out.println("**********************************************");
        System.out.println("______________________________________________");
        System.out.println("            ⬇️My books List⬇️");
        System.out.println("===============================================");
        boolean checkBorrowed=true;
        for (Borrow borrow : getCurrentUser().getBorrowList()) {
            if (borrow.getBorrowState().equals(BorrowState.BORROWED)) {
                checkBorrowed=false;
                System.out.println(borrow.getBook().toString(getCurrentUser()));
            }
        }
        if(checkBorrowed){
            System.out.println("The list of borrowed books is empty..🚫🚫");
        }
        System.out.println("===============================================");

    }

    private static void returnBook() {
        System.out.println();
        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        System.out.println("**********************************");
        System.out.println("        Return Book process✔️.......");
        System.out.println("**********************************");
        System.out.println("__________________________________");
        System.out.println("       ⬇️My books List⬇️");
        System.out.println("==================================");
        if(getCurrentUser().getBorrowList().isEmpty()){
            System.out.println("The list of borrowed books is empty..🚫🚫");
            return;
        }
        for (Borrow borrow : getCurrentUser().getBorrowList()) {
            if (borrow.getBorrowState().equals(BorrowState.BORROWED)) {
                System.out.println(borrow.getBook().toString(getCurrentUser()));
            }
        }
        System.out.println("==================================");
        System.out.print("Select the title of the book you want to return: ");
        String title = strScanner.nextLine();
        Borrow borrow12=null;
        boolean checkBorrow=true;
        for (Borrow borrow : getCurrentUser().getBorrowList()) {
            if(borrow.getBook().getTitle().equals(title)){
                borrow12=borrow;
                checkBorrow=false;
                break;
            }
        }
        if(checkBorrow){
            System.out.println("There is no such book...❌❌");
        }
        else {
            borrow12.setReturnTime(LocalDateTime.now());
            borrow12.getBook().setAvailableBook(borrow12.getBook().getAvailableBook()+1);
            borrow12.setBorrowState(BorrowState.RETURNED);
            getCurrentUser().setCountBook(getCurrentUser().getCountBook()-1);
        }

    }

    private static void borrow() {
        System.out.println();
        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        System.out.println("**********************************");
        System.out.println("        Borrow process✔️.......");
        System.out.println("**********************************");
        System.out.println("__________________________________");
        System.out.println("      ⬇️Sections List⬇️");
        System.out.println("==================================");
        for (Section section : sections) {
            System.out.println(section.toString(getCurrentUser()));
        }
        System.out.println("==================================");
        System.out.print("Enter the section name: ");
        String name =strScanner.nextLine();
        boolean checkName=true;
        Section  section2=null;
        for (Section section : sections) {
            if(section.getName().equals(name)){
                checkName=false;
                section2=section;
                break;
            }
        }
        if(checkName){
            System.out.println("Section name was entered incorrectly❌❌");
        }
        else{
            System.out.println("=============⬇️"+name+" books⬇️=====================");
            for (Book book : section2.getBooks()) {
                System.out.println(book);
            }
            System.out.println("=====================================================");
            System.out.print("Select book id : ");
            String id=strScanner.nextLine();
            Book book12=null;
            boolean checkBook=true;
            for (Book book : section2.getBooks()) {
                if (book.getId().equals(id)) {
                    book12=book;
                    checkBook=false;
                    break;
                }
            }
            if (checkBook){
                System.out.println("You entered the wrong book id❌❌");
            }
            else{
                if(book12.getAvailableBook()>0) {
                    if (getCurrentUser().getCountBook() < 6) {
                        book12.setAvailableBook(book12.getAvailableBook() - 1);
                        Borrow borrow = new Borrow(UUID.randomUUID().toString(), getCurrentUser(), book12, BorrowState.BORROWED, LocalDateTime.now(), null);
                        getCurrentUser().getBorrowList().add(borrow);
                        getCurrentUser().setCountBook(getCurrentUser().getCountBook()+1);
                        getCurrentUser().getHistories().add(new History(UUID.randomUUID().toString(), getCurrentUser(), book12, borrow.getBorrowedTime(), null));
                        System.out.println("The book was successfully borrowed..✔️");
                    }
                    else{
                        System.out.println("You cannot get more books..❌❌");
                    }
                }
                else{
                    System.out.println("This book is out of stock❌❌");
                }
            }

        }

    }

    private static void showSection() {
        System.out.println();
        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        System.out.println("**********************************");
        System.out.println("        Section process✔️.......");
        System.out.println("**********************************");
        System.out.print(" Enter section name: ");
        Section section1 = null;
        String name=strScanner.nextLine();
        for (Section section : sections) {
            if(section.getName().equals(name)){
                section1=section;
                break;
            }
        }
        if(section1!=null) {
            for (Book book : section1.getBooks()) {
                System.out.println(book);
            }
        }

    }

    private static void showSections() {
        System.out.println();
        System.out.println("**********************************");
        System.out.println("         ⬇️Sections⬇️");
        System.out.println("**********************************");
        for (Section section : sections) {
            if(section.getStatus()== SectionState.ENABLED){
                System.out.println(section.toString(getCurrentUser()));
            }
        }
    }
}
