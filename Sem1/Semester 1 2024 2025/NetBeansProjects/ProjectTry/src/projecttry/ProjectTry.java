
package projecttry;
import java.util.Scanner;

public class ProjectTry {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String email;
        email = input.nextLine();
        System.out.println(email);
        int ed = email.indexOf('@');
        String emailType = email.substring(ed+1);
      
            
    }
    
}
