import java.util.ArrayList;
import java.util.Arrays;

public class _1Spiral{

    // https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1/
    // https://leetcode.com/problems/spiral-matrix/
    // TC : O(N*M)
    // SC : O(N*M)

    public static void main(String[] args) {
        
        int[][] M1 = {{1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
                      {13, 14, 15,16}};
        // int[][] M2 = {{1, 2, 3, 4},
        //               {5, 6, 7, 8},
        //               {9, 10, 11, 12}};

        ArrayList<Integer> L = new ArrayList<Integer>();
        L = spiralTraversal(M1);
        System.out.println(Arrays.toString(L.toArray()));
    }

    private static ArrayList<Integer> spiralTraversal(int[][] M){
        ArrayList<Integer> L = new ArrayList<Integer>();
        if(M == null){
            return L;
        }

        int up = 0;
        int down = (M.length - 1);
        int left = 0;
        int right = (M[0].length - 1);
        int dir = 0;

        while((up <= down) && (left <= right)){
            if(dir == 0){
                for(int i=left; i<=right; i++){
                    L.add(M[up][i]);
                }
                up++;
            }
            else if(dir == 1){
                for(int i=up; i<=down; i++){
                    L.add(M[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                for(int i=right; i>=left; i--){
                    L.add(M[down][i]);
                }
                down--;
            }
            else if(dir == 3){
                for(int i=down; i>=up; i--){
                    L.add(M[i][left]);
                }
                left++;
            }

            dir = ((dir + 1) % 4);
        }

        return L;
    }
}