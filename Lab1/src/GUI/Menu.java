/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.productDAO;
import Utils.Text;
import Utils.Validator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Menu {

    public static void main(String[] args) {
        try {
            productDAO list = new productDAO();
            System.out.println(Text.ANSI_CYAN_BACKGROUND + Text.ANSI_BLACK + "Welcome to Lab project" + Text.ANSI_RESET);
            Thread.sleep(3000);
            String fname = list.pathFile();
            boolean loop = true;
            int choice = 0;
            do {
                System.out.println(Text.ANSI_CYAN_BACKGROUND + Text.ANSI_BLACK + "----------------------Main Menu----------------------\n" + Text.ANSI_RESET);
                System.out.println("1. Print");
                System.out.println("2. Create a Product");
                System.out.println("3. Check to exist Product");
                System.out.println("4. Search Product information by name");
                System.out.println("5. Update Product");
                System.out.println("6. Save to File");
                System.out.println("7. Print all lists from file");
                System.out.println("8. Quit");
                choice = Validator.getInt("Enter the choice: ", 8, false);
                switch (choice) {
                    case 1:
                        loop = true;
                        do {
                            list.print();
                            String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
                            if (call.equalsIgnoreCase("N")) {
                                continue;
                            } else {
                                loop = false;
                            }
                        } while (loop == true);
                        break;
                    
                    
                    case 2:
                        loop = true;
                        do {
                            list.createProduct();
                            String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
                            if (call.equalsIgnoreCase("N")) {
                                continue;
                            } else {
                                loop = false;
                            }
                        } while (loop == true);
                        break;
                    case 3:
                        loop = true;
                        do {
                            list.checkExist(fname);
                            String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
                            if (call.equalsIgnoreCase("N")) {
                                continue;
                            } else {
                                loop = false;
                            }
                        } while (loop == true);
                        break;
                    case 4:
                        loop = true;
                        do {
                            list.searchProduct();
                            String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
                            if (call.equalsIgnoreCase("N")) {
                                continue;
                            } else {
                                loop = false;
                            }
                        } while (loop == true);
                        break;
                    case 5:

                        list.updateProduct();
                        break;
                    case 6:
                        loop = true;
                        do {
                            list.saveFile(fname);
                            String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
                            if (call.equalsIgnoreCase("N")) {
                                continue;
                            } else {
                                loop = false;
                            }
                        } while (loop == true);
                        break;
                    case 7:
                        loop = true;
                        do {
                            list.printFromFile(fname);
                            String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
                            if (call.equalsIgnoreCase("N")) {
                                continue;
                            } else {
                                loop = false;
                            }
                        } while (loop == true);
                        break;
                    case 8:
                        System.out.println("Thank you");
                }
            } while (choice < 8 || choice > 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
