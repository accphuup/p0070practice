
/**
 * Class Account declare object.
 *
 * @author Admin
 */
public class Account {

    /**
     * Attribute accountNumber.
     */
    private String accountNumber;

    /**
     * Attribute password.
     */
    private String password;

    public Account() {
    }

    public Account(String account, String password) {
        this.accountNumber = account;
        this.password = password;
    }

    public String getAccount() {
        return accountNumber;
    }

    public void setAccount(String account) {
        this.accountNumber = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
