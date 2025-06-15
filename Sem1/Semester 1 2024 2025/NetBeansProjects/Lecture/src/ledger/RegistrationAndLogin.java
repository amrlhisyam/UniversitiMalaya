package ledger;
import java.util.Scanner ; 
import java.util.regex.* ; 
import java.util.ArrayList;
public class RegistrationAndLogin {
    
    private static ArrayList<String> emailAddress = new ArrayList<>() ; 
    private static ArrayList<String> nameList = new ArrayList<>() ; 
    private static ArrayList<Integer> passCode = new ArrayList<>() ;
    public static void Login(){
        Scanner input = new Scanner(System.in) ;
        String email, password ; 
        System.out.println("== Please enter your email and password ==");
        System.out.print("Email: ");
        email = input.nextLine() ; 
        System.out.print("Password: ");
        password = input.nextLine() ; 
        
        boolean a = validEmail(email);
        boolean b = validPass(password);
        
        
        if (a){
            if(b){
                System.out.println("Login Successful");
            }
        }
        
        else {
            System.out.println("fail");
        }
        
}
    
    public static void Front(){
        Scanner input = new Scanner(System.in);
        int choice ; 
        System.out.println("== Ledger System ==");
        System.out.println("Login or Register: ");
        System.out.println("1.Login\n2.Register");
        choice = input.nextInt() ; 
        switch(choice){
            case 1 -> Login() ;
            case 2 -> Register() ;
        }
    }
    
    
    
    public static void Register() {
        String name, email, pass ;
        System.out.println("== Please fill in the form ==");
        Scanner input = new Scanner(System.in) ;
        System.out.print("Name: ");
        name = input.nextLine() ;
        System.out.print("Email: ");
        email = input.nextLine() ;
        System.out.print("Password: ");
        pass = input.nextLine() ; 
        validation(name,email,pass) ;
        store(name,email,pass) ;
    }
    
    public static void validation(String name, String email, String pass){
        String str = name ; 
        String ema = email ;
        String nameRegex = "^[a-zA-Z] &";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" ;
        String passRegex = "^[a-zA-Z0-9._@]{8,}&" ;
        if (str.matches(nameRegex) && (ema.matches(emailRegex)) && pass.matches(passRegex)){
            Front() ; 
        }
        else{
            System.out.println("Please enter the right information");
            Register() ;
        }
        
    }
    
    public static void store(String name, String email, String pass){
        int hashCode = pass.hashCode();
        nameList.add(name) ;
        emailAddress.add(email);
        passCode.add(hashCode) ;
    }
    
    public static boolean validEmail(String email){
        return emailAddress.contains(email);
    }
    
    public static boolean validPass (String pass){
        int hashCode = pass.hashCode();
        
        return passCode.contains(hashCode) ; 
    }
}
