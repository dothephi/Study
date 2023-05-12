/* Class for an account */
package data;

/**
 *
 * @author PhiDT
 */
public class Account {

    private String accName;
    private String pwd;
    private String role;

    public Account() {
    }

    public Account(String accName, String pwd, String role) {
        this.accName = accName;
        this.pwd = pwd;
        this.role = role;
    }

    public String getAccname() {
        return this.accName;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getRole() {
        return this.role;
    }
}
