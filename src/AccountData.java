
import java.util.ArrayList;

public class AccountData {
    
    public ArrayList<Account> setUpData(){
        ArrayList<Account> accountList = new ArrayList<>();
        
        accountList.add(new Account("0123456789", "1234abcd"));
      accountList.add(new Account("0123456789", "123456ab"));
      accountList.add(new Account("0000011111", "1234abcd"));
        return accountList;
    }
}
