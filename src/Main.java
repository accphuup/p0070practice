
import java.util.ResourceBundle;

/**
 * Class Main to run program.
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {

        //Init object.
        LoginManager manager = new LoginManager();
        Validate validate = new Validate();

        //Display menu.
        displayMenu();

        //Require User enter choice.
        int choice = validate.enterUserChoice("Please enter one choice: ");

        // Check if choice = 3 exit program.
        if (choice == 3) {
            System.out.println("Exit program...");
            return;
        }

        //Check choice and choose language by choice.
        validate.setLanguage(choice);

        //Get the chosen language messages.
        ResourceBundle bundle = validate.getBundle();

        //Loop until login success.
        while (true) {
//Require user enter account number and check valid input.
            String accountNumber = validate.checkInputAccountNumber();
            if (!manager.checkAccountExist(accountNumber)) {
                System.err.println(bundle.getString("login_error1"));
                System.out.println("-----------------------");
                System.out.println(bundle.getString("login_again"));
            } else {

                //Require user enter password and check valid input.
                String password = validate.checkInputPassword();
                if (!manager.checkLogin(accountNumber, password)) {
                    System.out.println(bundle.getString("login_error2"));
                    System.out.println(bundle.getString("login_failed"));
                    System.out.println("-----------------------");
                    System.out.println(bundle.getString("login_again"));

                } else {

                    //check captcha matches generate captcha.
                    checkCaptcha();
                    return;
                }
            }
        }

    }

    /**
     * Method check captcha matches generate captcha.
     */
    public static void checkCaptcha() {
        //Init object.
        LoginManager manager = new LoginManager();
        Validate validate = new Validate();

        // Get the chosen language messages.
        ResourceBundle bundle = validate.getBundle();

        // Captcha generate random.
        String captcha = manager.generateCaptcha();
        System.out.println(bundle.getString("captcha")+ captcha);

        //Require user enter captcha and check valid.
        String input = validate.checkInputCaptcha();

        //Loop until the captcha is correct.
        while (!manager.verifyCaptcha(input, captcha)) {
            System.out.println(bundle.getString("captcha_error"));

            //Require user enter captcha and check valid input.
            input = validate.checkInputCaptcha();
        }
        System.out.println(bundle.getString("login_status"));
    }

    /**
     * Display menu.
     */
    public static void displayMenu() {
        System.out.println("--------Login Program---------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }
}
