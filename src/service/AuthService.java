package service;

import entity.User;
import entity.enums.Role;

import java.util.ArrayList;
import java.util.UUID;

import static db.DataSource.*;

public class AuthService {
    public static void service() {
        while (true) {
            System.out.println("==================================");
            System.out.print("""
                    Main Menu👇
                    0.End the program
                    1.Sign Up
                    2.Sign In
                    """);
            System.out.println("==================================");
            System.out.print("Select Comanda: ");
            switch (intScanner.nextInt()) {
                case 0 -> {
                    System.out.println("Goodbye👋👋👋");
                    return;
                }
                case 1 -> {
                    signUp();
                }
                case 2 -> {
                    signIn();
                }
                default -> {
                    System.out.println("No such action");
                }
            }
        }
    }
    private static void signUp() {
        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        System.out.println("**********************************");
        System.out.println("SignUp process✔️.......");
        System.out.println("**********************************");
        User user=new User();
        System.out.print("Enter name: ");
        String name =strScanner.nextLine();
        System.out.print("Enter surname: ");
        String surname =strScanner.nextLine();
        System.out.print("Enter email : ");
        String email=strScanner.nextLine();
        if(!checkEmail(email)){
            System.out.print("Enter password: ");
            user.setPassword(strScanner.nextLine());
            user.setId(UUID.randomUUID().toString());
            user.setName(name);
            user.setSurname(surname);
            user.setBorrowList(new ArrayList<>());
            user.setHistories(new ArrayList<>());
            users.add(user);
            System.out.println("User registered successfully...✔️");

        }
        else{
            System.out.println("This email is busy");
        }
    }

    private static void signIn() {
        System.out.println("⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️");
        System.out.println("**********************************");
        System.out.println("SignIn process✔️.......");
        System.out.println("**********************************");
        System.out.print("Enter email: ");
        String email=strScanner.nextLine();
        System.out.print("Enter Password: ");
        String pass=strScanner.nextLine();
        boolean chekLogin=true;
        for (User user : users) {
            if(user.getEmail().equals(email)&&user.getPassword().equals(pass)){
                setCurrentUser(user);
                 chekLogin=false;
                          break;
            }
        }
        if(chekLogin){
            System.out.println("There is no such password or login");
        }
        else if(getCurrentUser().getRole().equals(Role.USER)){
            UserService.service();
        }
        else if(getCurrentUser().getRole().equals(Role.ADMIN)){
            AdminService.service();
        }
    }

    private static boolean checkEmail(String a) {
        for (User user : users) {
            if(user.getEmail().equals(a)){
                return true;
            }
        }
        return false;
    }


}
