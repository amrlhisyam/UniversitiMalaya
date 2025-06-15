
package Array;


public class LinearSearch {
    public static void main(String[] args) {
        int [] b = {29 , 10, 13, 37, 13} ; 
        int searchKey = 29 ; 
        
        boolean search = false ; 
        
        for (int cnt = 0 ; cnt < b.length ; cnt++) {
            if (b[cnt] == searchKey) {
                System.out.println("Found " + b[cnt] + " in position of " + cnt);
                search = true ; 
            }
            }
            if (search == false) {
                System.out.println("not found");
        }
    }
    
}
