public class _37WildCard {

    // https://practice.geeksforgeeks.org/problems/wildcard-string-matching1126/1
    // https://leetcode.com/problems/wildcard-matching/
    // TC : O(N*M)
    // SC : O(N*M)
    
    public static void main(String[] args) {
        
        // String pattern = "ge*ks";
        String pattern = "ge?ks*";
        String string = "geeksforgeeks";
        System.out.println(WildCardMatch(pattern, string));
    }

    private static boolean WildCardMatch(String pattern, String string){
        boolean[][] dp = new boolean[pattern.length() + 1][string.length() + 1];
        int dpRowLength =  (dp.length - 1);
        int dpColLength = (dp[0].length - 1);

        for(int i=dpRowLength; i>=0; i--){
            for(int j=dpColLength; j>=0; j--){
                if((i == dpRowLength) && (j == dpColLength)){
                    dp[i][j] = true;
                } else if(i == dpRowLength){
                    dp[i][j] = false;
                } else if(j == dpColLength){
                    if(pattern.charAt(i) == '*'){
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char ch = pattern.charAt(i);
                    if((ch == '?') || (ch == string.charAt(j))){
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if(ch == '*'){
                        dp[i][j] = (dp[i + 1][j] || dp[i][j + 1]);
                    } else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[0][0];
    }
}
