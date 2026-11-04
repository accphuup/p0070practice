
import java.util.ArrayList;
import java.util.Random;

public class LoginManager {

    // Return null if login info is correct, otherwise the key of the error message
    public int checkLogin(Account account) {
        ArrayList<Account> accountList = new AccountData().setUpData();
        boolean accountFound = false;
        boolean passwordCorrect = false; 
        
        for (Account accounts : accountList) {
            // Find accounts with the same account number
            if (accounts.getAccount().contains(account.getAccount())) {
                accountFound = true;
                // Password matches: login info is correct
                if (accounts.getPassword().contains(account.getPassword())) {
                    passwordCorrect = true;
                }
            }
        }

        if (!accountFound) {
            return 1;
        }
        if (!passwordCorrect) {
            return 2;
        }
        return 3;
    }

    // Create a random 5-character captcha
    public String generateCaptcha() {
        Random rd = new Random();
        String charSt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String result = "";

        for (int i = 0; i < 5; i++) {
            // Pick a random position in charSt
            int index = rd.nextInt(charSt.length());
            // Append the character at that position
            result += charSt.charAt(index);
        }
        return result;
    }

    // Return true if the input characters are contained in the generated captcha
    public boolean checkCaptcha(String captchaInput, String captchaGenerate) {
        return captchaGenerate.contains(captchaInput);
    }
}
