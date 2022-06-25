public class _29LcSubSeq {

    // https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
    // https://leetcode.com/problems/longest-common-subsequence/
    // TC : O(N^2)
    // SC : O(N^2)
    
    public static void main(String[] args) {
        
        String S1 = "ABCDGH";
        String S2 = "AEDFHR";

        System.out.println(LCS(S1, S2));
    }

    private static int LCS(String S1, String S2){
        int N = S1.length();
        int M = S2.length();

        int[][] T = new int[N+1][M+1];
        for(int i=0; i<N+1; i++){
            T[i][0] = 0;
        }
        for(int j=0; j<M+1; j++){
            T[0][j] = 0;
        }
        
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(S1.charAt(i-1) == S2.charAt(j-1)){
                    T[i][j] = 1 + T[i-1][j-1];
                } else{
                    T[i][j] = Math.max(T[i][j-1], T[i-1][j]);
                }
            }
        }

        return T[N][M];
    }
}
