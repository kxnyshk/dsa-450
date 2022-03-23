public class _5movNegBeginning {

    // https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/

    public static void main(String[] args) {
        
        int[] Arr = {1,2,-4,-5,2,-7,3,2,-6,-8,-9,3,2,1};
        
        solve(Arr);
        for(int i=0; i<Arr.length; i++){
            System.out.print(Arr[i] + " ");
        }
    }

    private static void solve(int[] Arr){
        int low = 0;
        int mid = 0;
        int high = Arr.length-1;

        while(mid <= high){
            if(Arr[mid] < 0){
                int temp = Arr[low];
                Arr[low] = Arr[mid];
                Arr[mid] = temp;
                low++;
                mid++;
            }
            else{
                int temp = Arr[mid];
                Arr[mid] = Arr[high];
                Arr[high] = temp;
                high--;
            }
        }
    }
}