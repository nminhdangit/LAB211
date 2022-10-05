/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import List.ListDealer;
import UIController.UIController;
import Utils.Validator;

/**
 *
 * @author Admin
 */
public class Acc1 {

    private UIController ui = new UIController();
    private ListDealer list = new ListDealer();

    public void run() {
        int choice = 0;
        System.out.println("Hi ACC-1");
        do {
            ui.dispatchRequest("dealerview");
            choice = Validator.getInt("Choose [1..8]: ", "Error!Re-enter: ", false);
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
                    list.printall();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.printall();
                    }
                    break;
                case 6:
                    list.printContinuing();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.printContinuing();
                    }
                    break;
                case 7:
                    list.printUnContinuing();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.printUnContinuing();
                    }
                    break;
                case 8:
                    list.save();
                    while (!Validator.repeat("Do you want to go back to the main menu(Y/N): ")) {
                        list.save();
                    }
                    break;
            }
        } while (choice >= 1 && choice <= 8);
    }
}
