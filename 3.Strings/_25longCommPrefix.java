import java.util.Arrays;

public class _25longCommPrefix {

    // https://leetcode.com/problems/longest-common-prefix/
    // TC : O(Len(Min(Arr)) * Len(Arr)) -> O(N*M)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        String[] strs = {"flower", "flow", "flight"};
        // String Output = "fl";

        System.out.println(LongestCommonPrefix(strs));
    }

    private static String LongestCommonPrefix(String[] strs){
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }

        Arrays.sort(strs, (a, b)->Integer.compare(a.length(), b.length()));
        // debug-1
        // System.out.println(Arrays.toString(strs));

        int endIdx = 1;
        String prefix = "";

        while(endIdx <= strs[0].length()){
            // debug-2
            // System.out.println("enter while-1");
            int i=1;
            boolean flag = true;
            String tempPrefix = strs[0].substring(0, endIdx);
            // debug-2.5
            // System.out.println(tempPrefix + "/");

            while(i < strs.length){
                // debug-3
                // System.out.println("enter while-2");
                // System.out.println(strs[i++].substring(0, endIdx) + "/");
                String tempSubstr = strs[i].substring(0, endIdx);
                if(tempPrefix.equals(tempSubstr)){
                    // debug-4
                    // System.out.println("enter if");
                    // System.out.println(i);
                    i++;
                    continue;
                } else {
                    // debug-5
                    // System.out.println("enter else");
                    flag = false;
                    break;
                }
            }

            if(!flag){
                return prefix;
            }
            endIdx++;
            prefix = tempPrefix;
        }

        return prefix;
    }
}
