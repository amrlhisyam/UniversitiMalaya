package tutorial6;

public class blackboxq6 {
    public static void main(String[] args) {
        int[] arrPalindromic = new int[20];
        int[] arrEmirp = new int[20];
        
        int palindromicCount = 0;
        int emirpCount = 0;
        
        for (int i = 1; palindromicCount < 20 || emirpCount < 20; i++) {
            if (palindromicPrime(i) && palindromicCount < 20) {
                arrPalindromic[palindromicCount++] = i;
            }
            if (emirp(i) && emirpCount < 20) {
                arrEmirp[emirpCount++] = i;
            }
        }
        
        System.out.println("First 20 Palindromic Primes are: ");
        for (int j = 0; j < palindromicCount; j++) {
            System.out.print(arrPalindromic[j] + " ");
        }
        System.out.println();
        
        System.out.println("First 20 Emirps are: ");
        for (int j = 0; j < emirpCount; j++) {
            System.out.print(arrEmirp[j] + " ");
        }
        System.out.println();
    }
    
    public static boolean palindromicPrime(int num) {
        return prime(num) && (num == reverse(num));
    }
    
    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10; 
            num = num / 10; 
        }
        return rev;
    }
    
    public static boolean prime(int num) {
        if (num <= 1) return false; // 0 and 1 are not prime numbers
        if (num == 2) return true; // 2 is the only even prime number
        if (num % 2 == 0) return false; // eliminate even numbers
        
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean emirp(int num) {
        int rev = reverse(num);
        return prime(num) && prime(rev) && num != rev;
    }
}