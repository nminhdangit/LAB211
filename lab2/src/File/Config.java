/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import File.Tool;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Config {
    
    private static final String ConfigFile = "config.txt";
    private String accountFile;
    private String dealerFile;
    private String deliveryFile;
    List<String> reader = new ArrayList<>();

    public Config() {
        readPath();
    }
    
    
    
    public void readPath(){
        String[] part = null;
        
        reader = Tool.readLineFromFile(ConfigFile);
        if(reader.isEmpty()){
            System.out.println("File empty.");
            return;
        }
        for(int i=0;i<reader.size();i++){
            part = reader.get(i).split(":");
            if(part[0].contains("account")){
                accountFile = part[1].trim(); 
            }else if(part[0].contains("dealer")){
                dealerFile = part[1].trim();
            }else if(part[0].contains("delivery")){
                deliveryFile = part[1].trim();
            }else{
                System.out.println("Not Found the path.");
                return;
            }
        }
                    
            
                    
                
        }
      
    

    public String getAccountFile() {
        return accountFile;
    }

    public String getDealerFile() {
        return dealerFile;
    }

    public String getDeliveryFile() {
        return deliveryFile;
    }   
}
