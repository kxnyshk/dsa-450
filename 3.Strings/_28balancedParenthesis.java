public class _28balancedParenthesis {

    // https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1/
    // https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
    // TC : O(N)
    // SC : O(1)

    public static void main(String[] args) {
        
        String S = "[]]]][[][[";
        System.out.println(MinimumSwaps(S));
    }

    private static int MinimumSwaps(String S){
        if((S.length() % 2) != 0){
            return -1;
        }

        int open = 0;
        int close = 0;
        int unBalancedFactor = 0;
        int swaps = 0;

        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '['){
                open++;
                if(unBalancedFactor > 0){
                    swaps += unBalancedFactor;   
                    unBalancedFactor--;
                }
            } else if(S.charAt(i) == ']'){
                close++;
                unBalancedFactor = (close - open);
            }
        }

        return swaps;
    }
}