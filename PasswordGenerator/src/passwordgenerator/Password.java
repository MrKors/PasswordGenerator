package passwordgenerator;
import java.util.*;

public class Password {
    String lettersUpperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
    String lettersLowerCase = "qwertyuiopasdfghjklzxcvbnm";
    String nums = "1234567890";
    String symbols = "!@#$%^&*)(_-=+";
    String mixeSymbs = lettersUpperCase + lettersLowerCase + nums + symbols;    String result;    
    int passwordLength;
    int count = 0;
    char[] arrPassword;
    static String text = "";
    
    Scanner scanner = new Scanner(System.in);
    
    public char[] getArray(String str){
        char[] array= new char [str.length()];
                
        for(int i=0;i < array.length; i++){
            array[i] = str.charAt(i);
            //System.out.print(array[i]+", ");
        }
        //System.out.println();
    return array;
    }
    
    public char[] getPassword(String str) throws InputMismatchException, NegativeArraySizeException{
               
        System.out.print("Set password length: ");
       
        try{
            if(scanner.hasNext()){
                passwordLength = scanner.nextInt();
                arrPassword = new char[passwordLength];


                for(int i = 0; i < arrPassword.length; i++){
                    arrPassword[i] = str.charAt(new Random().nextInt(str.length()));
                }

                System.out.print("Your password: ");
                System.out.print(arrPassword);
                scanner.close();
            }
            else
                System.out.println("Please enter a correct NUMBER!");
            scanner.close();
        }
        catch(InputMismatchException IME){
            System.out.println("You entered an invalid number. Try again!");
            //IME.printStackTrace();
            //getPassword(str);
        }
        catch(NegativeArraySizeException NASE){
            System.out.println("You entered a negative number. Try again!");
            //NASE.printStackTrace();
            //getPassword(str);
        }
        
    return arrPassword;
    }
    
   
    public void choosePasswordType() throws NullPointerException{
        System.out.println("Choose password type, entered a number from 1 to 5\n1-Letters Upper Case password\n2-Letters Lower Case password\n3-Password from numbers\n4-Password of characters\n5-Mixed password");
        try{
            if(scanner.hasNext()){
                switch(scanner.nextInt()){
                    case 1: 
                        System.out.println("Letters Upper Case password");
                        getPassword(lettersUpperCase);
                        break;
                    case 2: 
                        System.out.println("Letters Lower Case password");
                        getPassword(lettersLowerCase);
                        break;
                    case 3:
                        System.out.println("Password from numbers");
                        getPassword(nums);
                        break;
                    case 4:
                        System.out.println("Password of characters");
                        getPassword(symbols);
                        break;
                    case 5:
                        System.out.println("Mixed password");
                        getPassword(mixeSymbs);
                        break;
                    default:
                        System.out.println("You enterd an invalid number, please look at the expression in brackets!");
                        choosePasswordType();
                }
            }
            else
                System.out.println("Please enter a NUMBER!");
            scanner.close();
        }
        catch(InputMismatchException IME){
            System.out.println("You entered an invalid number. Try again!");
            //IME.printStackTrace();
        }
    }
    
    public int determinePasswordComplexity() throws NullPointerException{
                
        String[] strArray = {lettersUpperCase,lettersLowerCase,nums,symbols};
        try {
            ou:for (String strArray1 : strArray) {
                for (int j = 0; j < arrPassword.length; j++) {
                    for (int k = 0; k < getArray(strArray1).length; k++) {
                        if (arrPassword[j] == getArray(strArray1)[k]) {
                            count++;
                            //System.out.println("Find " + i +" "+ j +" "+ k);
                            continue ou;
                        }
                    }
                }
            }
        }
        catch (NullPointerException NPE){
            System.out.println("Exeption: Null Pointer value in method determinePasswordComplexity()! ");
        }
        
    return count;
    }
    public String showPasswordStrength () throws NullPointerException{
        try{
            if((arrPassword.length < 8 && count < 2)||(arrPassword.length > 8 && count == 1)){
                text = " - easy password";
                System.out.println (text);
            }
            else if((arrPassword.length <= 8 && count > 1 && count < 4)||(arrPassword.length > 8 && count > 1 && count < 4)){
                text = " - medium password";
                System.out.println (text);
            }
            else if(arrPassword.length > 8 && count > 3){
                text = " - strong password";
                System.out.println (text);
            }
            else{ 
                text = " - easy password";
                System.out.println (text);
            }
        }
        catch (NullPointerException NPE){
            System.out.println("Exeption: Null Pointer value in method showPasswordStrength()! ");
            //NPE.printStackTrace();
        }
    return text;
    }
}
