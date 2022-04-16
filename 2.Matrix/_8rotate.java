import java.util.Arrays;

public class _8rotate {

    // https://practice.geeksforgeeks.org/problems/rotate-a-2d-array-without-using-extra-space1004/1
    // https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1
    // https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
    // https://leetcode.com/problems/rotate-image/
    // TC : O(N*M) -> O(N^2) (for sqr. matrix)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[][] M = {{1,2,3},
                     {4,5,6},
                     {7,8,9},};
        char R1 = 'C';        // for clockwise rotation
        // char R2 = 'A';        // for anti clockwise rotation

        rotate(M, R1);
        System.out.println(Arrays.deepToString(M));
    }

    private static void rotate(int[][] M, char R){
        if(M == null){
            return;
        }

        if(R == 'C'){
            clockTrans(M);
        }
        else if(R == 'A'){
            antiClockTrans(M);
        }
        else{
            return;
        }

        // System.out.println(Arrays.deepToString(M));
        reverse(M);
    }

    private static void clockTrans(int[][] M){
        if(M == null){
            return;
        }

        for(int i=0; i<M.length; i++){
            for(int j=i; j<M[0].length; j++){
                int temp = M[i][j];
                M[i][j] = M[j][i];
                M[j][i] = temp;
            }
        }
    }

    private static void antiClockTrans(int[][] M){
        if(M == null){
            return;
        }

        for(int i=0; i<M.length; i++){
            for(int j=(M[0].length - 1 - i); j>=0; j--){
                int temp = M[i][j];
                M[i][j] = M[M[0].length - j - 1][M[0].length - i - 1];
                M[M[0].length - j - 1][M[0].length - i - 1] = temp;
            }
        }
    }

    private static void reverse(int[][] M){
        if(M == null){
            return;
        }

        for(int i=0; i<M.length; i++){
            int start = 0;
            int end = (M[0].length - 1);
            while(start < end){
                int temp = M[i][start];
                M[i][start++] = M[i][end];
                M[i][end--] = temp;
            }
        }
    }
}
