public class _12maxAdjSum {

    // https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1/
    // https://leetcode.com/problems/house-robber/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        // int[] Arr = {5, 5, 10, 100, 10, 5};
        // int[] Arr = {3, 2, 7, 10};
        int[] Arr = {3, 2, 5, 10, 7};
        System.out.println(MaxSum(Arr));
    }

    private static int MaxSum(int[] Arr){
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } if(Arr.length <= 2){
            return (Arr.length == 1) ? Arr[0] : Math.max(Arr[0], Arr[1]);
        }

        int Inc = Arr[0];
        int Exc = 0;
        for(int i=1; i<Arr.length; i++){
            int TempInc = (Arr[i] + Exc), TempExc = Math.max(Inc, Exc);
            Inc = TempInc; Exc = TempExc;
        } return Math.max(Inc, Exc);
    }
}
