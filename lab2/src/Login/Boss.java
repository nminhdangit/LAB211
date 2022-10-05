/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import List.ListAccount;
import UIController.UIController;
import Utils.Validator;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Boss {

    private UIController ui = new UIController();
    private ListAccount list = new ListAccount();

    public void run() {
        int choice = 0;
        System.out.println("Welcome Boss");
        do {
            ui.dispatchRequest("boss");
            choice = Validator.getInt("Choose [1..6]: ", "Error!Re-enter: ", false);
            switch (choice) {
                case 1:
                    list.add();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.add();
                    }
                    break;
                case 2:
                    list.search();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.search();
                    }
                    break;
                case 3:
                    list.remove();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.remove();
                    }
                    break;
                case 4:
                    list.update();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.update();
                    }
                    break;
                case 5:
                    list.print();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.print();
                    }
                    break;
                case 6:
                    list.save();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.save();
                    }
                    break;
            }
        } while (choice >= 1 && choice <= 6);
    }
}
