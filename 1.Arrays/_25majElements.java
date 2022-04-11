import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _25majElements {

    // https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        int[] Arr = {3,1,2,2,1,2,3,3};
        int K1 = 4;
        // int[] Arr1 = {1,1,2,2,3,5,4,2,2,3,1,1,1};
        // int[] Arr2 = {4,5,6,7,8,4,4};
        // int[] Arr3 = {4,2,2,7};
        // int[] Arr4 = {2,3,3,2};
        // int K2 = 3;

        int[] Res = majorityElements(Arr, K1);
        System.out.println(Arrays.toString(Res));
    }

    private static int[] majorityElements(int [] Arr, int K){
        HashMap<Integer, Integer> HM = new HashMap<Integer, Integer>();
        ArrayList<Integer> L = new ArrayList<Integer>();
        
        int R = (Arr.length/K);

        for(int i=0; i<Arr.length; i++){
            if(!HM.containsKey(Arr[i])){
                HM.put(Arr[i], 1);
            }
            else if(HM.get(Arr[i]) <= R){
                HM.put(Arr[i], (HM.get(Arr[i]) + 1));
            }

            if(HM.get(Arr[i]) > R){
                L.add(Arr[i]);
                HM.put(Arr[i], Integer.MIN_VALUE);
            }

        }

        return L.stream().mapToInt(i -> i).toArray();
    }
}
