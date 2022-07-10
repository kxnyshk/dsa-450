import java.util.Arrays;

public class _13smallTripletSum {

    // https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1/
    // TC : O(N^2)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {15, 8, 3, 18, 25, 2, 1, 17, 34, 22, 6, 21, 27, 24, 28, 20};
        int X = 99;
        System.out.println(TripletSum(Arr, X));
    }

    private static int TripletSum(int[] Arr, int X){
        if((Arr == null) || (Arr.length < 3)){
            return 0;
        } if(Arr.length == 3){
            long S = 0;
            for(int Val: Arr){
                S += Val;
            } return (S < X) ? 1 : 0;
        } Arrays.sort(Arr);

        int Count = 0;
        for(int i=0; i<(Arr.length-2); i++){
            int Le = (i + 1);
            int Ri = (Arr.length - 1);
            while(Le < Ri){
                long S1 = (Arr[Le] + Arr[Ri]);
                long S2 = (S1 + Arr[i]);
                if(S2 < X){
                    Count += (Ri - Le); Le++;
                } else {
                    Ri--;
                }
            }
        } return Count;
    }
}
