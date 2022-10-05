/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import File.Config;
import File.Tool;
import Utils.Validator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Login {

    private static final String ACC_FORM = "E\\d{3}";
    Scanner sc = new Scanner(System.in);
    private Boss boss = new Boss();
    private Acc1 acc1 = new Acc1();
    private Acc2 acc2 = new Acc2();
    private Config config = new Config();
    private final String File = config.getAccountFile();


    public void loggin() {
        String account = null;
        String password = null;
        System.out.println("Login to the System.");
        account = Validator.inputReg("Your account name: ", ACC_FORM, "Error!Account must be EXXX.", false);
        System.out.print("Your password: ");
        password = sc.nextLine();
        if (checkAccount(account, password) == false) {
            if (Validator.repeat("Do you want to re-enter(y) or quit(n): ") == true) {
                loggin();
            } else {
                return;
            }
        } else {
            return;
        }

    }

    private void access(String role) {
        if (role.equals("BOSS")) {
            boss.run();
        } else if (role.equals("ACC-1")) {
            acc1.run();
        } else {
            acc2.run();
        }
         if(Validator.repeat("Do you want to go back to the login hub(Y/N): ")) {
            loggin();
        }else{
             return;
         }
        
    }

    private boolean checkAccount(String account, String password) {
        List<String> accList = new ArrayList();
        accList = Tool.readLineFromFile(File);
        int check = -1;
        for (int i = 0; i < accList.size(); i++) {
            String[] txt = accList.get(i).split(",");
            if (account.equals(txt[0])) {
                check += 1;
                if (password.equals(txt[1])) {
                    check += 1;
                    System.out.println("Your role: " + txt[2]);
                    access(txt[2]);
                }
            }
        }
        if (check == -1) {
            System.out.println("Do not have " + account + " in the system.");
            return false;
        }
        if (check == 0) {
            System.out.println("Wrong password.");
            return false;
        }
        return true;
    }
}
