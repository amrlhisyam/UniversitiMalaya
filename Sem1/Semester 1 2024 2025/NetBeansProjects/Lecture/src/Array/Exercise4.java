// split string
package Array;


public class Exercise4 {
    public static void main(String[] args) {
        String str  = "Ang;Tun;Fong;Ahmad;Ali" ; 
        String [] info = str.split(";") ; 
        for(String value: info) {
            System.out.println(value);
        }
    }
}
