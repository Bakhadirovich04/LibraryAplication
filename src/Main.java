import db.DataSource;
import service.AuthService;

public class Main {
    public static void main(String[] args) {
        boolean test=true;
        while (test) {
           DataSource.refresh();
            try {
                AuthService.service();
                Thread.sleep(5000);
                System.out.println("The program is closed..🚫");
                test=false;
            } catch (Exception e) {
            }
        }
    }
}