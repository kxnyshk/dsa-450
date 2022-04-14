public class _4max1s {

    // https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row3027/1/
    // TC : O(N*Log(M))
    // SC : O(1)

    public static void main(String[] args) {
        
        int[][] M = {{0, 0, 0, 1},
                     {0, 1, 1, 1},
                     {1, 1, 1, 1},
                     {0, 0, 0, 0},};

        int Max = MaxOnes(M);
        System.out.println(Max);
    }

    private static int MaxOnes(int[][] M){
        if(M == null){
            return -1;
        }

        int Num = Integer.MIN_VALUE;
        int Row = -1;

        for(int i=0; i<M.length; i++){
            int Temp = NumOfOnes(M, i);
            if(Temp > Num){
                Num = Temp;
                Row = i;
            }
        }

        return Row;
    }

    private static int NumOfOnes(int[][] M, int R){
        if((M == null) || (R < 0) || (R >= M.length)){
            return -1;
        }

        int start = 0;
        int end = (M[0].length - 1);
        int Idx = M[0].length;

        while(start <= end){
            int mid = ((start + end) / 2);
           
            if(M[R][mid] == 1){
                Idx = mid;
                end = (mid - 1);
            }
            else{
                start = (mid + 1);
            }
        }

        return M[0].length - Idx;
    }
}