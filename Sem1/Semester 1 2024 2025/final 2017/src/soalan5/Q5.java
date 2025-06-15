/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan5;
import java.util.Scanner;
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double g, s, l, c ;
        System.out.print("Enter the marks for Grammar(maximum 30 marks): ");
        g = sc.nextDouble();
        System.out.print("Enter the marks for Spelling(maximum 20 marks): ");
        s = sc.nextDouble();
        System.out.print("Enter the marks for Length(maximum 20 marks): ");
        l = sc.nextDouble();
        System.out.print("Enter the marks for Content(maximum 30 marks): ");
        c = sc.nextDouble();
        
        Essay essay = new Essay(g,s,l,c);
        System.out.println(essay.toString());
    }
    
}



class GradedActivity{
    double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    public char getGrade(){
        char grade = '-';
        if(this.getScore() >= 90 && this.getScore() <=100){
            grade = 'A';
        }
        else if(this.getScore() >= 80)
            grade = 'B';
        else if(this.getScore() >= 70)
            grade = 'C';
        else if(this.getScore() >= 60)
            grade = 'D';
        else if(this.getScore() < 60 && this.getScore() >= 0)
            grade = 'F';
        return grade;
    }
    
    @Override
    public String toString(){
        String str = String.format("""
                                   Total score: %.2f
                                   Essay grade: %s
                                   """, 
                this.getScore(),this.getGrade());
        
        return str;
    }
}

class Essay extends GradedActivity{
    double grammar, spelling, length, content;

    public Essay(double grammar, double spelling, double length, double content) {
        this.grammar = grammar;
        this.spelling = spelling;
        this.length = length;
        this.content = content;
    }
    
    
    public double getTotalScore(){
        double totalScore = -1;
        totalScore = this.grammar + this.content + this.length + this.spelling;
        this.setScore(totalScore);
        return totalScore;
    }
    
    @Override
    public String toString(){
        String str = String.format("""
                                   
                                   Essay Score:
                                   Grammar: %.0f
                                   Spelling: %.0f
                                   Length: %.0f
                                   Content: %.0f
                                   
                                   Total score: %.2f
                                   Essay Grade: %s
                                   """, 
                this.grammar,this.spelling,this.length,this.content, this.getTotalScore(), this.getGrade());
        return str;
    }
}