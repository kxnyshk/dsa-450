import java.util.Arrays;

public class _32rangePart {

    // https://practice.geeksforgeeks.org/problems/three-way-partitioning/1/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {1,14,5,20,4,2,54,20,87,98,3,1,32};
        int L = 14;
        int H = 20;

        DutchNationalFlag(Arr, L, H);
        System.out.println(Arrays.toString(Arr));
    }

    private static void DutchNationalFlag(int[] Arr, int L, int H){

        if((Arr.length < 2) || (Arr == null)){
            return;
        }

        int low=0;
        int mid=0;
        int high=(Arr.length-1);

        while(mid <= high){
            if(Arr[mid] < L){
                int temp = Arr[mid];
                Arr[mid++] = Arr[low];
                Arr[low++] = temp;
            }
            else if(Arr[mid] > H){
                int temp = Arr[mid];
                Arr[mid] = Arr[high];
                Arr[high--] = temp;
            }
            else{
                mid++;
            }
        }
    }
}
