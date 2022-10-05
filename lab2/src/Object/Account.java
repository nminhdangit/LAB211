/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Admin
 */
public class Account {
    private String account;
    private String password;
    private String role;
    private static final String ID_FORM = "E\\d{3}";
    private static final String ROLE_FORM = "BOSS||ACC-1||ACC-2";

    public Account(String account, String password, String role) {
        this.account = account.toUpperCase();
        this.password = password;
        this.role = role.toUpperCase();
    }
    

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account.toUpperCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role.toUpperCase();
    }

    @Override
    public String toString() {
        return account+","+password+","+role;
    }
    
    
    
    
}
