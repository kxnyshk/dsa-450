import java.util.Arrays;

public class _15nextPermu {

    // https://leetcode.com/problems/next-permutation/
    // https://practice.geeksforgeeks.org/problems/next-permutation5226/1
    
    public static void main(String[] args) {
        
        int[] Arr = {1,2,3,6,5,4};
        
        nextPermutation(Arr);
        System.out.println(Arrays.toString(Arr));
    }

    private static void nextPermutation(int[] Arr){

        if(Arr.length <= 1){
            return;
        }
        if(Arr.length == 2){
            int temp = Arr[0];
            Arr[0] = Arr[1];
            Arr[1] = temp;
            return;
        }

        int idx = -1;
        for(int i=Arr.length-1; i>0; i--){
            if(Arr[i-1] < Arr[i]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            // Collections.reverse(Arrays.asList(Arr));
            reverse(Arr, 0, Arr.length-1);
        }
        else{
            int save = idx;

            for(int i=idx+1; i<Arr.length; i++){
                if((Arr[i] > Arr[idx-1]) && (Arr[i] <= Arr[save])){
                    save = i;
                }
            }

            int temp = Arr[save];
            Arr[save] = Arr[idx-1];
            Arr[idx-1] = temp;

            reverse(Arr, idx, Arr.length-1);
        }
    }

    private static void reverse(int[] Arr, int start, int end){
        if(start == end){
            return;
        }
        if(start == (end - 1)){
            int temp = Arr[start];
            Arr[start] = Arr[end];
            Arr[end] = temp;
            return;
        }

        int i=start;
        int j=end;

        while(i < j){
            int temp = Arr[i];
            Arr[i] = Arr[j];
            Arr[j] = temp;

            i++;
            j--;
        }
    }
}
