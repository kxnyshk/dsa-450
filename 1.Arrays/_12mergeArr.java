import java.util.Arrays;

public class _12mergeArr {

    // https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
    
    public static void main(String[] args) {
        
        int[] Arr1 = { 1, 5, 9, 10, 15, 20 };
        int[] Arr2 = { 2, 3, 8, 13 };

        merge(Arr1, Arr2);

        System.out.println(Arrays.toString(Arr1));
        System.out.println(Arrays.toString(Arr2));
    }

    private static void merge(int[] Arr1, int[] Arr2){

        int i=0;
        int j=0;
        int k=Arr1.length-1;

        while((i <= k) && (j < Arr2.length)){
            if(Arr2[j] < Arr1[i]){
                int temp = Arr2[j];
                Arr2[j] = Arr1[k];
                Arr1[k] = temp;

                j++;
                k--;
            }
            else{
                i++;
            }
        }

        Arrays.sort(Arr1);
        Arrays.sort(Arr2);
    }
}
