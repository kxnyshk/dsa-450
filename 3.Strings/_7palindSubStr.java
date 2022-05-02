public class _7palindSubStr {

    // https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
    // https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1/
    // https://leetcode.com/problems/longest-palindromic-substring/

    // TC : O(N^2)
    // SC : O(N^2)

    public static void main(String[] args) {
        
        // String S = "aaaabbaa";
        // String S = "rfkqyuqfjkxy";
        // String S = "fyfvladzpbfudkklrwq";
        String S = "ayaxzfbjbkrxiri";
        System.out.println(longestPalindromeSubstring(S));
    }

    private static String longestPalindromeSubstring(String S){
        int[][] dp = new int[S.length()][S.length()];
        
        int GI = -1;
        int GJ = -1;
        int diff = Integer.MIN_VALUE;

        for(int i=0; i<S.length(); i++){
           dp[i][i] = 1;
           GI = 0; GJ = 0;
        }
        for(int i=0; i<(S.length() - 1); i++){
            if(S.charAt(i) == S.charAt((i + 1))){
                dp[i][(i + 1)] = 1;
                if(((i + 1) - i) > diff){
                    diff = ((i + 1) - i);
                    GI = i;
                    GJ = (i + 1);
                }
            } else{ dp[i][(i + 1)] = 0; }
        }

        for(int k=3; k<=S.length(); k++){
            for(int i=0; i<=(S.length() - k); i++){
                int j = (i + k - 1);
                if((S.charAt(i) == S.charAt(j)) && (dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    if((j - i) > diff){
                        // System.out.println(S.substring(i, (j + 1)));
                        diff = (j - i);
                        GI = i;
                        GJ = j;
                    }
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        // printdp(dp);
        return S.substring(GI, (GJ + 1));
    }

    // private static void printdp(int[][] dp){
    //     for(int i=0; i<dp.length; i++){
    //         for(int j=0; j<dp[0].length; j++){
    //             System.out.print(dp[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}
