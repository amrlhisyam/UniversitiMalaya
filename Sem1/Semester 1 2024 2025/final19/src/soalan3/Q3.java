package soalan3;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String genome;
        String startGene = "ATG";
        String[] endGene = {"TAG", "TAA", "TGA"};
        boolean quit = false;
        
        while(!quit){
            System.out.println("Enter genome string [quit to stop]");
            genome = sc.nextLine();
            if(genome.equalsIgnoreCase("quit")){
                break;
            }

        int startIndex = 0;

        while (startIndex <= genome.length() && (startIndex = genome.indexOf(startGene, startIndex)) != -1) {
            // Find the nearest stop codon after the start codon
            int nearestStopIndex = -1;
            for (String stopCodon : endGene) {
                int stopIndex = genome.indexOf(stopCodon, startIndex);
                if (stopIndex != -1 && (nearestStopIndex == -1 || stopIndex < nearestStopIndex)) {
                    nearestStopIndex = stopIndex; // Update nearest stop codon
                }
            }

            // If a stop codon is found, extract the gene sequence
            if (nearestStopIndex != -1) {
                String gene = genome.substring(startIndex+3, nearestStopIndex); // Include the stop codon
                if (gene.length()%3 == 0 && !gene.equals(startGene)&& !gene.equals(endGene[0])
                        && !gene.equals(endGene[1])&& !gene.equals(endGene[2]) && !gene.isEmpty() ) {
                    System.out.println("Extracted gene: " + gene);
                }
                else{
                    System.out.println("Gene not Found");
                }
            }

            // Move to the next start codon
            startIndex += 3; // Move past the current start codon
            }
        }
    }
}