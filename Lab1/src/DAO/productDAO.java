package DAO;

import Utils.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class productDAO implements DAO<product> {
    List<product> listemp = new ArrayList();
    List<product> list = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public int checkFile(String fname) {
        int check = 0;
        try {
            File f = new File(fname);
            if (f.isFile()) {
                System.out.println("a " + fname + " Exist");
                check = 1;
            } else {
                System.out.println("Not found");
                check = 0;
            }

        } catch (Exception e) {
            System.out.println("Faild");
            e.printStackTrace();
            check = 0;
        }
        return check;
    }

    public void createFile(String fname) {
        int check = 1;
        try {
            File f = new File(fname);
            f.createNewFile();
            System.out.println("Create a " + fname + " success");
            Thread.sleep(1000);
        } catch (IOException e) {
            System.out.println("Create faild!!");
            check = 0;
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String pathFile() {
        String fname = null;
        int check;
        int checkCreate;
        try {

            String call = Validator.inputReg("Do you have a file(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
            if (call.equalsIgnoreCase("Y")) {
                do {
                    fname = Validator.inputReg("Please enter file name: ", ".*\\.dat$", "Please input in form xxxx.dat", false);
                    check = checkFile(fname);
                    if (check == 1) {
                        System.out.println("Waiting Load File....");
                        loadFile(fname);
                        Thread.sleep(3000);
                        return fname;
                    } else {

                        String call1 = Validator.inputReg("Do want to create a new (Y) or re-enter a file name (N) (Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);
                        if (call1.equalsIgnoreCase("Y")) {
                            fname = Validator.inputReg("Please enter the new file name: ", ".*\\.dat$", "Please input in form xxxx.dat", false);
                            createFile(fname);
                            loadFile(fname);
                            check = 1;

                        } else {
                            check = 0;
                        }

                    }
                } while (check == 0);
            } else {
                fname = Validator.inputReg("Please enter the new file name : ", ".*\\.dat$", "Please input in form xxxx.dat", false);
                createFile(fname);
                loadFile(fname);
                return fname;

            }
        } catch (Exception e) {
            System.out.println("Faild");
            e.printStackTrace();
        }

        return fname;
    }

    @Override
    public void loadFile(String fname) {

        try {
            FileInputStream fis = new FileInputStream(fname);
            if (fis.read() == -1) {
                return;
            }
            fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<product>) ois.readObject();

            fis.close();
            ois.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

    }

    @Override
    public void saveFile(String fname) {
        try {
            //list = loadFile(fname);

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(list);
            oos.close();
            System.out.println("Save file Success");

        } catch (FileNotFoundException e) {
            System.out.println("Save file faild");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Save file faild");
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void print(){
        if(listemp.isEmpty()){
            System.out.println("Have no product.");
        }else{
        for(product x: listemp){
            System.out.println(x);
        }
    }}

    @Override
    public void createProduct() {
        int pos;

        System.out.println("Enter New Product Details");
        String productID = Validator.inputReg("Enter the productID: ", "\\d{3}", "The productID should be in form xxx (Ex:001)", false);
        pos = Validator.checkID(list, productID);
        while (pos >= 0) {
            System.out.println("The productID is duplicated");
            productID = Validator.inputReg("Enter the productID: ", "\\d{3}", "The productID should be in form xxx (Ex:001)", false);
            pos = Validator.checkID(list, productID);
        }

        String name = Validator.input("Enter the Product Name: ", "Error! Name field must be at least five characters", false, 5);
        pos = Validator.checkName(list, name);
        while (pos >= 0) {
            System.out.println("The name is duplicated");
            name = Validator.input("Re-enter the Product Name: ", "Error! Name field must be at least five characters", false, 5);
            pos = Validator.checkName(list, name);
        }
        float unitPrice = Validator.getFloat("Enter the Unit Price: ", false);
        int Quantity = Validator.getInt("Enter the number of Quantity: ", 1000, false);
        String Status = Validator.getStatus("Enter the Status(Available or Not Available): ", false);
        list.add(new product(productID, name, unitPrice, Quantity, Status));
        listemp.add(new product(productID, name, unitPrice, Quantity, Status));
    }

    @Override
    public void printFromFile(String fname) {
        try {
            FileInputStream fis = new FileInputStream(fname);
            if (fis.read() == -1) {
                System.out.println("The file is empty!!");
                return;
            }
            fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<product> resultlist = (ArrayList) ois.readObject();

            if (resultlist.isEmpty()) {
                System.out.println("The file is empty");
                return;
            }
            Collections.sort(resultlist, new Comparator<product>() {
                @Override
                public int compare(product t, product t1) {
                    if (t.getQuantity() != t1.getQuantity()) {
                        if (t1.getQuantity() > t.getQuantity()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        if (t.getUnitPrice() > t1.getUnitPrice()) {
                            return 1;
                        }else{
                            return -1;
                        
                        }
                        
                    }

                }

            });

            for (product x : resultlist) {
                System.out.println(x);
            }

            fis.close();
            ois.close();

        } catch (FileNotFoundException e) {
            System.out.println("Print file failda");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Print file faildb");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Print file faildc");
            e.printStackTrace();
        }
    }

    @Override
    public void checkExist(String fname) {

        int check = -1;
        try {

            FileInputStream fis = new FileInputStream(fname);
            if (fis.read() == -1) {
                System.out.println("File has no any product");
                return;
            }
            fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<product> resultlist = (ArrayList) ois.readObject();
            String name = Validator.input("Enter the Product Name you want to check: ", "Error! Name field must be at least five characters", false, 5);
            for (product x : resultlist) {
                if (name.equalsIgnoreCase(x.getProductName())) {
                    check = 1;
                    break;
                }
            }
            if (check == 1) {
                System.out.println("Exist Product");
            } else {
                System.out.println("No Product Found!");
            }

            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchProduct() {
        String name;
        int index = -1;
        if (list.size() != 0) {
            name = Validator.input("Enter the Product Name you want to search: ", "Error!!Need at least 1 character", false, 1);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProductName().contains(name)) {
                    index = i;
                    System.out.println(list.get(index));
                }
            }
            if (index == -1) {
                System.out.println("Not found!!!");

            }

        } else {
            System.out.println("Have no any Product");

        }
    }

    @Override
    public void UpdateInfor() {
        String productID;
        int pos;
        int index = -1;

        if (list.size() != 0) {
            productID = Validator.inputReg("Enter the productID you want to update: ", "\\d{3}", "The productID should be in form xxx (Ex:001)", false);
            for (int i = 0; i < list.size(); i++) {
                if (productID.equalsIgnoreCase(list.get(i).getProductID())) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("ProductID does not exist");

            } else {
                try {
                    System.out.println("The Information you want to change ");
                    String productIDc = Validator.inputReg("Enter the ProductID: ", "\\d{3}", "The ProductID should be in form xxx (Ex:001)", true);
                    if (productIDc.isEmpty()){
                        productIDc = list.get(index).getProductID();
                    } else {
                        pos = Validator.checkID(list, productIDc);
                        while (pos >= 0) {
                            System.out.println("The productID is duplicated");
                            productIDc = Validator.inputReg("Enter the ProductID: ", "\\d{3}", "The ProductID should be in form xxx (Ex:001)", true);
                            pos = Validator.checkID(list, productIDc);
                        }
                    }
                    String name = Validator.input("Enter the Product Name: ", "Error! Name field must be at least five characters", true, 5);

                    if (name.isEmpty()) {
                        name = list.get(index).getProductName();
                    } else {
                        pos = Validator.checkName(list, name);
                        while (pos >= 0) {
                            System.out.println("The name is duplicated");
                            name = Validator.input("Re-enter the Product Name: ", "Error! Name field must be at least five characters", true, 5);
                            pos = Validator.checkName(list, name);
                        }
                    }
                    float unitPrice = Validator.getFloat("Enter the Unit Price: ", true);
                    if (unitPrice == 0.0f) {
                        unitPrice = list.get(index).getUnitPrice();
                    }
                    int Quantity = Validator.getInt("Enter the number of Quantity: ", 1000, true);
                    if (Quantity == 0) {
                        Quantity = list.get(index).getQuantity();
                    }
                    String Status = Validator.getStatus("Enter the Status(Available or Not Available): ", true);
                    if (Status.isEmpty()) {
                        Status = list.get(index).getStatus();
                    }
                    list.get(index).setProductID(productIDc);
                    list.get(index).setProductName(name);
                    list.get(index).setQuantity(Quantity);
                    list.get(index).setUnitPrice(unitPrice);
                    list.get(index).setStatus(Status);
                    System.out.println("Updated Success");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Update Faild");
                }
            }

        } else {
            System.out.println("Have no any Product");

        }
    }

    @Override
    public void deleteProduct() {
        String productID;
        int index = -1;
        if (list.size() != 0) {
            productID = Validator.inputReg("Enter the productID: ", "\\d{3}", "The productID should be in form xxx (Ex:001)", false);
            for (int i = 0; i < list.size(); i++) {
                if (productID.equalsIgnoreCase(list.get(i).getProductID())) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.println("ProductID does not exist");

            } else {
                try {
                    list.remove(index);
                    System.out.println("Deleting Success");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Deleting Faild");
                }
            }

        } else {
            System.out.println("Have no any Product");
        }

    }

    public void updateProduct() {

        int choice;
        boolean loop;
        do {
            System.out.println("1. Update Information ");
            System.out.println("2. Delete Product");

            choice = Validator.getInt("Choosing: ", 2, false);
            switch (choice) {
                case 1:
                    loop = true;
                    do {
                        UpdateInfor();
                        String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);

                        if (call.equalsIgnoreCase("N")) {
                            continue;
                        } else {
                            loop = false;
                        }
                    } while (loop == true);
                    return;

                case 2:
                    loop = true;
                    do {
                        deleteProduct();
                        String call = Validator.inputReg("Do you want to go back to the main menu(Y/N): ", "[[YN][yn]]", "Please choose (Y/N)!!", false);

                        if (call.equalsIgnoreCase("N")) {
                            continue;
                        } else {
                            loop = false;
                        }
                    } while (loop == true);
                    return;
            }
        } while (choice < 0 || choice > 2);

    }

}
