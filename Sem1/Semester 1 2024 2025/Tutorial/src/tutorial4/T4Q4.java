package tutorial4;

import java.util.Scanner ;
public class T4Q4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = input.nextLine();
        
        int l = word.length();
        System.out.println("word length is : " + l);
        int i ; 
        
        // word.lenght is 6  , but i will loop until 0
        // if l-1 is not written then it will be out of bound
        for ( i = l-1 ; i >= 0  ; i --) { 
            System.out.print(word.charAt(i) + " ");
        }
        System.out.println("");
    }
}


