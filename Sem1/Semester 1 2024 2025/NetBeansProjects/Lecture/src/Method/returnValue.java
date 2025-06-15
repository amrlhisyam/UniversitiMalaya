
package Method;


public class returnValue {
    public static void main(String[] args) {
        int answer ; 
        answer = square(9) ; 
        System.out.println(answer);
    }
  
    public static int square(int num) {
        return num*num*num*num ;
    }
}
