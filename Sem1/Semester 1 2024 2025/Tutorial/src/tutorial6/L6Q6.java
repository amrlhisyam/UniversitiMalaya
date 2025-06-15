package tutorial6;

public class L6Q6 {
    public static void main(String[] args) {
        int arrPalindromic[] = new int [20] ;
        int arrEmirp[] = new int [20] ;
        
        for (int n = 0, i = 1 ; n < 20 ; i++){
            if(palindromicPrime(i)){
                arrPalindromic[n] = i ;
                n++;
            }
        }
        
        for(int n = 0, i = 1 ; n < 20 ; i++){
            if(emirp(i)){
                arrEmirp[n] = i ;
                n++;
            }
        }
        
        System.out.println("First 20 Palindromic Prime is: ");
        print(arrPalindromic) ;
        
        System.out.println("First 20 Emirp is: ");
        print(arrEmirp);
    }
    
    public static boolean palindromicPrime(int num){
        int rev = reverse(num) ;
    
        return ( prime(num) && (num == rev)) ;
    }
    
    public static int reverse(int num){
        int rev = 0;
        while(num != 0){
            rev = rev*10 + num%10 ; 
            num = num/10 ; 
        }
        return rev ;
    }
    
    public static boolean prime(int num){
        int counterPrime = 0 ;
        for (int i = 1 ; i <= num ; i++){
            if (num % i == 0){
                counterPrime++ ;
            }
        }
        return counterPrime == 2;
    }
    
    
    public static boolean emirp(int num){
        int rev = reverse(num);
        return (prime(num) && prime(rev) && !palindromicPrime(num));
    }
    
    public static void print(int arr[]){
        for (int j = 0 ; j < arr.length ; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
    
}
