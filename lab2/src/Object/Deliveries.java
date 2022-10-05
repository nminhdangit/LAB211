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
public class Deliveries {
    private String ID;
    private String product;
    private int quantity;
    private String address;
    private String phone;
    private float price;
    private boolean finish;

    public Deliveries(String ID, String product, int quantity, String address, String phone, float price,boolean finish) {
        this.ID = ID;
        this.product = product;
        this.quantity = quantity;
        this.address = address;
        this.phone = phone;
        this.price = price;
        this.finish = finish;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
                    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ID+","+product+","+quantity+","+address+","+phone+","+price+","+finish;
        }
    
    

    
    
    
    
    
    
        
}
