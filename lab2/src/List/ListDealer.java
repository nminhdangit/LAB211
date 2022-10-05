/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import File.Config;
import File.Tool;
import Object.Dealer;
import Utils.Validator;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ListDealer {

    private List<Dealer> list = new ArrayList<Dealer>();
    private Config config = new Config();
    private static final String ID_FORM = "D\\d{3}";
    private static final String PHONE_FORM = "\\d{9}|\\d{11}";
    private final String FILE = config.getDealerFile();
    private boolean changed = false;

    public ListDealer() {
        readFile(FILE);
    }

    
    public void add() {
        int index;
        String ID = null;
        System.out.println("New Dealer Details");
        do {
            ID = Validator.inputReg("ID of new dealer: ", ID_FORM, "Error!ID must be in form DXXX", false);
            index = checkID(ID);
            if (index >= 0) {
                System.out.println("ID is duplicated!");
            }
        } while (index >= 0);

        String name = Validator.input("Name of new dealer: ", "Error!Name can not null!", false).trim();
        String address = Validator.input("Address of new dealer: ", "Error!Address can not null!", false);
        String phone = Validator.inputReg("Phone number of new dealer: ", PHONE_FORM, "Error!Re-enter: ", false);
        boolean continuing = true;
        list.add(new Dealer(ID, name, address, phone, continuing));
        System.out.println("New dealer has been added.");
        changed = true;
    }

    
    public void search() {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("Have no Dealer.");
        } else {
            String ID = Validator.inputReg("Enter ID of Dealer: ", ID_FORM, "Error!ID must be in form DXXX", false);
            index = checkID(ID);
            if (index == -1) {
                System.out.println("Not Found.");
                return;
            } else {
                System.out.println(list.get(index));
            }
        }
    }

    
    public void remove() {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("Have no Dealer.");
        } else {
            String ID = Validator.inputReg("Enter ID of Dealer: ", ID_FORM, "Error!ID must be in form DXXX", false);
            index = checkID(ID);
            if (index == -1) {
                System.out.println("Do not have this Dealer.");
                return;
            } else {
                list.remove(index);
                System.out.println("Deleting Successful.");
            }
        }
    }

    
    public void update() {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("Have no Dealer.");
        } else {
            String ID = Validator.inputReg("Enter ID of Dealer: ", ID_FORM, "Error!ID must be in form DXXX", false);
            index = checkID(ID);
            if (index == -1) {
                System.out.println("Dealer " + ID + " not found.");
                return;
            } else {
                String name = Validator.input("Enter new name: ", "Error!Name can not null!", true);
                if (!name.isEmpty()) {
                    list.get(index).setName(name.trim());
                    changed = true;
                }
                String address = Validator.input("Enter new address: ", "Error!Address can not null!", true);
                if (!address.isEmpty()) {
                    list.get(index).setAddress(address);
                    changed = true;
                }
                String phone = Validator.inputReg("Enter new phone number: ", PHONE_FORM, "Error!Re-enter: ", true);
                if (!phone.isEmpty()) {
                    list.get(index).setPhone(phone);
                    changed = true;
                }
                String continuing = Validator.inputYN("Still Continuing(y) or Not(n): ", true);
                if(!continuing.isEmpty()){
                    list.get(index).setContinuing(Boolean.parseBoolean(continuing));
                    changed = true;
                }
                if(changed){
                    System.out.println("Updating Successful.");
                }else
                    System.out.println("Nothing change.");
                
            }
        }
    }

    
    public void printall() {
        if (list.isEmpty()) {
            System.out.println("Empty List.");
        } else {
            for (Dealer x : list) {
                System.out.println(x);
            }
        }
    }

    
    public void save() {

        Tool.SaveToFile(FILE, list);
    }

    public void printUnContinuing() {
        int flag = 0;
        if (list.isEmpty()) {
            System.out.println("Empty List.");
        } else {
            for (Dealer x : list) {
                if (!x.isContinuing()) {
                    System.out.println(x);
                    flag = 1;
                }
            }
            if(flag ==0){
                System.out.println("Have no Un-Continuing Dealer.");
            }
        }
    }

    public void printContinuing() {
        int flag =0;
        if (list.isEmpty()) {
            System.out.println("Empty List.");
        } else {
            for (Dealer x : list) {
                if (x.isContinuing()) {
                    System.out.println(x);
                    flag = 1;
                }
            }
            if(flag == 0){
                System.out.println("Have no Continuing Dealer.");
            }
        }
    }

    private int checkID(String ID) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (ID.equalsIgnoreCase(list.get(i).getID())) {
                index = i;
                return index;
            }
        }
        return index;
    }
    
    private void readFile(String file){
        List<String> reader = Tool.readLineFromFile(file);
        for(int i=0;i<reader.size();i++){
            String[] part = reader.get(i).split(",");
            list.add(new Dealer(part[0], part[1], part[2],part[3],Boolean.parseBoolean(part[4])));
        
        }
    }


}
