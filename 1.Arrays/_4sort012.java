public class _4sort012 {
    
    // https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
    
    public static void main(String[] args) {
        
        int[] Arr = {0,1,2,1,0,2,1,0,2,1};
        
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
            if(Arr[mid] == 0){
                int temp = Arr[low];
                Arr[low] = Arr[mid];
                Arr[mid] = temp;
                low++;
                mid++;
            }
            else if(Arr[mid] == 1){
                mid++;
            }
            else if(Arr[mid] == 2){
                int temp = Arr[mid];
                Arr[mid] = Arr[high];
                Arr[high] = temp;
                high--;
            }
        }
    }
}
