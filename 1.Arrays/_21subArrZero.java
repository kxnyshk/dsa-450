import java.util.HashMap;

public class _21subArrZero {

    // https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
    
    public static void main(String[] args) {
        
        // int[] Arr = {4,2,-3,1,6};
        int[] Arr = {10,-10};
        // // int[] Arr = {4,2,0,1,6};
        // int[] Arr = {3,-3,-3};
        
        boolean found = subArrayZero(Arr);
        System.out.println(found);
    }

    private static boolean subArrayZero(int[] Arr){
        HashMap<Integer, Integer> M = new HashMap<Integer, Integer>();
        
        boolean found = false;
        int sum = 0;

        for(int i=0; i<Arr.length; i++){
            sum += Arr[i];
            if((sum == 0) || (Arr[i] == 0) || M.containsKey(sum)){
                return found = true;
            }
            else{
                M.put(sum, 1);
            }
        }

        return found;
    }
}
