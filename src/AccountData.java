
import java.util.ArrayList;

/**
 * Class contain account data.
 *
 * @author Admin
 */
public class AccountData {

    /**
     * Create the list accounts.
     *
     * @return listAccount.
     */
    public ArrayList<Account> setUpData() {
        
        //Declare listAccount to stores all valid account.
        ArrayList<Account> listAccount = new ArrayList<>();

        listAccount.add(new Account("0123456789", "1234abcd"));
        listAccount.add(new Account("0123456789", "123456ab"));
        listAccount.add(new Account("0000011111", "1234abcd"));
        return listAccount;
    }
}
