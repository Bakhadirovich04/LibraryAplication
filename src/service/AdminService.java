package service;
import entity.*;
import entity.enums.BorrowState;
import entity.enums.SectionState;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static db.DataSource.*;
public class AdminService {

    public static void service(){
        String menu  = """
                   ADMIN MENU: 
              0.Back🔙
              1.Add section
              2.Show sections
              3.Show section
              4.Section state
              5.Add book
              6.Remove book
              7.Book state
              8.Show users
              9.Show user""";
        while (true){
            System.out.println(menu);
            System.out.println("Choose: ");
            switch (intScanner.nextInt()){
                case 0->{
                     return;
                }
                case 1->{
                  addSection();
                }
                case 2->{
                  showSections();
                }
                case 3->{
                   showSection();

                }
                case 4->{
                    sectionState();
                }
                case 5->{
                   addBook();
                }
                case 6->{
                  removeBook();
                 }
                case 7->{
                 bookState();
                }
                case 8->{
                   showUsers();
                }
                case 9->{
                      showUser();
                }
                default -> {

                }

            }

        }
    }

    private static void showUser() {
    }

    private static void bookState() {
        System.out.println("Enter book Id: ");
        String id = strScanner.nextLine();
        System.out.println("Enter book selection name: ");
        String selName = strScanner.nextLine();
        if (testBook(id)&& testSection(selName)) {
            String choose = """
                         Choose book state:
                     0.Back🔙
                     1.Borrowed
                     2.Returned,
                     3.Time over
                          """;
            System.out.println(choose);
            switch (intScanner.nextInt()){
                case 0->{
                       return;
                }
                case 1->{
                    borrowBook(selName,id);
                    //   currentBook.setBookState();
                }
                case 2->{
                    returnedBook(selName,id);

                }
                default -> {

                }
            }

        }else{
            System.out.println("You do not have such a book😊");
        }
    }

    private static void returnedBook(String selName,String id) {

        System.out.println("Enter User Id: ");
        String idUser = strScanner.nextLine();

        boolean bor = false;
        for (int i = 0; i < users.size() ; i++) {
            if(Objects.equals(idUser,users.get(i).getName()) ){
                User user = users.get(i);
                bor = true;
                List<Borrow> borrowList = user.getBorrowList();
                for (int j = 0; j < borrowList.size() ; j++) {
                    if(Objects.equals(currentBook.getId(),borrowList.get(i).getBook().getId())){
                        Borrow borrow = borrowList.get(i);
                       if(Objects.equals(borrow.getBorrowState(),BorrowState.BORROWED)){
                           borrow.getBook().setAvailableBook(borrow.getBook().getAvailableBook()+1);
                           LocalDateTime now = LocalDateTime.now();
                           borrow.setReturnTime(now);

                           //////////////////////////////////////////////////////
                           borrowList.remove(borrow);

                       }

                    }
                }

            }

        }
    }

    private static void borrowBook(String name,String Id) {
        System.out.println("Enter User Id: ");
         String IdUser = strScanner.nextLine();
              boolean bor = false;
           if (testSection(name) && testBook(Id)) {
            for (int i = 0; i < users.size() ; i++) {
                if(Objects.equals(IdUser,users.get(i).getId())){
                    if(currentBook.getAvailableBook()>0){
                        bor =  true;
                        User user =users.get(i);
                        // Brow qilish
                        Borrow borrow = new Borrow();
                        borrow.setId(UUID.randomUUID().toString());
                        borrow.setUser(users.get(i));
                        borrow.setBook(currentBook);
                        borrow.setBorrowState(BorrowState.BORROWED);
                        borrow.setBorrowedTime(LocalDateTime.now());
                        currentBook.setAvailableBook(currentBook.getAvailableBook()-1);
                        List<Borrow> borrowList = user.getBorrowList();
                        if(borrowList.size()<5){
                            borrowList.add(borrow);

                            //Historyga qo'shish
                            History history = new History();
                            history.setId(UUID.randomUUID().toString());
                            history.setBorrowedDate(LocalDateTime.now());
                            history.setUser(user);
                            history.setBook(currentBook);
                            List<History> histories = user.getHistories();
                            histories.add(history);

                        }else{
                            System.out.println("You are out of your limit😔");
                        }
                    }else{
                        System.out.println(" Sorry Now all these books are busy😔");
                    }
                }
            }
            if(!bor){
                System.out.println("This user does not exist on the network😊");
            }
        }else{
               System.out.println("You do not have such a book😊");
           }

    }



