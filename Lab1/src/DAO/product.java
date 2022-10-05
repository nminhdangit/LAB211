/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class product implements Serializable {
    private String productID;
    private String productName;
    private float unitPrice;
    private int Quantity;
    private String status;

    
    public product(){
        
    }
    
    public product(String productID, String productName, float unitPrice, int Quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.Quantity = Quantity;
        this.status = status;
    }
    
    
    
    
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ProductID: "+this.productID+", ProductName: "+this.productName+", UnitPrice: "+this.unitPrice+", Quantity: "+this.Quantity+", Status: "+this.status+"]"; //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
    
}
