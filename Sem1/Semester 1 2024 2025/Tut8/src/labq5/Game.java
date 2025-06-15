package labq5;
import java.util.Random;

public class Game {
    String name;
    int dice;
    int score = 0;
    
    public Game(String name) {
        this.name = name;
    }
    
    public void rollDice() {
        Random r = new Random();
        dice = r.nextInt(6)+1; 
        score += dice;
    }
    
    public int totalScore() {
        return score; 
    }
}

class Tester {
    public static void main(String[] args) {
        Game player1 = new Game("Hisyam");
        Game player2 = new Game("Amirul");
        
        while (player1.totalScore() < 100 && player2.totalScore() < 100) {
            player1.rollDice();
            player2.rollDice();
            System.out.println(player1.name + " rolled: " + player1.dice + ", Total Score: " + player1.totalScore());
            System.out.println(player2.name + " rolled: " + player2.dice + ", Total Score: " + player2.totalScore());
        }
        
        if (player1.totalScore() >= 100) {
            System.out.println(player1.name + " wins with a score of " + player1.totalScore() + "!");
        } else {
            System.out.println(player2.name + " wins with a score of " + player2.totalScore() + "!");
        }
    }
}