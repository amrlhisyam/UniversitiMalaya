package tutorial5;

import java.util.Random;

public class L5Q2 {
    public static void main(String[] args) {
        Random r = new Random();
        final int MAX = 20;
        int size = 10;
        int arr[] = new int[size];
        int random;
        int count = 0; 

        while (count < size) {
            random = r.nextInt(MAX + 1);
            boolean isUnique = true; 
            
            for (int i = 0; i < count; i++) {
                if (random == arr[i]) {
                    isUnique = false; 
                    break;
                }
            }

            if (isUnique) {
                arr[count] = random;
                count++; 
            }
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}