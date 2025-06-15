package tutorial3;

public class T3Q4 {
    public static void main(String[] args) {
        int num1 = 1, num2 = 1 , num3 = 100;
        
        if(num1 > num2 && num1 > num3)
            System.out.println("Num1 is biggest");
        else if(num2 > num1 && num2 > num3)
            System.out.println("Num2 is biggest");
        else if(num3 > num1 && num3 > num2)
            System.out.println("Num3 is biggest");
        else 
            System.out.println("All number same");
    }
  
}
