import java.util.Arrays;

public class _20rearrArr {

    // https://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/
    // [Order not preserved]
   
    public static void main(String[] args) {
        
        int[] Arr = {-5,-2,5,2,4,7,1,8,0,-8};

        reArrange(Arr);
        System.out.println(Arrays.toString(Arr));
    }

    private static void reArrange(int[] Arr){
        int i = 0;
        int j = Arr.length-1;

        while(i < j){
            if((Arr[i] < 0) && (Arr[j] >= 0)){
                int temp = Arr[i];
                Arr[i++] = Arr[j];
                Arr[j--] = temp;
            }
            else if((Arr[j] < 0) && (Arr[i] < 0)){
                j--;
            }
            else if((Arr[i] > 0) && (Arr[j] > 0)){
                i++;
            }
            else{
                ;
            }
        }

        i += 1;
        int k = 0;
        
        while(i < Arr.length){
            int temp = Arr[k];
            Arr[k] = Arr[i];
            Arr[i++] = temp;
            k += 2;
        }
    }
}
