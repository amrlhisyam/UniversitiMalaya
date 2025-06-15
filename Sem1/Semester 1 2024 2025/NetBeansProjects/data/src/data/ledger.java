package data;

import java.util.regex.* ; 
import java.util.* ;
public class ledger {
    
    public static void register(){
        String name, email, password ;
        Scanner sc = new Scanner(System.in) ; 
        System.out.print("Name: ");
        name = sc.nextLine() ; 
        System.out.print("Email: ");
        email = sc.nextLine() ; 
        System.out.print("password: ");
        password = sc.nextLine() ; 
    }
    
    
    
    
    
    public static boolean NameValid (String name){
        for (int i=0 ; i<name.length() ; i++){
            if(!Character.isLetter(i)){
                return  false;
            }
            break ;
        }
        return true ; 
    }
    
    
    public static boolean emailValid (String email){
        Pattern EmailReg = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$") ;
        Matcher matcher = EmailReg.matcher(email);
        if(matcher.find()){
            return true ;
        }
        else 
            return false ; 
    }
    
    public static boolean passwordValid(String password){
        if(password.length() < 8)
            return false ; 
        else
            return true  ;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ; 
        
    }
}
