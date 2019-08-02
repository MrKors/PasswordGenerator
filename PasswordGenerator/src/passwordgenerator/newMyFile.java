
package passwordgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class newMyFile {
    
    File newfile;
    
    Date date = new Date();
    
    public File createNewFile(String fileName){
        File newFile = new File(fileName);
        newfile = newFile;
        try {
            newFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(newMyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return newfile;
    }
    public void  whriteToFile (File fileName, char[] dataToFile){
        try {
           FileWriter writeToFile = new FileWriter(fileName);
           writeToFile.write("Your password: " + String.valueOf(dataToFile) + Password.text);
           writeToFile.flush();
           writeToFile.close();
        }  
        catch (FileNotFoundException ex) {
            Logger.getLogger(newMyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(newMyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NullPointerException NPE){
            System.out.println("Exeption: Null Pointer value in method whriteToFile()! ");
            //NPE.printStackTrace();
        }
    }
    
    public void  whriteToFileForHistory (File fileName, char[]dataToFile){
        
        try {
            FileWriter writeToFile = new FileWriter(fileName, true);
            writeToFile.write("\r\n" + "* " + "Your password: " + String.valueOf(dataToFile) + Password.text + " - " + date);
            writeToFile.flush();
            writeToFile.close();
        }  
        catch (FileNotFoundException ex) {
            Logger.getLogger(newMyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(newMyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NullPointerException NPE){
            System.out.println("Exeption: Null Pointer value in method whriteToFile()! ");
            //NPE.printStackTrace();
        }
    }
    
    /*
    public List addPassToArrayList(char[]dataToColl){
        
        passCollection.add(String.valueOf(dataToColl) + Password.text + " - " + date);
    return passCollection;    
    }
    */
}