    private static void showUsers() {

    }

    private static void removeBook() {
        System.out.println("Enter book Id: ");
        String Id = strScanner.nextLine();
        System.out.println("Enter book selection name: ");
        String selName = strScanner.nextLine();
        if (testSection(selName) && testBook(Id)){
            List<Book> books = currentSection.getBooks();
            books.remove(currentBook);
            System.out.println("The book has been deleted🫡");

        }else{
            System.out.println("You do not have such a book😊");
        }


    }

    private static boolean testBook(String Id) {
        List<Book> books = currentSection.getBooks();
        for (int i = 0;i< books.size();i++){
            if (Objects.equals(Id,books.get(i).getId())){
                currentBook = books.get(i);
                return true;
            }
        }
        return false;
    }

    private static void addBook() {
        Book book  = new Book();
        System.out.println("Enter book name: ");
        book.setTitle(strScanner.nextLine());
        System.out.println("Enter book author: ");
        book.setAuthor(strScanner.nextLine());
        System.out.println("Enter book total Book: ");
        book.setTotalBook(intScanner.nextInt());
        System.out.println("=======================================================");
        System.out.println(  "   Choose book section:  ");
        for (int i = 0; i < sections.size(); i++) {
            System.out.println(i+1+". "+sections.get(i).getName());
        }
        System.out.println("=======================================================");

        int n = intScanner.nextInt();
        if(n>0 && n<= sections.size()){
            book.setSection(sections.get(n-1));
            sections.get(n-1).getBooks().add(book);
            System.out.println("The book has been successfully added to the library🫡");
        }else{
            System.out.println("Section input error😡");
        }
    }

    private static void showSection() {

        System.out.println("Enter section name: ");
        String name = strScanner.nextLine();
        if (testSection(name)) {
                ArrayList<Book> books = (ArrayList<Book>) currentSection.getBooks();
                if(books.size()==0){
                    System.out.println("No books have been added to this section yet😔");
                    return;
                }
            System.out.println("=========================================================");
            System.out.println("      Selection "+currentSection.getName()+": ");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(i+1+". "+books.get(i));
            }
            System.out.println("=========================================================");

        }else{
            System.out.println("You do not have such a section😔");
        }
    }

    private static void sectionState() {
        System.out.println("Enter section name: ");
        String  name = strScanner.nextLine();
        if (testSection(name)) {

            String menu = """
                      Section state:
                  0.Back🔙
                  1.Disabled
                  2.Enabled
                  """;
            System.out.println(menu);
            System.out.println("Choose: ");
            switch (intScanner.nextInt()){
                case 0->{
                    return;
                }
                case 1->{
                  currentSection.setStatus(SectionState.DISABLED);

                }
                case 2->{
                    currentSection.setStatus(SectionState.ENABLED);

                }
                default -> {

                }
            }
        }else{
            System.out.println("You do not have such a section😔");
        }

    }

    private static void showSections() {
        System.out.println("===============================================================================");
        System.out.println("                 SECTIONS:");
        for (int i = 0; i < sections.size(); i++) {
            System.out.println(sections.get(i));
        }
        System.out.println("===============================================================================");
    }

    private static void addSection() {
        Section section = new Section();
        System.out.println("Enter section name: ");
        String name = strScanner.nextLine();
        if (!testSection(name)){
            section.setName(name);
            sections.add(section);
        }else{
            System.out.println("You have such a section😊");
        }
    }


    private static boolean testSection(String name) {
        for (int i = 0; i <sections.size() ; i++) {
            if(Objects.equals(name,sections.get(i).getName())){
                currentSection = sections.get(i);
                return true;
            }
        }
        return false;
    }
}
