public class _36removeDuplicateLeetCode {

    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(RemoveAdjacent(s));
    }

    private static String RemoveAdjacent(String s) {
        char[] stack = new char[s.length()];
        int stackPtr = 0;
        
        for(int j=0; j<s.length(); j++){
            char curr = s.charAt(j);
            if((stackPtr > 0) && (curr == stack[stackPtr - 1])){
                stackPtr--;
            } else {
                stack[stackPtr++] = curr;
            }
        }
        
        return new String(stack, 0, stackPtr);
    }
}
