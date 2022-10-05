/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validator {

    public static String input(String msg, String error, boolean upgrade) {
        boolean check = false;
        String input = null;
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
                check = true;
            }
        } while (check == false);

        return input;
    }

    public static String inputYN(String msg,boolean upgrade) {
        String input;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.print(msg);
            input = sc.nextLine();
            if(upgrade){
                if(input.isEmpty()){
                    return input;
                }
            }
            if (input.isEmpty()) {

                System.out.println("Error!This can not null");

            } else {
                if (input.equalsIgnoreCase("Y")) {
                    return "true";
                } else if (input.equalsIgnoreCase("N")) {
                    return "false";
                } else {
                    System.out.println("Error!Please choose (y) or (n)");
                }
            }

        } while (true);
    }

    public static String inputReg(String msg, String pattern, String error, boolean upgrade) {
        boolean check = false;
        String input = null;
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

    public static float getFloat(String msg, String error, boolean upgrade) {
        boolean check = false;
        float inputNumber = 0;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                inputNumber = Float.parseFloat(sc.nextLine());

                if (inputNumber < 0) {
                    System.out.println(error);
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

    public static int getInt(String msg, String error, boolean upgrade) {
        boolean check = false;
        int inputNumber = 0;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.print(msg);
                inputNumber = Integer.parseInt(sc.nextLine());
                if (inputNumber < 0) {
                    System.out.println(error);
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

        } while (check == false || inputNumber < 0);

        return inputNumber;
    }
    
    public static int checkIndex(List list,String ID, String IdList){
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (ID.equalsIgnoreCase(IdList)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static boolean repeat(String msg) {
        String call = Validator.inputReg(msg, "[[YN][yn]]", "Please choose (Y/N)!!", false);
        if (call.equalsIgnoreCase("N")) {
            return false;
        } else {
            return true;
        }
    }

}
