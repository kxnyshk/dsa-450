public class _36medianDiff {
    
    // https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1/
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    // TC : O(log(N))
    // SC : O(1)

    public static void main(String[] args) {
        
        int[] Arr1 = {3,9,12,13,14,19};
        int[] Arr2 = {7,17,20,24,26,28,30,32};
        // int[] Arr3 = {1,5,9};
        // int[] Arr4 = {2,3,6,7};
        // int[] Arr5 = {1,2};
        // int[] Arr6 = {3,4};

        double M = Median(Arr1, Arr2);
        System.out.println(M);
    }

    private static double Median(int[] Arr1, int[] Arr2){
        if((Arr1 == null) && (Arr2 == null)){
            return (double) -1;
        }
        if(Arr1 == null){
            return ((Arr2.length % 2) == 0) ? ((Arr2[(Arr2.length / 2) - 1] + Arr2[Arr2.length / 2]) / 2) : Arr2[Arr2.length / 2];
        }
        if(Arr2 == null){
            return ((Arr1.length % 2) == 0) ? ((Arr1[(Arr1.length / 2) - 1] + Arr1[Arr1.length / 2]) / 2) : Arr1[Arr1.length / 2];
        }

        return (Arr1.length < Arr2.length) ? SmallArr(Arr1, Arr2) : SmallArr(Arr2, Arr1);
    }

    private static double SmallArr(int[] Arr1, int[] Arr2){
        int low = 0;
        int high = Arr1.length;

        while(low <= high){
            int mid1 = ((low + high) / 2);
            int mid2 = (((Arr1.length + Arr2.length) / 2) - mid1);

            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : Arr1[(mid1 - 1)];
            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : Arr2[(mid2 - 1)];
            int right1 = (mid1 == Arr1.length) ? Integer.MAX_VALUE : Arr1[mid1];
            int right2 = (mid2 == Arr2.length) ? Integer.MAX_VALUE : Arr2[mid2];

            if((left1 <= right2) && (left2 <= right1)){
                return (((Arr1.length + Arr2.length) % 2 == 0) ? ((Math.max(left1, left2) + Math.min(right1, right2)) / 2.0) : Math.min(right1, right2));
            }
            else if(left1 > right2){
                high = (mid1 - 1);
            }
            else{
                low = (mid1 + 1);
            }
        }

        return (double) -1;
    }
}
