/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Admin
 */
public interface DAO<product> {

    String pathFile();
    
    void print();

    void loadFile(String fname);

    void saveFile(String fname);

    void createProduct();

    void printFromFile(String fname);

    void checkExist(String fname);

    void searchProduct();

    void UpdateInfor();

    void deleteProduct();
    
}
