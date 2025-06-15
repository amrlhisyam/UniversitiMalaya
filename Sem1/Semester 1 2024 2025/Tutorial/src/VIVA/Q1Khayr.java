
package VIVA;


import java.util.Scanner;

public class Q1Khayr {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Please enter the magic rune:"); // input magic rune (name)
      String rune = keyboard.nextLine();

      int duplicate;
      for(duplicate = 0; rune.length() >= 100; rune = keyboard.nextLine()) {
         System.out.println("The rune is too long! Please input a shorter rune."); // input validation where the input cannot be longer than 100
      }

      for(int a = 0; a < rune.length(); ++a) {
         char temp_a = rune.charAt(a); // asign the value of rune.charAt(a) to variable temp_a

         for(int b = a + 1; b < rune.length(); ++b) { // a+1 to compare between the first character and the character next to it
            char temp_b = rune.charAt(b); // assign value of rune.charAr(b) to temp_b
            if (temp_b == temp_a) { // compare between the current char to the next char
               ++duplicate; // if there is a common char duplicate is incremented
               break ;  // break to avoid counting for the same duplicate
            } // complete comparing the first character with all other character in the input           
         }
      }

      int distinct_runes = rune.length() - duplicate; // substract from the llength of input by duplicate // example amimu // length = 5 duplicate = 1 // distinct_runes = 4 // ally
      System.out.println("Distinct runes = " + distinct_runes);
      if (distinct_runes % 2 == 0) { // check for even or odd
         System.out.println("ALLY DETECTED!");
      } else {
         System.out.println("ENEMY ALERT");
      }

   }
}
