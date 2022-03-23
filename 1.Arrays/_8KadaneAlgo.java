public class _8KadaneAlgo {
    
    // https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/ 

    public static void main(String[] args) {
        
        int[] Arr = {-2,-3,-1,-2,-3};
        int max = Kadane(Arr);

        System.out.println(max);
    }

    private static int Kadane(int[] Arr){
        int curr = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<Arr.length; i++){
            curr += Arr[i];

            max = Math.max(curr, max);

            if(curr < 0){
                curr = 0;
            }
        }

        return max;
    }
}
