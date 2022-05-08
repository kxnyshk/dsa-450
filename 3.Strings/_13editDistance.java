public class _13editDistance{

    // https://practice.geeksforgeeks.org/problems/edit-distance3702/1/
    // https://leetcode.com/problems/edit-distance/description/
    // DP - Bottoms Up
    // TC : O(N^2)
    // SC : O(N^2)

    public static void main(String[] args) {
        
        String s = "sunday";
        String t = "saturday";

        System.out.println(MinimumSteps(s, t));
    }

    private static int MinimumSteps(String s, String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i=0; i<s.length() + 1; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<t.length() + 1; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<s.length() + 1; i++){
            for(int j=1; j<t.length() + 1; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}