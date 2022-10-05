package Object;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Admin
 */
public class Dealer {
    private String ID;
    private String name;
    private String address;
    private String phone;
    private boolean continuing;

    public Dealer(String ID, String name, String address, String phone, boolean continuing) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.continuing = continuing;
    }

    
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isContinuing() {
        return continuing;
    }

    public void setContinuing(boolean continuing) {
        this.continuing = continuing;
    }

    @Override
    public String toString() {
        return ID+","+name+","+address+","+phone+","+continuing;
    }

    
    
    
    
    
    
    
    
}
