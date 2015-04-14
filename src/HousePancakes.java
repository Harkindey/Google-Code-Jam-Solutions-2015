
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saopayne
 */
public class HousePancakes {
    
    
    public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
     public static void main(String [] args){
       try {
           
            File file = new File("B-large.in");
            Scanner input = new Scanner(file);
            int numOfTestCases = Integer.parseInt(input.nextLine());
  
            File files = new File("pancakesmall.out");
            FileWriter writer = new FileWriter(files);
            for(int i = 1 ; i <= numOfTestCases; i++){
                int pa = input.nextInt();
                int [] P = new int[pa];
                for(int j = 0; j < pa; j++){
                    P[j] = input.nextInt();
                }
                int max = P[0];
                for (int counter = 1; counter < P.length; counter++)
                {
                     if (P[counter] > max)
                     {
                      max = P[counter];
                     }
                }
                int ans = max;
                int  Z = 2;
                
                /**
                 * For each plate of pancakes x, we count the number of times we need to split it 
                 * so that it'll have less than j pancakes. 
                 * The time to eat all the pancakes is the number of splits we make + the number of pancakes a person eats. 
                 * The number of splits needed for a single plate is (x-1)/j.
                 * Ex: If j = 6 and list = [13, 6, 18, 100], 
                 * then we'd need to split the stack of 13 pancakes into 3 portions (2 splits needed), 
                 * stack of 6 will remain (0 splits), stack of 18 into 3 portions (2 splits), 
                 * and stack of 100 into 17 portions (16 splits). 
                 * So the time needed to consume pancakes is 2 + 0 + 2 + 16 + j = 26.
                 */
                
                 while (Z < ans){
                    int SUM = 0;
                    for(int t = 0; t < P.length; t++){
                        SUM +=Math.floor((P[t]-1)/Z);                      
                    }
                    ans = Math.min(ans, (SUM)+Z);
                    Z += 1;
                 }
                 writer.write("Case #" + i + ": " + ans + "\n");
                
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StandingOvation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StandingOvation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
