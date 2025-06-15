package tutorial4;

public class T4Q3 {
    public static void main(String[] args) {
        int n = 10 , firstNum = 0 , secondNum = 1 ;
        int nextNum;
        
        for ( int i = 1 ; i <= n ; i++) {
            System.out.println(firstNum);
            nextNum = firstNum + secondNum ; // 1
            firstNum = secondNum ; 
            secondNum = nextNum ; 
            
        }
    }
}
