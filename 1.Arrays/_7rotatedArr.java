public class _7rotatedArr {

    // https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
    
    public static void main(String[] args) {
        
        int[] Arr = {1,2,3,4,5};
        
        rotate(Arr);
        for(int i=0; i<Arr.length; i++){
            System.out.print(Arr[i] + " ");
        }
    }

    private static void rotate(int[] Arr){
        int i = 0;
        int j = Arr.length-1;
        
        while(i < j){
            int temp = Arr[i];
            Arr[i++] = Arr[j];
            Arr[j] = temp;
        }
    }
}
