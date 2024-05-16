
package common.model;

/**
 *
 * @author lucht
 */
public class Administrator extends Account{
    private boolean isAdmin;

    public Administrator() {
    }

    public Administrator(boolean isAdmin, String firstName, String lastName, String emailAddress, String password) {
        super(firstName, lastName, emailAddress, password);
        this.isAdmin = isAdmin;
    }
    
    public Administrator(boolean isAdmin, int accountId, String firstName, String lastName, String emailAddress, String password) {
        super(accountId, firstName, lastName, emailAddress, password);
        this.isAdmin = isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }
    
    
}
