
package Array;

public class Lecture {

    public static void main(String[] args) {
        
        int [] number = { 1 , 2, 3, 4,5, 6 } ;
        String [] name = { "one" , " two" , " three" } ;
        
        System.out.println(number.length); // knowing length of the array
        
        for (int i = 0 ; i < name.length ; i++) { // iteration to output each value in array
            System.out.println(name[i]);
        }
        
        for (int value:number){
            System.out.println(value);
        }
    }
    
}
