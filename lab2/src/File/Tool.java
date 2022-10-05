/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Tool {

    public static List<String> readLineFromFile(String file) {       
        List<String> reader = new ArrayList(); 
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                reader.add(line);
            }
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
              System.out.println(file+" not exist.");
              System.exit(0);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Faild.");
        }
        
        return reader;
    }

    public static void SaveToFile(String fname, List list) {
        try {
            FileWriter fw = new FileWriter(fname);
            BufferedWriter bw = new BufferedWriter(fw);
            StringBuilder sb = new StringBuilder();
            for (Object x : list) {
                sb.append(x+"\n");
            }
            String text = sb.toString();
            bw.write(text);
            System.out.println("Saving Successful");
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Save Faild.");
            e.printStackTrace();
        }
    }

}
