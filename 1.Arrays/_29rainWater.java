public class _29rainWater {

    // https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
    // https://leetcode.com/problems/trapping-rain-water/
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        int[] Arr = {3,1,2,4,0,1,3,2};

        int W = rainWater(Arr);
        System.out.println(W);
    }

    private static int rainWater(int[] Arr){
        int[] L = new int[Arr.length];
        int[] R = new int[Arr.length];

        L[0] = Arr[0];
        int Lmax = Arr[0];
        for(int i=1; i<Arr.length; i++){
            Lmax = Math.max(Lmax, Arr[i]);
            L[i] = Lmax;
        }

        R[R.length-1] = Arr[Arr.length-1];
        int Rmax = Arr[Arr.length-1];
        for(int i=Arr.length-2; i>=0; i--){
            Rmax = Math.max(Rmax, Arr[i]);
            R[i] = Rmax;
        }

        int S = 0;
        for(int i=0; i<Arr.length; i++){
            S += (Math.min(L[i], R[i]) - Arr[i]);
        }

        return S;
    }
}
