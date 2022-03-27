import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _7 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> L = new ArrayList<Integer>();
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);

        Collections.reverse(L);
        System.out.println(Arrays.toString(L.toArray()));
    }
}
