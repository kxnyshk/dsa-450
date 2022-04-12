import java.util.ArrayList;
import java.util.Collections;

public class _9 {
    
    public static void main(String[] args) {

        ArrayList<Long> a = new ArrayList<Long>();
        long n = a.size();
        long m = 1;
        System.out.println(check(a,m,n));
    }

    private static long check(ArrayList<Long> a, long m, long n) {
        long Min = Long.MAX_VALUE;
        
        Collections.sort(a);
        for(int i=0; (i+m-1)<n; i++){
            Min = Math.min((Long) (a.get((int) (i+m-1)) - (Long) a.get((int) i)), Min);
        }
        
        return Min;
    }
}
