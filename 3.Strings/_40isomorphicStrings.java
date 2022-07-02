import java.util.HashMap;

public class _40isomorphicStrings {

    // https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1
    // https://leetcode.com/problems/isomorphic-strings/
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        
         String str1 = "PAPER";
        String str2 = "TITLE";
        System.out.println(checkIsomorphic(str1, str2));
    }

    private static boolean checkIsomorphic(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        HashMap<Character, Character> char2Char = new HashMap<>();
        HashMap<Character, Boolean> char2Bool = new HashMap<>();

        for(int i=0; i<str1.length(); i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if((char2Char.get(c1) == null) && (char2Bool.get(c2) == null)){
                char2Char.put(c1, c2);
                char2Bool.put(c2, true);
            } else if((char2Char.containsKey(c1)) && (c2 == char2Char.get(c1))){
                ;
            } else {
                return false;
            }
        }

        return true;
    }
}
