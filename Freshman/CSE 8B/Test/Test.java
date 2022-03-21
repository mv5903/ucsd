package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {  
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double voltageLevel;

      while (scnr.hasNext()) {
         try {
            voltageLevel = scnr.nextDouble();

            if (voltageLevel >= 3.2) {
               System.out.println("High");
            }
            else if (voltageLevel >= 0.0 && voltageLevel <= 2.1) {
               System.out.println("Low");
            }
            else {
               System.out.println("xx");
            }
         }
         catch (InputMismatchException excpt) {
            System.out.println("Caught InputMismatchException");
            scnr.next();
         }
      }
   }
}

