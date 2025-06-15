/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan4;

import java.io.*;
import java.util.Arrays;
public class Q4 {
    public static void main(String[] args) {
        String fileName = "Q4.txt";
        Player player[] = new Player [100];
        int index = 0 ;

        try{
            BufferedReader reader = 
                    new BufferedReader(new FileReader(fileName));
            String line = "";
            while((line=reader.readLine())!=null){
            String parts[];
            parts = line.split("\\s+");
                if(parts.length == 7){
                    String nickname = parts[0];
                    double  score[] = new double [5];
                    for(int i=0;i<5;i++){
                        score[i] = Double.parseDouble(parts[i+1]);
                    }
                    double difficulty = Double.parseDouble(parts[6]);
                    player[index++] = new Player(nickname, score, difficulty);
                }
            }
            reader.close();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }
        catch (IOException e) {
            System.out.println("Error with file input.");
        }
        
        for(int i=0;i<index;i++){
            System.out.println(player[i].toString());
        }
        Arrays.sort(player, 0, index);
        
        System.out.println(player[3].nickname + " is the winner");
    }
}

class Player implements Comparable<Player>{
    String nickname;
    double score[] ;
    double difficulty;
    
    public Player(String nickname, double score[], double difficulty){
        this.nickname = nickname;
        this.score = new double [score.length];
        this.score = score;
        this.difficulty = difficulty;
    }
    
    public double  finalScore(){
        Arrays.sort(score);
        double finalScore = (score[1]+score[2]+score[3])*this.difficulty;
        return finalScore;
    }

    @Override
    public int compareTo(Player o) {
        return Double.compare(this.finalScore(), o.finalScore());
    }
    
    @Override
    public String toString(){
        return String.format("""
                             %s score %.2f
                             """, 
                this.nickname,this.finalScore());
    }
}
