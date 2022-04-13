public class _31sumSubArr {

    // https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
    // https://leetcode.com/problems/minimum-size-subarray-sum/
    // TC : O(N)
    // SC : 0(1)
    
    public static void main(String[] args) {
        
        int[] Arr1 = {1,10,3,40,18};     int X1 = 50;   // 2
        // int[] Arr2 = {1,4,45,6,0,19};    int X2 = 51;   // 3
        // int[] Arr3 = {1,10,5,2,7};       int X3 = 9;    // 1
        // int[] Arr4 = {1,11,100,1,0,200,3,2,1,250};  int X4 = 280;  // 4
        // int[] Arr5 = {1,2,4};            int X5 = 8;    // np

        int L = minLength(Arr1, X1);
        System.out.println(L);
    }

    private static int minLength(int[] Arr, int X){
        if(Arr.length <=0 || Arr == null){
            return 0;
        }
        if(Arr.length == 1){
            return (Arr[0] > X) ? 1 : 0;
        }

        int i=0;
        int j=0;
        int S=0;
        int MinLen=Arr.length+1;
        boolean found = false;

        while(j < Arr.length){
            while((S <= X) && (j < Arr.length)){
                S += Arr[j++];
            }

            while((S > X) && (i < j)){
                MinLen = Math.min(MinLen, (j - i));
                S -= Arr[i++];
                found = true;
            }
        }
        
        return (found) ? MinLen : 0;
    }
}
