package VIVA;

import java.util.Scanner ; 

public class Q5Hisyam {
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in) ; 
        String number  ;
        System.out.print("Enter [positive integer] : ");
        number = input.nextLine() ; 
        
        boolean isValid ;
        int counter = 1 ;
        int sumLengths = 1 ;
        int group = 1 ;
        int maxRepeat = 0 ;
        char longestChar = number.charAt(0) ; 
        
        do {
            isValid = Valid(number) ;
            if (!isValid) {
                System.out.println("Invalid Integer");
                System.out.print("Enter [positive integer]: ");
                number = input.nextLine() ;
            }
            else {
                for ( int i = 0 ; i < number.length() - 1 ; i ++) {
                    if ( number.charAt(i) == number.charAt( i + 1)) {
                        counter++ ; 
                    }
                    else {
                        if (counter > maxRepeat) {
                        maxRepeat = counter ;
                        longestChar = number.charAt(i) ;
                        }
                        group++ ; 
                        counter = 1 ;
                    }
                    sumLengths++ ;
                }
            }
        } while (!isValid) ;
        
        if (counter > maxRepeat) {
            maxRepeat = counter ; 
            longestChar = number.charAt(number.length() - 1) ;
        }
        
        System.out.println(group);
        System.out.println(longestChar + "  " + maxRepeat);
        System.out.println(sumLengths);
    }
    
    public static boolean Valid (String number02) {
        for ( int k = 0 ; k < number02.length() ; k++) {
            if ( number02.charAt(k) == '-' ) {
                return false ; 
            }
            else if ( number02.charAt(k) <'0' || number02.charAt(k) >'9') {
                return false ; 
            }
        } 
        return true ; 
    }
    
    
}
