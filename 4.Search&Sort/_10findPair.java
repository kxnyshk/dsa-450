import java.util.Arrays;

public class _10findPair {

    // https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1/
    // TC : O(NlogN)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {1,2,6,3,4};
        int X = 0;
        System.out.println(findPair(Arr, X));
    }

    private static boolean findPair(int[] Arr, int X){
        Arrays.sort(Arr);
        if((Arr == null) || (Arr.length <= 1)){
            return false;
        } if(Arr.length == 2){
            return (X == (Arr[1] - Arr[0])) ? true : false;
        }

        int i = 0;
        int j = 1;
        while((i < Arr.length) && (j < Arr.length)){
            int diff = (Arr[j] - Arr[i]);
            if((i != j) && (diff == X)){
                return true;
            } else if(diff < X){
                j++;
            } else {
                i++;
            }
        } return false;
    }
}
