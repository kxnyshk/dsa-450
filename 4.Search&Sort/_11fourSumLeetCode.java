import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _11fourSumLeetCode {

    // https://leetcode.com/problems/4sum/
    // TC : O(N^3)
    // SC : O(N^2)
    
    public static void main(String[] args) {
        
        int[] Arr = {1,0,-1,0,-2,2};
        int X = 0;
        // int[] Arr = {1000000000,1000000000,1000000000,1000000000};
        // int X = -294967296;
        // int[] Arr = {-1000000000,-1000000000,1000000000,-1000000000,-1000000000};
        // int X = 294967296;
        System.out.println(FourSum(Arr, X).toString());
    }

    private static List<List<Integer>> FourSum(int[] Arr, int X){
        List<List<Integer>> L = new ArrayList<>();
        if((Arr == null) || (Arr.length < 4)){
            return L;
        } if(Arr.length == 4){
            long S = 0;
            for(int Val: Arr){
                S += Val;
            } if(S == X){
                List<Integer> TempL = new ArrayList<>();
                TempL.add(Arr[0]); TempL.add(Arr[1]);
                TempL.add(Arr[2]); TempL.add(Arr[3]);
                L.add(TempL);
            } return L; // System.out.println(S); 
        } Arrays.sort(Arr);

        for(int i=0; i<Arr.length; i++){
            for(int j=(i+1); j<Arr.length; j++){
                long T1 = (Arr[i] + Arr[j]);
                long T2 = (X - T1);
                int Le = (j + 1);
                int Ri = (Arr.length - 1);
                while(Le < Ri){
                    long TempSum = (Arr[Le] + Arr[Ri]);
                    if(TempSum < T2){
                        Le++;
                    } else if (TempSum > T2){
                        Ri--;
                    } else {
                        List<Integer> TempL = new ArrayList<>();
                        TempL.add(Arr[i]); TempL.add(Arr[j]);
                        TempL.add(Arr[Le]); TempL.add(Arr[Ri]);
                        L.add(TempL);
                        while((Le < Ri) && (Arr[Le] == TempL.get(2))){
                            ++Le;
                        } while((Le < Ri) && (Arr[Ri] == TempL.get(3))){
                            --Ri;
                        }
                    }
                } while(((j + 1) < Arr.length) && (Arr[j + 1] == Arr[j])){
                    ++j;
                }
            } while(((i + 1) < Arr.length) && (Arr[i + 1] == Arr[i])){
                ++i;
            }
        } return L;
    }
}
