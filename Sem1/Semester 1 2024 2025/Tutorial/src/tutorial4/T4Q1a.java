package tutorial4;

public class T4Q1a {
    public static void main(String[] args) {
        //a
        int n = 1;
        while (Math.pow(n, 3) < 2000){
            n++;
    }
        System.out.println("Largest integer n so that n^3 is less than 2000 is" 
        + " " + (n-1));
    }
    
}
