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

       
        
        // Load language bundle for Validate
        validate.checkLanguage(choice);
        ResourceBundle bundle = validate.getBundle();

        boolean check = true;
        while (check) {            
            
            String accountNumber = validate.checkInputAccountNumber();
            if (!manager.checkAccountExist(accountNumber)) {
                System.err.println(bundle.getString("login_error1"));
                 System.out.println("-----------------------");
                System.out.println(bundle.getString("login_again"));
            }else{
                String password = validate.checkInputPassword();
                if (!manager.checkLogin(accountNumber, password)) {
                    System.out.println(bundle.getString("login_error2"));
                    System.out.println(bundle.getString("login_failed"));
                    System.out.println("-----------------------");
                System.out.println(bundle.getString("login_again"));
                
                }else{
                    checkCaptcha();
                    check = false;
                }
            }
        }
       
    }
    
public static void checkCaptcha() {
        // Create the objects again here, so no parameters need to be passed in
        LoginManager manager = new LoginManager();
        Validate validate = new Validate();
        // bundle is static in Validate, so a new Validate still has the chosen language
        ResourceBundle bundle = validate.getBundle();
 
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