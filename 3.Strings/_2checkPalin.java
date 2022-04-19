public class _2checkPalin {

    // https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        // String S1 = "vanilla";
        String S2 = "malayalam";

        System.out.println(checkPalindrome(S2));
    }

    private static boolean checkPalindrome(String S){
        if(S == null){
            return false;
        }
        if(S.length() == 1){
            return true;
        }
        if((S.length() == 2) || (S.length() == 3)){
            return (S.charAt(0) == S.charAt(S.length() - 1)) ? true : false;
        }

        int start = 0;
        int end = (S.length() - 1);

        while(start < end){
            if(S.charAt(start) != S.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
