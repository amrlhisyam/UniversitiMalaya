package tutorial4;

public class T4Q2 {
    public static void main(String[] args) {
        /*
        int x, sum = 0;
        
        for(x = 10; x > 0 ; x--)
            sum += x;
        
        int y = 0;
        */
        int x = 0 ; 
        int y = 0 ;
        
        
        
        do {
        x += 2 ;
        y += x ;
        System.out.println(x + " and " + y);
        }
        while (x < 100) ;
        /*
        
        int x, y;
        for ( x = 1 ,  y = 20 ; x < y ; x ++ , y -= 2 )
            System.out.println (x + " " + y);
            */
        
        int i ; 
        i = 1 ; 
        while (i < 10) {
            i++ ;
            if ( i == 10)
                System.out.println("Program End");
        }
        
        
        
    }
}
