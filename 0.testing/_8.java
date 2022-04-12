import java.util.HashMap;

public class _8 {
    
    public static void main(String[] args) {
        
        int[] a1 = new int[1];
        int[] a2 = new int[1];
        System.out.println(check(a1, a2, 1, 2));
    }

    private static String check(int[] a1, int[] a2, int n, int m){
        HashMap<Long, Long> HM = new HashMap<Long, Long>();
        
        for(int i=0; i<n; i++){
            HM.put((long) a1[i], (long) 1);
        }
        
        for(int i=0; i<m; i++){
            if(!HM.containsKey(a2[i])){
                return "No";
            }
        }
        
        return "Yes";
    }
}
