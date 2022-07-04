import java.util.ArrayList;

public class _2fixedPointArray{

    // https://practice.geeksforgeeks.org/problems/value-equal-to-index-value1330/1/
    // TC : O(N)
    // SC : O(N)

    public static void main(String[] args) {
        
        int[] Arr = {15, 2, 45, 12, 7};
        System.out.println(findFixedPoint(Arr).toString());
    }

    private static ArrayList<Integer> findFixedPoint(int[] Arr){
        ArrayList<Integer> L = new ArrayList<>();
        for(int i=0; i<Arr.length; i++){
            if((i + 1) == Arr[i]){
                L.add(Arr[i]);
            }
        } if(L.isEmpty()){
            L.add(-1);
        } return L;
    }
}