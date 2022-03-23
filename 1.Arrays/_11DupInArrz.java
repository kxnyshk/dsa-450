import java.util.ArrayList;
import java.util.Arrays;

public class _11DupInArrz {

    // https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1#
    
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    
    public static void main(String[] args) {

        int[] Arr3 = {13,9,25,1,1,0,22,13,22,20,3,8,11,25,10,3,15,11,19,20,2,4,25,14,23,14};
        
        list = duplicates(Arr3);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    private static ArrayList<Integer> duplicates(int[] arr){
        int[] Arr = new int[Arrays.stream(arr).max().getAsInt()+1];
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<arr.length; i++){
            Arr[arr[i]] += 1;
        }
        
        for(int i=0; i<Arr.length; i++){
            if(Arr[i] > 1){
                list.add(i);
            }
        }
        
        if(list.isEmpty()){
            list.add(-1);
            return list;
        }
        else{
            return list;
        }
    }
}
