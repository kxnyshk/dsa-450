public class _8repeatSubSeq {

    // https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1/
    // modification of LCS (DP)
    // TC : O(N^2)
    // SC : O(N^2)

    public static void main(String[] args) {
        
        String str = "axxxy";

        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        System.out.println(longestRepeatingSubSeq(str, dp));
    }

    private static int longestRepeatingSubSeq(String str, int[][] dp){
       for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if((str.charAt(i-1) == str.charAt(j-1)) && (i != j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
