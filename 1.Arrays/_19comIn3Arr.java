import java.util.ArrayList;

public class _19comIn3Arr{

    // https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

    public static void main(String[] args) {
        
        int[] Arr1 = {1, 5, 10, 20, 40, 80};
        int[] Arr2 = {6, 7, 20, 80, 100};
        int[] Arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
        // int[] Arr1 = {3,3,3};
        // int[] Arr2 = {3,3,3};
        // int[] Arr3 = {3,3,3};

        ArrayList<Integer> L = new ArrayList<Integer>();
        L = Commons(Arr1, Arr2, Arr3);
        System.out.println(L.toString());
    }

    private static ArrayList<Integer> Commons(int[] Arr1, int[] Arr2, int[] Arr3){
        ArrayList<Integer> L = new ArrayList<Integer>();

        int i=0;
        int j=0;
        int k=0;

        int prev1 = Integer.MIN_VALUE;
        int prev2 = Integer.MIN_VALUE;
        int prev3 = Integer.MIN_VALUE;

        while((i < Arr1.length) && (j < Arr2.length) && (k < Arr3.length)){
            
            if((Arr1[i] == Arr2[j]) && (Arr2[j] == Arr3[k])){
                L.add(Arr1[i]);
                prev1 = Arr1[i++];
                prev2 = Arr2[j++];
                prev3 = Arr3[k++];
            }
            else if(Arr1[i] < Arr2[j]){
                prev1 = Arr1[i++];
            }
            else if(Arr2[j] < Arr3[k]){
                prev2 = Arr2[j++];
            }
            else{
                prev3 = Arr3[k++];
            }

            while((i < Arr1.length) && (Arr1[i] == prev1)){
                i++;
            }
            while((j < Arr2.length) && (Arr2[j] == prev2)){
                j++;
            }
            while((k < Arr3.length) && (Arr3[k] == prev3)){
                k++;
            }

            if((i == Arr1.length) || (j == Arr2.length) || (k == Arr3.length)){
                break;
            }
        }

        return L; 
    }
}