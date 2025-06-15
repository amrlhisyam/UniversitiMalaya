package tutorial4;

public class T4Q1e {
    public static void main(String[] args) {
        double sum = 0.0 ; 
        // a/b , a+1/b-1
        //e
        int k ;
        int b = 25 ; 
        for ( k = 1 ; k <= 25 ; k ++){
            sum += (double)k/(b);
            System.out.println(k + " / "  + b );
            b--;
        }
        System.out.printf("Sum of the series is %.2f \n" , sum);
    }
}


