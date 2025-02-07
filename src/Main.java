public class Main {
    public static void main(String[] args) {
        try {
            AuthService.service();
            Thread.sleep(5000);
            System.out.println("The program is closed..🚫");
        } catch (Exception e) {}

    }
}