import java.util.HashMap;

public class bank {
    HashMap<Integer, account> accountMap = new HashMap<>();
    transferWriter transferWriter;
    transferReader transferReader;

    /**
     * @param name
     * @param balance
     * @return
     */
    public boolean createAccount(String name, double balance) {
        return false;
    }

    /**
     * @param accountNumber
     * @param transferID
     * @param amount
     * @return
     */
    public boolean newTransfer(int accountNumber, int transferID, double amount) {
        return false;
    }

    /**
     * @return
     */
    public boolean executePendingTransfers() {
        return false;
    }

    /**
     * @param accountNumber
     * @return
     */
    public account getAccountByID(int accountNumber) {
        return new account();
    }
}
