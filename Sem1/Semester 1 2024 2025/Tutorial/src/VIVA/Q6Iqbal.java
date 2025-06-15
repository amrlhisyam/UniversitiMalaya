
package VIVA;


public class Q6Iqbal {


    public static void main(String[] args) {
        for (int row = 0; row < 7; row++) {
            //M
            for (int col = 0; col < 7; col++) {
                if (col == 0 || col == 6 || (row == col && col <= 3) || (row + col == 6 && col >= 3)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  "); 

            //A
            for (int col = 0; col < 7; col++) {
                if (col == 0 || col == 6 || row == 3 || row == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");

            //L
            for (int col = 0; col < 7; col++) {
                if (col == 0 || row == 6) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");

            //A 
            for (int col = 0; col < 7; col++) {
                if (col == 0 || col == 6 || row == 3 || row == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");

            //Y
            for (int col = 0; col < 7; col++) {
                if ((col == row && col < 4) || (col + row == 6 && col >= 3)||(col == 3 && row > 3)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");

            //S
            for (int col = 0; col < 7; col++) {
                if (row == 0 || row == 3 || row == 6 || (col == 0 && row < 4) || (col == 6 && row > 3)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");

            //I
            for (int col = 0; col < 7; col++) {
                if (col == 3 || row == 0 || row == 6) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");

            //A
            for (int col = 0; col < 7; col++) {
                if (col == 0 || col == 6 || row == 3 || row == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); 
        }
    }
    
}

    

