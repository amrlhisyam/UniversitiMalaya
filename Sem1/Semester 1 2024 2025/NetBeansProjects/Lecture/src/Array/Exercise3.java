
package Array;

import java.util.Random ; 
public class Exercise3 {
    public static void main(String[] args) {
        Random r = new Random() ; 
        int size = 100 ; 
        char student[] = new char [size] ;
        char [] gender = {'F' , 'M' } ; 
        
        for (int i = 0 ; i < student.length ; i++) {
            student[i] = gender[r.nextInt(2)] ;
            System.out.print(student[i] + " ");
        }
        System.out.println();
        
        int countFemale = 0 ; 
        for ( int i = 0 ; i < student.length ; i++) {
            if (student[i] == 'F') {
                countFemale++ ; 
            }
        }
        System.out.println("Number of female students: " + countFemale);
        
    }
    
}
