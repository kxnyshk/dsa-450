public class _12wordWrap {
    
    // https://practice.geeksforgeeks.org/problems/word-wrap1646/1
    // TC : O(N^2)
    // SC : O(N^2)

    public static void main(String[] args) {
        
        int[] Arr = {10,6,5,3,1,10,8,2};
        int Limit = 12;

        System.out.println(WordWrap(Arr, Limit));
    }

    private static int WordWrap(int[] nums, int k){
        int[][] cost = new int[nums.length][nums.length];

        for(int i=0; i<cost.length; i++){
            cost[i][i] = (k - nums[i]);
            for(int j=(i+1); j<cost[0].length; j++){
                cost[i][j] = (cost[i][j - 1] - nums[j] - 1);
            }
        }

        for(int i=0; i<cost.length; i++){
            for(int j=i; j<cost[0].length; j++){
                if((j == (cost[0].length - 1)) && (cost[i][j] >= 0)){
                    cost[i][j] = 0;
                }
                if(cost[i][j] < 0){
                    cost[i][j] = Integer.MAX_VALUE;
                } else{ cost[i][j] *= cost[i][j]; }
            }
        }

        int[] min = new int[nums.length];
        int[] ans = new int[nums.length];
    
        for(int i=(nums.length - 1); i>=0; i--){
            min[i] = cost[i][cost[0].length - 1];
            ans[i] = nums.length;
            
            for(int j=(nums.length - 1); j>i; j--){
                if(cost[i][j - 1] == Integer.MAX_VALUE){ continue; }
                if(min[i] > (cost[i][j - 1] + min[j])){
                    min[i] = cost[i][j - 1] + min[j];
                    ans[i] = j;
                }
            }
        }

        return min[0];
    }
}
