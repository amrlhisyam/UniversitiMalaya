
package tutorial4;
import java.util.Scanner ;
public class L4Q4v2 {
    
    public static void main(String[] args) {
        int day, year;
        int MIN=5, MAX=8;
        Scanner k = new Scanner(System.in);
        System.out.print("Enter year : ");
        year = k.nextInt();
        System.out.print("Enter day : [0- Sunday, 1-Monday, ...] ");
        day = k.nextInt();
        for(int i=1; i<=MAX; i++) {
            if (i==MIN) {
                System.out.println("May " + year);
                System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat  ");
                for (int d=0; d<day; d++)
                    System.out.printf("     ");
                for(int j=1; j<=31; j++) {
                    System.out.printf("%-5d", j);
                    day++;
                    day%=7;
                    if (day==0)
                        System.out.println("");
                }
            }
            else if (i==MAX) {
                System.out.println("\n\n");
                System.out.println("August " + year);
                System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat  ");
                for (int d=0; d<day; d++)
                    System.out.printf("     ");
                for(int j=1; j<=31; j++) {
                    System.out.printf("%-5d", j);
                    day++;
                    day%=7;
                    if (day==0)
                        System.out.println("");
                }
                System.out.println("");
            }
            else if (i==2) {
                if (isLeap(year))
                    day = (day+29)%7;
                else
                    day = (day+28)%7;
            }
            else if (i==4 || i==6) {
                day = (day+30)%7;
            }
            else {
                day = (day+31)%7;
            }
        }
    }
    public static boolean isLeap(int y) {
        if (y%400==0 || (y%4==0 && y%100!=0) )
            return true;
        else
            return false;
    }
}

