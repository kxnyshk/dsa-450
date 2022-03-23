public class _5movNegEnd {
    
    // https://www.geeksforgeeks.org/move-ve-elements-end-order-extra-space-allowed/

    public static void main(String[] args) {
        
        int[] Arr = {1,-1,-3,-2,7,5,11,6};
        
        solve(Arr);
        for(int i=0; i<Arr.length; i++){
            System.out.print(Arr[i] + " ");
        }
    }

    private static void solve(int[] Arr){
        int[] newArr = new int[Arr.length];

        int k = 0;
        int i;
        for(i=0; i<Arr.length; i++){
            if(Arr[i] >= 0){
                newArr[k++] = Arr[i];
            }
        }

        for(int j=0; j<Arr.length; j++){
            if(Arr[j] < 0){
                newArr[k++] = Arr[j];
            }
        }

        for(int l=0; l<Arr.length; l++){
            Arr[l] = newArr[l];
        }
    }
}
