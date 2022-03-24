import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _14mergeInterval{

    // https://leetcode.com/problems/merge-intervals/
    // https://www.geeksforgeeks.org/merging-intervals/

    public static void main(String[] args) {
        
        int[][] Arr = {{1,3},{2,6},{8,10},{15,18}};
        
        int[][] merge = mergeIntervals(Arr);
        System.out.println(Arrays.deepToString(merge));
    }

    private static int[][] mergeIntervals(int[][] Arr){
        if(Arr.length <= 1){
            return Arr;
        }

        List<int[]> L = new ArrayList<int[]>();
        Arrays.sort(Arr, (a, b) -> Integer.compare(a[0], b[0]));
        // System.out.println(Arrays.deepToString(Arr));
 
        int[] curr = Arr[0];

        for(int i=1; i<Arr.length; i++){
            if(curr[1] >= Arr[i][0]){
                curr[1] = Math.max(curr[1], Arr[i][1]);
            }
            else{                
                L.add(curr);
                curr = Arr[i];
            }
        }
        
        L.add(curr);
        return L.toArray(new int[L.size()][]);
    }
}