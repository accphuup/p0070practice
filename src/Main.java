import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        LoginManager manager = new LoginManager();
        Validate validate = new Validate();

        displayMenu();
        // Get language choice: 1 = Vietnamese, 2 = English, 3 = Exit
        int choice = validate.enterUserChoice("Please enter one choice: ");
        if (choice == 3) {
            System.out.println("Exit program...");
            return;
        }

        // Load language bundle for messages in Main
        ResourceBundle bundle;
        if (choice == 1) {
            bundle = ResourceBundle.getBundle("Vi");
        } else {
            bundle = ResourceBundle.getBundle("En");
        }
        // Load language bundle for Validate
        validate.checkLanguage(choice);

        boolean check = true;
        while (check) {
            String accountNumber = validate.checkInputAccountNumber();
            String password = validate.checkInputPassword();
            Account account = new Account(accountNumber, password);

            // 1: account does not exist, 2: wrong password, 3: correct
            int result = manager.checkLogin(account);
            if (result == 3) {
                // Login info is correct: verify captcha
                checkCaptcha(manager, validate, bundle);
                check = false;
            } else {
                // Show the error of this attempt, then ask again
                System.out.println(bundle.getString("login_error" + result));
                System.out.println("-----------------------");
                System.out.println(bundle.getString("login_again"));
            }
        }
    }

    // Show a captcha and ask until the input is correct
    public static void checkCaptcha(LoginManager manager, Validate validate, ResourceBundle bundle) {
        String captcha = manager.generateCaptcha();
        System.out.println(bundle.getString("captcha") + captcha);

        String input = validate.enterCaptcha();
        while (!manager.checkCaptcha(input, captcha)) {
            System.out.println(bundle.getString("captcha_error"));
            input = validate.enterCaptcha();
        }
        System.out.println(bundle.getString("login_status"));
    }

    // Print language menu
    public static void displayMenu() {
        System.out.println("--------Login Program---------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }
}