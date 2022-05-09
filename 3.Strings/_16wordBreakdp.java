import java.util.ArrayList;

public class _16wordBreakdp {

    // https://practice.geeksforgeeks.org/problems/word-break1352/1
    // https://leetcode.com/problems/word-break/
    // TC : O(N^2)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        String A = "iiiilikesamsung";

        String[] C = {"mobile","samsung","sam","sung",
                    "man","mango","icecream","and",
                    "go","i","like","ice","cream"};

        ArrayList<String> B = new ArrayList<String>();
        for(int i=0; i<C.length; i++){
            B.add(C[i]);
        }

        System.out.println(WordBreak(A, B));
    }

    private static int WordBreak(String A, ArrayList<String> B){
        boolean[] dp = new boolean[A.length() + 1];
        dp[0] = true;

        for(int i=1; i<(A.length() + 1); i++){
            for(int j=0; j<i; j++){
                if((dp[j]) && B.contains(A.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        if(dp[A.length()]){
            return 1;
        } else { return 0; }
    }
}
