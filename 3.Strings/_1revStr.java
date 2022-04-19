public class _1revStr{

    // https://practice.geeksforgeeks.org/problems/reverse-a-string/1
    // https://practice.geeksforgeeks.org/problems/java-reverse-a-string0416/1
    // https://leetcode.com/problems/reverse-string/
    
    // TC : 0(N)
    // SC : O(1)

    public static void main(String[] args) {
        
        String S = "vanillasky";
        System.out.println(revString(S));
    }

    private static String revString(String S){
        if(S.length() <= 1){
            return S;
        }
        
        StringBuilder rev = new StringBuilder(S);
        int start = 0;
        int end = (S.length() - 1);

        while(start < end){
            rev.setCharAt(start, S.charAt(end));
            rev.setCharAt(end--, S.charAt(start++));
        }

        return rev.toString();
    }
}