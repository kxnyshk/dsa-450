import java.util.Arrays;

public class _20rearrArrOrder {

    // https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
    // [Order preserved]
    
    public static void main(String[] args) {
        
        int[] Arr = {-5,-2,5,2,4,7,1,8,0,-8};
        // int[] A = {-5,5,-2,2,-8,4,7,1,8,0};

        reArrange(Arr);
        System.out.println(Arrays.toString(Arr));
    }

    private static void reArrange(int[] Arr){
        int i=0;    // static
        int j=0;    // finder
        int k=0;    // traversal

        while((k < Arr.length)){
            if((k%2) == 0){
                if(Arr[k] < 0){
                    k++;
                }
                else{
                    i = k;
                    j = k;
                    while((j < Arr.length) && (Arr[j] >= 0)){
                        j++;
                    }
                    if(j >= Arr.length){
                        break;
                    }
                    else{
                        rotate(Arr, i, j);
                    }
                    k++;
                }
            }

            else{
                if(Arr[k] >= 0){
                    k++;
                }
                else{
                    i = k;
                    j = k;
                    while((j < Arr.length) && (Arr[j] < 0)){
                        j++;
                    }
                    if(j >= Arr.length){
                        break;
                    }
                    else{
                        rotate(Arr, i, j);
                    }
                    k++;
                }
            }
        }
    }

    private static void rotate(int[] Arr, int start, int end){
        if((start == end) || (Arr == null)){
            return;
        }
        else if(start == (end - 1)){
            int temp = Arr[start];
            Arr[start] = Arr[end];
            Arr[end] = temp;
        }
        else{
            System.out.println(end);
            int save = Arr[end];
            int cnt = end;
            
            while(cnt >= start){
                Arr[cnt] = Arr[cnt - 1];
                cnt--;
            }

            Arr[start] = save;
        }
    }
}

//  && (i < Arr.length) && (j < Arr.length)
