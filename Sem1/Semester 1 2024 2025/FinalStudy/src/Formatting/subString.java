
package Formatting;

/**
 *
 * @author Hisyam
 */
public class subString {
    public static void main(String[] args) {
        int index =-1;
        String str = "WaymondWong";
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i+1) >= 'A' && str.charAt(i+1) <='Z'){
                index = i ; 
            }
        }
        
        String a = str.substring(0, index+1);
        String b = str.substring(index+1, str.length());
        System.out.println(a);
        System.out.println(b);
        String c = a.concat(" " + b);
        System.out.println(c);
    }
}
