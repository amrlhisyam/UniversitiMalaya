package labq6;

public class Burger {
    String burgerId;
    int burgerSold;
    static int totalBurgerSold; 
    
    public Burger(String burgerId) {
        this.burgerId = burgerId;
        this.burgerSold = 0;
    }
    
    public void sold(int burgerSold) {
        this.burgerSold += burgerSold;
        totalBurgerSold += burgerSold; 
    }
    
    public int totalSold() {
        return burgerSold; 
    }
    
    public static int getTotalBurgerSold() {
        return totalBurgerSold; 
    }
}

class Tester {
    public static void main(String[] args) {
        Burger stallOne = new Burger("McDonald");
        Burger stallTwo = new Burger("PizzaBurger");
        Burger stallThree = new Burger("BurgerKing");
        
        stallOne.sold(11);
        stallTwo.sold(8);
        stallThree.sold(7);
        
        System.out.println(stallOne.burgerId + " sold: " + stallOne.totalSold());
        System.out.println(stallTwo.burgerId + " sold: " + stallTwo.totalSold());
        System.out.println(stallThree.burgerId + " sold: " + stallThree.totalSold());
        
        System.out.println("Total burgers sold across all stalls: " + Burger.getTotalBurgerSold());
    }
}