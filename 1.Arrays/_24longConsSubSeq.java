import java.util.HashSet;
import java.util.Set;

public class _24longConsSubSeq {

    // https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1/
    // https://leetcode.com/problems/longest-consecutive-sequence/
    
    public static void main(String[] args) {
        
        int[] Arr = {1,9,3,10,4,20,2};

        int len = longSubSeq(Arr);
        System.out.println(len);
    }

    private static int longSubSeq(int[] Arr){
        Set<Integer> HS = new HashSet<Integer>();
        for(int i=0; i<Arr.length; i++){
            HS.add(Arr[i]);
        }

        int maxLen = 0;

        for(int i=0; i<Arr.length; i++){
            if(!HS.contains(Arr[i] - 1)){
                int currNum = Arr[i];
                int currLen = 1;

                while(HS.contains(currNum+1)){
                    currNum++;
                    currLen++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}
