
import java.util.ArrayList;
import java.util.Random;


public class LoginManager {

    private ArrayList<Account> listAccounts = new AccountData().setUpData();
    public boolean checkAccountExist(String accountNumber){ 
        for (Account account : listAccounts) {
            if (account.getAccount().contains(accountNumber)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkLogin(String accountNumber , String password){
        for (Account account : listAccounts) {
            if (account.getAccount().contains(accountNumber) && account.getAccount().contains(password)) {
                return true;
            }
        }
        return false;
    }
    
    public String generateCaptcha(){
        Random random = new Random();
        String charCaptcha = "ABCDEFGHXYZ123456789";
        String result = "";
        for (int i = 0; i < 5; i++) {
            
            int index  = random.nextInt(charCaptcha.length());
        result += charCaptcha.charAt(index);
        }
        return result;
    }
    
    public boolean checkCaptcha(String captchaInput, String captchaGenerate){
         if (captchaGenerate.contains(captchaInput)) {
            return true;
        } else {
            return false;
        }
    }
}