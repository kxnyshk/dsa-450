public class _34palinArr {

    // https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr1 = {15, 4, 15};       // 0
        // int[] Arr2 = {1, 4, 5, 1};      // 1
        // int[] Arr3 = {11, 14, 15, 99};  // 3
        // int[] Arr4 = {1, 4, 5, 9, 1};   // 1

        int MinOps = mergeOperations(Arr1);
        System.out.println(MinOps);
    }

    private static int mergeOperations(int[] Arr){
        if((Arr.length <= 1) || (Arr == null)){
            return 0;
        }
        if(Arr.length == 2){
            return (Arr[0] == Arr[1]) ? 0 : 1;
        }

        int start = 0;
        int end = (Arr.length - 1);
        int MinOps = 0;

        while(start < end){
            if(Arr[start] == Arr[end]){
                start++;
                end--;
            }
            else if(Arr[start] < Arr[end]){
                start++;
                Arr[start] += Arr[start-1];
                MinOps++;
            }
            else{
                end--;
                Arr[end] += Arr[end+1];
                MinOps++;
            }
        }

        return MinOps;
    }
}
