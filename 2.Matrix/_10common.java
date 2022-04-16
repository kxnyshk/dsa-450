// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _10common {

    // https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
    // TC : O(M*N)
    // SC : O(M)
    
    public static void main(String[] args) {
        
        int[][] M = {{1, 2, 1, 4, 8},
                     {3, 7, 8, 5, 1},
                     {8, 7, 7, 3, 1},
                     {8, 1, 2, 7, 9},};
        
        System.out.println(Arrays.toString(commonElements(M)));
    }

    private static int[] commonElements(int[][] M){
        HashMap<Integer, Integer> HM = new HashMap<Integer, Integer>();
        HashSet<Integer> HS = new HashSet<Integer>();

        if(M == null){
            return null;
        }

        for(int i=0; i<M[0].length; i++){
            HM.put(M[0][i], 1);
            // System.out.println("Map added " + M[0][i] + " -> " + HM.get(M[0][i]));
        }

        for(int i=1; i<M.length; i++){
            for(int j=0; j<M[0].length; j++){
                if((HM.get(M[i][j]) != null) && (HM.get(M[i][j]) == i)){
                    HM.put(M[i][j], (HM.get(M[i][j]) + 1));
                    // System.out.println("Map added " + M[i][j] + " -> " + HM.get(M[i][j]));
                }
                if((HM.get(M[i][j]) != null) && (HM.get(M[i][j]) >= M.length)){
                    HS.add(M[i][j]);
                    // System.out.println("Set added " + M[i][j] + " -> " + HM.get(M[i][j]));
                }
            }
        }
        
        // System.out.println(HM.toString());
        // System.out.println(HS.toString());

        int[] Arr = HS.stream().mapToInt(i -> i).toArray();
        return Arr;
    }
}
