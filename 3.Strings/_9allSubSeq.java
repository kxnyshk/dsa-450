import java.util.ArrayList;
import java.util.Collections;

public class _9allSubSeq {

    // https://www.geeksforgeeks.org/print-subsequences-string/
    // https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/
    // TC : O((2^N)*N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        String S = "abc";
        System.out.println(AllSubSequences(S).toString());
    }

    private static ArrayList<String> AllSubSequences(String S) {
        ArrayList<String> L = new ArrayList<String>();

        for(int i=0; i<(1 << S.length()); i++){
            String var = "";
            for(int j=0; j<S.length(); j++){
                if((i & (1 << j)) != 0){
                    var += S.charAt(j);
                }
            } if(var.length() > 0){
                L.add(var);
            }
        }

        Collections.sort(L);
        return L;
    }
}
