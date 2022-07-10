import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13threeSumLeetCode {

    // https://leetcode.com/problems/3sum/
    // TC : O(N^2)
    // SC : O(N^2)

    public static void main(String[] args) {
        
        int[] Arr = {-1,0,1,2,-1,-4};
        int X = 0;
        System.out.println(TripletSum(Arr, X).toString());
    }

    private static List<List<Integer>> TripletSum(int[] Arr, int X){
        List<List<Integer>> L = new ArrayList<>();
        if((Arr == null) || (Arr.length < 3)){
            return L;
        } if(Arr.length == 3){
            long S = 0;
            for(int Val: Arr){
                S += Val;
            } if(S == X){
                List<Integer> TempL = new ArrayList<>();
                TempL.add(Arr[0]); TempL.add(Arr[1]); TempL.add(Arr[2]); L.add(TempL);
            } return L;
        } Arrays.sort(Arr);

        for(int i=0; i<(Arr.length-2); i++){
            long S1 = Arr[i];
            int Le = (i + 1);
            int Ri = (Arr.length - 1);
            while(Le < Ri){
                long S2 = (Arr[Le] + Arr[Ri]);
                long S3 = (S1 + S2);
                if(S3 < X){
                    Le++;
                } else if(S3 > X){
                    Ri--;
                } else{
                    List<Integer> TempL = new ArrayList<>();
                    TempL.add(Arr[i]); TempL.add(Arr[Le]); TempL.add(Arr[Ri]);
                    L.add(TempL); // System.out.println(L);
                    while((Le < Ri) && (Arr[Le] == TempL.get(1))){
                        ++Le;
                    } while((Le < Ri) && (Arr[Ri] == TempL.get(2))){
                        --Ri;
                    }
                }
            } while(((i + 1) < Arr.length) && (Arr[i + 1] == Arr[i])){
                ++i;
            }
        } return L;
    }
}