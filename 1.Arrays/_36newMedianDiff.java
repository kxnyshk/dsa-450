public class _36newMedianDiff {

    // https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1/
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    // TC : O((n + m)*log(n + m))
    // SC : O(n + m)
    
    public static void main(String[] args) {
        
        int[] Arr1 = {3,9,12,13,14,19};
        int[] Arr2 = {7,17,20,24,26,28,30,32};
        // int[] Arr3 = {1,5,9};
        // int[] Arr4 = {2,3,6,7};

        double M = Median(Arr1, Arr2);
        System.out.println(M);
    }

    private static double Median(int[] Arr1, int[] Arr2){
        int[] Merge = new int[Arr1.length + Arr2.length];

        int i=0;
        int j=0;
        int k=0;
        while((i < Arr1.length) && (j < Arr2.length)){
            if(Arr1[i] <= Arr2[j]){
                Merge[k++] = Arr1[i++];
            }
            else{
                Merge[k++] = Arr2[j++];
            }
        }

        while(i < Arr1.length){
            Merge[k++] = Arr1[i++];
        }
        while(j < Arr2.length){
            Merge[k++] = Arr2[j++];
        }

        // System.out.println(Arrays.toString(Merge));
        // System.out.println(Merge[(Merge.length / 2) - 1]);
        // System.out.println(Merge[Merge.length / 2]);

        return (((Merge.length) % 2) == 0) ? ((Merge[(Merge.length / 2) - 1] + Merge[Merge.length / 2]) / 2.0) : Merge[Merge.length / 2];
    }
}
