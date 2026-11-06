
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Class validate to check language and valid input user.
 *
 * @author Admin
 */
public class Validate {

    /**
     * Declare scanner with field private.
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Store the messages of the language user choice.
     */
    private static ResourceBundle bundle;

    /**
     * Method load the language file by the users choice.
     *
     * @param choice from user enter.
     */
    public void setLanguage(int choice) {
        if (choice == 1) {
            bundle = ResourceBundle.getBundle("Vi");

        } else {
            bundle = ResourceBundle.getBundle("En");
        }
    }

    /**
     * Get the messages in the chosen language.
     *
     * @return bundle.
     */
    public ResourceBundle getBundle() {
        return bundle;
    }

    /**
     * Check valid input choice from user.
     *
     * @param msg require user enter choice.
     * @return number.
     */
    public int enterUserChoice(String msg) {

        // Loop until the user enters a valid choice
        while (true) {
            try {
                System.out.println(msg);
                String input = scanner.nextLine().trim();
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= 3) {
                    return number;
                } else {
                    System.err.println("Input must be number 1, 2, 3. Please enter again.");
                }

            } catch (NumberFormatException e) {
                System.err.println("Invalid format! Please enter again.");
            }
        }
    }

    /**
     * Check valid input account number from user.
     *
     * @return input.
     */
    public String checkInputAccountNumber() {
        String accountNumber = bundle.getString("account_number");
        String messageError = bundle.getString("account_error");

        // Loop until the account number is valid.
        while (true) {
            System.out.print(accountNumber);
            String input = scanner.nextLine().trim();
            if (input.length() != 10) {
                System.err.println(messageError);
            } else {
                boolean flag = true;

                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (c < '0' || c > '9') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return input;
                } else {
                    System.err.println(messageError);
                }
            }

        }
    }

    /**
     * Check valid input password from user.
     *
     * @return input
     */
    public String checkInputPassword() {
        String password = bundle.getString("password");
        String messageError = bundle.getString("password_error");

        // Loop until the password is valid.
        while (true) {
            System.out.print(password);
            String input = scanner.nextLine().trim();
            if (input.length() >= 8 && input.length() <= 31) {
                int countNumber = 0;
                int countChar = 0;

                boolean flag = true;

                // Loop to check character and number.
                for (int i = 0; i < input.length(); i++) {
                    char character = input.charAt(i);
                    if (character >= '0' && character <= '9') {
                        countNumber++;
                    } else {
                        if (character < 'A' || character > 'Z' && character < 'a' || character > 'z') {
                            flag = false;
                            break;
                        }
                        countChar++;

                    }
                }
                if (flag && countNumber > 0 && flag && countChar > 0) {
                    return input;
                } else {
                    System.err.println(messageError);
                }

            } else {
                System.err.println(messageError);
            }
        }
    }

    /**
     * Check valid input captcha from user.
     *
     * @return input.
     */
    public String checkInputCaptcha() {
        String captcha = bundle.getString("captcha");
        String messageError = bundle.getString("captcha_error");

        // Loop until the captcha is valid.
        while (true) {
            System.out.print(captcha);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.err.println(messageError);
            }
        }
    }
}
