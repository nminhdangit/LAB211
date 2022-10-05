/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import File.Config;
import File.Tool;
import Object.Deliveries;
import Utils.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ListDeliveries {
    private Config config = new Config();
    private List<Deliveries> list = new ArrayList<Deliveries>();
    private static final String ID_FORM = "^DE\\d{3}";
    private static final String PHONE_FORM = "\\d{9}|\\d{11}";
    private final String FILE = config.getDeliveryFile();
    private boolean changed = false;

    public ListDeliveries() {
        readFile(FILE);
    }

    private void readFile(String file) {
        List<String> reader = Tool.readLineFromFile(file);
        for (int i = 0; i < reader.size(); i++) {
            String[] part = reader.get(i).split(",");
            list.add(new Deliveries(part[0], part[1], Integer.parseInt(part[2]), part[3], part[4], Float.parseFloat(part[5]), Boolean.parseBoolean(part[6])));

        }
    }

    public void add() {
        int index;
        String ID = null;
        System.out.println("New Delivery Details");
        do {
            ID = Validator.inputReg("ID of new Delivery: ", ID_FORM, "Error!ID must be in form DEXXX", false);
            index = checkID(ID);
            if (index >= 0) {
                System.out.println("ID is duplicated!");
            }
        } while (index >= 0);

        String product = Validator.input("Product of new Delivery: ", "Error!Product can not null!", false).trim();
        int quantity = Validator.getInt("Quantity of new Delivery: ", "Error!Quantity can not < 0!", false);
        String address = Validator.input("Address of new Delivery: ", "Error!Address can not null!", false);
        String phone = Validator.inputReg("Phone number of new Delivery: ", PHONE_FORM, "Error!Re-enter: ", false);
        float price = Validator.getFloat("Price of new Delivery: ", "Error!Price can not negative 0", false);
        boolean finish = true;
        list.add(new Deliveries(ID, product, quantity, address, phone, price, finish));
        System.out.println("New Delivery has been added.");
        changed = true;
    }

    public void search() {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("Have no Delivery.");
        } else {
            String ID = Validator.inputReg("Enter ID of Delivery: ", ID_FORM, "Error!ID must be in form DEXXX", false);
            index = checkID(ID);
            if (index == -1) {
                System.out.println("Do not have this Delivery.");
                return;
            } else {
                list.remove(index);
                System.out.println("Deleting Successful.");
            }
        }

    }

    public void save() {
        Tool.SaveToFile(FILE, list);
    }

    public void remove() {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("Have no Delivery.");
        } else {
            String ID = Validator.inputReg("Enter ID of Delivery: ", ID_FORM, "Error!ID must be in form DEXXX", false);
            index = checkID(ID);
            if (index == -1) {
                System.out.println("Do not have this Delivery.");
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
            System.out.println("Have no Delivery.");
        } else {
            String ID = Validator.inputReg("Enter ID of Delivery: ", ID_FORM, "Error!ID must be in form DEXXX", false);
            index = checkID(ID);
            if (index == -1) {
                System.out.println("Delivery " + ID + " not found.");
                return;
            } else {
                String product = Validator.input("Product of Delivery: ", "Error!Product can not null!", true);
                if (!product.isEmpty()) {
                    list.get(index).setProduct(product.trim());
                    changed = true;
                }
                int quantity = Validator.getInt("Quantity of Delivery: ", "Error!Quantity can not < 0!", true);
                if (quantity != 0) {
                    list.get(index).setQuantity(quantity);
                    changed = true;
                }
                String address = Validator.input("Address of Delivery: ", "Error!Address can not null!", true);
                if (!address.isEmpty()) {
                    list.get(index).setAddress(address);
                    changed = true;
                }
                String phone = Validator.inputReg("Phone number of Delivery: ", PHONE_FORM, "Error!Re-enter: ", true);
                if (!phone.isEmpty()) {
                    list.get(index).setPhone(phone);
                    changed = true;
                }
                float price = Validator.getFloat("Price of Delivery: ", "Error!Re-enter: ", true);
                if (price != 0.0f) {
                    list.get(index).setPrice(price);
                    changed = true;
                }
                String finish = Validator.inputYN("The Delivery finish(y) or not(n): ", true);
                if (!finish.isEmpty()) {
                   list.get(index).setFinish(Boolean.parseBoolean(finish));
                   changed = true;
                }
                if (changed) {
                    System.out.println("Updating Successful.");
                } else 
                    System.out.println("Nothing change.");
                
            }
        }

    }

    public void printall() {
        if (list.isEmpty()) {
            System.out.println("Empty List.");
        } else {
            for (Deliveries x : list) {
                System.out.println(x);
            }
        }
    }

    public void printFinish() {
        if (list.isEmpty()) {
            System.out.println("Empty List.");
        } else {
            for (Deliveries x : list) {
                if (x.isFinish()) {
                    System.out.println(x);
                }
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
}
