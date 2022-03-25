import java.util.Arrays;

public class _16countInv {

    // https://www.geeksforgeeks.org/counting-inversions/
    
    public static void main(String[] args) {
        
        int Arr[] = {1,20,6,4,5};
        int start = 0;
        int end = Arr.length-1;
        
        int Inv = Inversions(start, end, Arr);
        System.out.println(Inv);
    }

    private static int Inversions(int start, int end, int[] Arr){
        int count = 0;

        if(start < end){
            // int mid = ((end - start) + start)/2;
            int mid = (end + start)/2;

            count += Inversions(start, mid, Arr);
            count += Inversions((mid + 1), end, Arr);
            count += Merge(start, mid, end, Arr);
        }

        return count;
    }

    private static int Merge(int start, int mid, int end, int[] Arr){
        int[] L = Arrays.copyOfRange(Arr, start, (mid + 1));
        int[] R = Arrays.copyOfRange(Arr, (mid + 1), (end + 1));

        int i=0;
        int j=0;
        int k=start;
        int count=0;

        while((i < L.length) && (j < R.length)){
            if(L[i] <= R[j]){
                Arr[k++] = L[i++];
            }
            else{
                Arr[k++] = R[j++];
                // count += (mid + 1 - i);
                count += (L.length - i);
            }
        }

        while(i < L.length){
            Arr[k++] = L[i++];
        }
        while(j < R.length){
            Arr[k++] = R[j++];
        }

        return count;
    }
}
