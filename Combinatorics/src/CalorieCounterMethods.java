import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CalorieCounterMethods {
    
    public static int verifyIngredients(String typeLine, int dataType) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean correct = true;
        do{
            System.out.printf("%s", typeLine);
            
            try{        
                        typeLine = br.readLine();
                        dataType = Integer.parseInt(typeLine);
                        if ((dataType < 0 || dataType > 5)){
                           throw new Exception();
                         }
                        else if (dataType > 0 || dataType < 5){
                            correct = true;
                        }
                    }
                    catch(Exception e){
                         System.out.printf("%80s %n", "Error, entered value must be a positive integer between 0 and 5. Try again.");
                         correct = false;
                    }
        }while(!correct);
        return dataType;
        
        }
  public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scnr = new Scanner (System.in);
        
        String userName;    
        int numSandwich = 0;    
        String statementLine;   
        int numSliceBread = 0;
        String breadLine;
        boolean correct;
        System.out.printf("%50s %n", "Welcome to Calorie Counter.");
        System.out.println();
        
        System.out.printf("%-50s", "Please enter your name: ");
        userName = scnr.nextLine();
        
        do{
            try{
                System.out.printf("%-50s", "Please enter how many sandwiches you need: ");
                statementLine = br.readLine();
                numSandwich = Integer.parseInt(statementLine);
                
                
                if (numSandwich < 0){
                System.out.println();
                System.out.printf("%70s %n", "Error, entered value must be a positive integer. Try again.");
                System.out.println();
                correct = false;
                }
                else {
                    correct = true;
                }
                }
            catch (Exception e){
                System.out.println();
                System.out.printf("%70s %n", "Error, entered value must be a positive integer. Try again.");
                System.out.println();
                correct = false;
                 }
        }
        while (!correct);
      
        
        
        for (int i = 0; i < numSandwich; i++){
            System.out.println();
            System.out.println("Hi " + userName + ", Please enter number of ingredient for sandwich number " + (i+1));
            System.out.println();
            
           int totalSliceBread = verifyIngredients("Please enter number of slices of bread used (0 if not used and 5 is max):      ", numSliceBread);
           }
           }
}
