/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import DAO.product;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validator {

    public static String input(String msg, String error, boolean upgrade, int max) {
        boolean check = false;
        String input = "";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                if (upgrade == true) {
                    check = true;
                } else {
                    System.out.println(error);
                }
            } else {
                if (input.length() < max) {
                    System.out.println(error);
                } else {
                    if (input.contains(" ")) {
                        System.out.println("Error! Name can not contain space!!!");
                    } else {
                        check = true;
                    }
                }

            }
        } while (check == false);

        return input;
    }

    public static String inputReg(String msg, String pattern, String error, boolean upgrade) {
        boolean check = false;
        String input = "";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                if (upgrade) {
                    check = true;
                } else {
                    System.out.println("Error! Please re-enter " + error + ". This can not null!!!");
                }
            } else if (input.matches(pattern)) {
                check = true;
            } else {
                System.out.println(error);
            }

        } while (check == false);

        return input;
    }

    public static float getFloat(String msg, boolean upgrade) {
        boolean check = false;
        float inputNumber = 0;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                inputNumber = Float.parseFloat(sc.nextLine());

                if (inputNumber < 0 || inputNumber > 10000) {
                    System.out.println("Error!! The UnitPrice must be in range of 0 to 10000");
                } else {
                    check = true;
                }

            } catch (Exception e) {
                if (inputNumber == 0.0f && upgrade == true) {
                    check = true;
                } else {
                    System.out.println("Error!! Please enter the number");
                }
            }

        } while (check == false || inputNumber < 0 || inputNumber > 10000);

        return inputNumber;

    }

    public static int getInt(String msg, int max, boolean upgrade) {
        boolean check = false;
        int inputNumber = 0;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                inputNumber = Integer.parseInt(sc.nextLine());

                if (inputNumber < 0 || inputNumber > max) {
                    System.out.println("Error!! The number must be in range of 0 to " + max);
                } else {
                    check = true;
                }

            } catch (Exception e) {
                if (inputNumber == 0 && upgrade == true) {
                    check = true;
                } else {
                    System.out.println("Error!! Please enter the integer number");
                }
            }

        } while (check == false || inputNumber < 0 || inputNumber > max);

        return inputNumber;
    }

    public static String getStatus(String msg, boolean upgrade) {
        boolean check = false;
        String status = null;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.print(msg);
            status = sc.nextLine();
            if (status.isEmpty()) {
                if (upgrade) {
                    check = true;
                }
            } else {
                if (status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("Not Available")) {
                    check = true;
                } else {
                    System.out.println("Error!! The Status must be Available or Not Available!!");
                }
            }

        } while (check == false);

        return status;
    }

    public static int checkName(List<product> list, String name) {
        int pos = -1;
        for (int i = 0; i < list.size(); i++) {
            if (name.equalsIgnoreCase(list.get(i).getProductName())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static int checkID(List<product> list, String productID) {
        int pos = -1;
        for (int i = 0; i < list.size(); i++) {
            if (productID.equalsIgnoreCase(list.get(i).getProductID())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

}
