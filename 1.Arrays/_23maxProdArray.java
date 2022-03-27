public class _23maxProdArray {
    
    // https://www.geeksforgeeks.org/maximum-product-subarray/
    // https://leetcode.com/problems/maximum-product-subarray/
    
    public static void main(String[] args) {
        
        int[] Arr = {-6,-3,-10,0,2};

        long max = maxProduct(Arr);
        System.out.println(max);
    }

    private static long maxProduct(int[] Arr){
        long prod = 1;
        long max = Integer.MIN_VALUE;

        for(int i=0; i<Arr.length; i++){
            prod *= Arr[i];
            max = Math.max(prod, max);
            if(prod == 0){
                prod = 1;
            }
        }

        prod = 1;
        for(int i=Arr.length-1; i>=0; i--){
            prod *= Arr[i];
            max = Math.max(prod, max);
            if(prod == 0){
                prod = 1;
            }
        }

        return max;
    }
}
