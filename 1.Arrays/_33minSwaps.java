public class _33minSwaps {

    // https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr1 = {2,1,5,6,3};       int K1 = 3;
        // int[] Arr2 = {2,7,9,5,8,7,4};   int K2 = 5;

        int Min = MinSwaps(Arr1, K1);
        System.out.println(Min);
    }

    private static int MinSwaps(int[] Arr, int K){
        int G = 0;
        for(int i=0; i<Arr.length; i++){
            if(Arr[i] <= K){
                ++G;
            }
        }

        int B = 0;
        for(int i=0; i<G; i++){
            if(Arr[i] > K){
                ++B;
            }
        }

        int Min = B;
        for(int i=1, j=(i+G-1); j<Arr.length; i++, j++){
            if(Arr[i-1] > K){
                --B;
            }
            if(Arr[j] > K){
                ++B;
            }

            Min = Math.min(Min, B);
        }

        return Min;
    }
}
