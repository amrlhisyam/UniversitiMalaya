package hash;
import java.util.HashSet ;
import java.util.ArrayList ;
public class Hash {

    public static void main(String[] args) {
        String str = "Hello" ;
        int hashCode = str.hashCode();
        System.out.println(hashCode);
        
        HashSet<String> set = new HashSet<>() ;
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Kiwi");
        set.add("Apple");
        
        System.out.println(set);
        
        ArrayList<String> list = new ArrayList<> () ;
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Apple");
        
        System.out.println(list);
    }
    
    
    
}
