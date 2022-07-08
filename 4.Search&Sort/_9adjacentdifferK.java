public class _9adjacentdifferK {

    // https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {4, 5, 6, 7, 6};
        int K = 1;
        int X = 6;
        System.out.println(findIndex(Arr, K, X));
    }

    private static int findIndex(int[] Arr, int K, int X){
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } if(Arr.length == 1){
            return (Arr[0] == X) ? 0 : -1;
        }

        int Idx = 0;
        while(Idx < Arr.length){
            if(Arr[Idx] == X){
                return Idx;
            } Idx += Math.max(1, Math.abs((X - Arr[Idx]) / K)); 
        } return -1;
    }
}
