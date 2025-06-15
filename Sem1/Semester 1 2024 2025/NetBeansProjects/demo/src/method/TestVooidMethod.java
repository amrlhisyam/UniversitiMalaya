
package method;



public class TestVooidMethod {
    public static void main(String[] args) {
        System.out.print("The grade is ");
        printGrade(78.5);
        System.out.print("The grade is ");
        printGrade(59.5);        
}
    
    // printGrade method does not return any value
public static void printGrade( double score){
    if(score >= 90.0){
        System.out.println('A');
    }
    if(score >= 80.0){
        System.out.println('B');
    }
    if(score >= 70.0){
        System.out.println('C');
    }
    if(score >= 60.0){
        System.out.println('D');
    }
    else{
        System.out.println('F');
    }
    }
}
