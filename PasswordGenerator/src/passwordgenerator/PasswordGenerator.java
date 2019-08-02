package passwordgenerator;

public class PasswordGenerator {
    

    public static void main(String[] args) {
            newMyFile newMyFile = new newMyFile();
            Password password = new Password();
            password.choosePasswordType();
            password.determinePasswordComplexity();
            password.showPasswordStrength();
            
            newMyFile.createNewFile("pass.txt");
            newMyFile.whriteToFile(newMyFile.newfile, password.arrPassword);
                        
            newMyFile.createNewFile("PassHistory.txt");
            newMyFile.whriteToFileForHistory(newMyFile.newfile, password.arrPassword);
            
            
    }   
}
