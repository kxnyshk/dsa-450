import java.util.HashMap;

public class _27subsetArr {

    // https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1/
    
    public static void main(String[] args) {
        
        int[] Arr1 = {11,1,13,21,3,7};   int[] Arr2 = {11,3,7,1};
        // int[] Arr3 = {1,2,3,4,5,6};      int[] Arr4 = {1,2,4};
        // int[] Arr5 = {10,5,2,23,19};     int[] Arr6 = {19,5,3};

        if(subsetArray(Arr1, Arr2)){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }

    private static boolean subsetArray(int[] Arr1, int[] Arr2){
        HashMap<Integer, Integer> HM = new HashMap<Integer, Integer>();

        for(int i=0; i<Arr1.length; i++){
            HM.put(Arr1[i], 1);
        }

        for(int i=0; i<Arr2.length; i++){
            if(!HM.containsKey(Arr2[i])){
                return false;
            }
        }

        return true;
    }
}
