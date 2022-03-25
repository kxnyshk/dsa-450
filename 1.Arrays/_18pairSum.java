import java.util.HashMap;

public class _18pairSum {

    // https://www.geeksforgeeks.org/count-pairs-with-given-sum/
    
    public static void main(String[] args) {
        
        int[] Arr = {2,6,9,3,4,5,2};
        int Sum = 8;

        int pair = getPairs(Sum, Arr);
        System.out.println(pair);
    }

    private static int getPairs(int Sum, int[] Arr){
        int count = 0;
        HashMap<Integer, Integer> Map = new HashMap<Integer, Integer>();

        for(int i=0; i<Arr.length; i++){
            int key = (Sum - Arr[i]);
            if(Map.containsKey(key)){
                count += Map.get(key);
            }
            if(Map.containsKey(Arr[i])){
                Map.put(Arr[i], Map.get(Arr[i] + 1));
            }
            else{
                Map.put(Arr[i], 1);
            }
        }

        return count;
    }
}
