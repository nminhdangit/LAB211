
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import File.Config;
import File.Tool;
import Object.Account;
import Utils.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ListAccount {
    private static final String ID_FORM = "E\\d{3}";
    private List<Account> list = new ArrayList(); 
    private boolean changed = false;
    private Config config = new Config();
    private final String File = config.getAccountFile();
    
    
    
    public ListAccount() {
        readFile(File);
    }
    
    public void save() {

        Tool.SaveToFile(File, list);
    }
    
    public void add(){
        int index;
        String account = null;
        System.out.println("New Account Details");
        do {
            account = Validator.inputReg("New Account: ", ID_FORM, "Error!Account must be in form EXXX", false);
            index = checkAccount(account);
            if (index >= 0) {
                System.out.println("Account is duplicated!");
            }
        } while (index >= 0);
        
        String password = Validator.input("New Password: ", "Error!Please re-enter: ", false);
        String role = Validator.inputReg("Role: ", "BOSS||ACC-1||ACC-2", "Error!Role must be BOSS ACC-1 ACC-2: ", false);
        System.out.println("Adding Successful.");
        list.add(new Account(account, password, role));
    }
    
    public void search() {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("Have no Account.");
        } else {
            String ID = Validator.inputReg("Account: ", ID_FORM, "Error!Account must be in form EXXX", false);
            index = checkAccount(ID);
            if (index == -1) {
                System.out.println("Account not found.");
                return;
            } else {
                System.out.println(list.get(index));
            }
        }
    }
    
    public void update(){
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("Have no Account.");
        } else {
            String account = Validator.inputReg("Account: ", ID_FORM, "Error!Account must be in form EXXX", false);
            index = checkAccount(account);
            if (index == -1) {
                System.out.println("Account " + account + " not found.");
                return;
            } else {
                String password = Validator.input("New Password: ", "Error!Please re-enter: ", true);
                if (!password.isEmpty()) {
                    list.get(index).setPassword(password);
                    changed = true;
                }
                String role = Validator.inputReg("Role: ", "BOSS||ACC-1||ACC-2", "Error!Role must be BOSS ACC-1 ACC-2: ", true);
                if (!role.equalsIgnoreCase(list.get(index).getRole())) {
                    list.get(index).setRole(role);
                    changed = true;
                }
                if(changed){
                    System.out.println("Updating Successful.");
                }else{
                    System.out.println("Nothing change.");
                }
                
            }
        }
    }
    
    public void remove() {
        int index = -1;
        if(list.isEmpty()){
            System.out.println("Have no Account.");
        }else{
            String account = Validator.inputReg("Account: ", ID_FORM, "Error!Account must be in form EXXX", false);
            index = checkAccount(account);
            if (index == -1) {
                System.out.println("Account " + account + " not found.");
                return;
            } else {
                list.remove(index);
                changed = true;
                System.out.println("Remove Successful.");
            }
        }
    }
    
    public void print(){
        if(list.isEmpty()){
            System.out.println("Have no Account.");
        }else{
            for(Account x: list){
                System.out.println(x);
            }
        }
    }
    
    
    
    private void readFile(String file){
        List<String> reader = Tool.readLineFromFile(file);
        for(int i=0;i<reader.size();i++){
            String[] part = reader.get(i).split(",");
              list.add(new Account(part[0],part[1],part[2]));
        }
    }
    
    
    
    
    
    private int checkAccount(String account) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (account.equalsIgnoreCase(list.get(i).getAccount())) {
                index = i;
                return index;
            }
        }
        return index;
    }
    
    
    
}
