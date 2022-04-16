public class _9kthSmall {

    // https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1/
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    // TC : O(Range*(Nlog(M))) 
    // where Range -> (M[M.length-1][M[0].length -1] - M[0][0])
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[][] M = {{10,20,30,40},
                     {15,25,35,45},
                     {25,29,37,48},
                     {32,33,39,50},};
        int K = 7;

        int E = kthSmallest(M, K);
        System.out.println(E);
    }

    private static int kthSmallest(int[][] M, int K){
        if((M == null) || (K <= 0)){
            return -1;
        }
        if((M.length == 1) && (M[0].length == 1) && (K == 1)){
            return M[0][0];
        }

        int start = M[0][0];
        int end = M[M.length - 1][M[0].length - 1];
        int mid = ((start + end) / 2);

        while(start <= end){
            int less = BinarySearch(M, mid);
            if(less < K){
                start = (mid + 1);
            }
            else if(less >= K){
                end = (mid - 1);
            }
            mid = ((start + end) / 2);
        }

        return start;
    }

    private static int BinarySearch(int[][] M, int Mid){
        if(M == null){
            return -1;
        }

        int less = 0;
        for(int i=0; i<M.length; i++){
            int start = 0;
            int end = M[0].length - 1;
            int mid = (start + ((end - start) / 2));

            while(start <= end){
                if(M[i][mid] <= Mid){
                    start = (mid + 1);
                }
                else{
                    end = (mid - 1);
                }
                mid = (start + ((end - start) / 2));
            }

            less += start;
        }

        return less;
    }
}
