
import java.util.ResourceBundle;
import java.util.Scanner;

public class Validate {

    private static final Scanner scanner = new Scanner(System.in);

    private static ResourceBundle bundle;

   

    public void checkLanguage(int choice) {
        if (choice == 1) {
            bundle = ResourceBundle.getBundle("Vi");

        } else {
            bundle = ResourceBundle.getBundle("En");
        }
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public int enterUserChoice(String msg) {
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

    public String checkInputAccountNumber() {
        String accountNumber = bundle.getString("account_number");
        String messageError = bundle.getString("account_error");

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

    public String checkInputPassword() {
        String password = bundle.getString("password");
        String messageError = bundle.getString("password_error");

        while (true) {
            System.out.print(password);
            String input = scanner.nextLine().trim();
            if (input.length() >= 8 && input.length() <= 31) {
                int countNumber =0;
                int countChar = 0;
                
                boolean flag = true;
                
                for (int i = 0; i < input.length(); i++) {
                    char character = input.charAt(i);
                    if (character >= '0' && character <= '9') {
                        countNumber++;
                    }else{
                        if (character < 'A' || character > 'Z' && character < 'a' || character >'z') {
                            flag = false;
                            break;
                        }
                        countChar++;
                        
                    }
                }
                
                if (flag && countNumber > 0 && flag && countChar > 0) {
                    return  input;
                }else{
                        System.err.println(messageError);
                }
            }
            System.err.println(messageError);
        }
    }

    public String enterCaptcha() {
        String captcha = bundle.getString("captcha");
        String messageError = bundle.getString("captcha_error");
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
