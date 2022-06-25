import java.util.HashMap;
import java.util.Map;

public class _27repeatedWord{

    // https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1/
    // TC : O(N)
    // SC : O(N)

    public static void main(String[] args) {
        
        String[] arr = {"aaa", "bbb", "ccc", "bbb", 
                        "aaa", "aaa"};
        System.out.println(RepeatedString(arr));
    }

    private static String RepeatedString(String[] arr){
        if(arr == null){
            return "";
        }
        
        HashMap<String, Integer> HM = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            HM.put(arr[i], (HM.getOrDefault(arr[i], 0) + 1));
        }

        int firstMost = Integer.MIN_VALUE;
        int secondMost = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> MapSet : HM.entrySet()) {
            Integer value = MapSet.getValue();
            if(value > firstMost){
                secondMost = firstMost;
                firstMost = value;
            } else if ((value > secondMost) && (value < firstMost)){
                secondMost = value;
            }
        }

        String res = "";
        for(Map.Entry<String, Integer> MapSet : HM.entrySet()){
            String key = MapSet.getKey();
            Integer value = MapSet.getValue();
            if(value == secondMost){
                res = key;
            }
        }

        return res;
    }

}