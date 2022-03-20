public class _1reverseArray {
    
    // https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/

    public static void main(String[] args) {
        
        int[] Arr = {14,56,78,85,12};
        int[] revArr = reverseArray(Arr);
        for(int i=0; i<Arr.length; i++){
            System.out.print(revArr[i] + " ");
        }
    }

    private static int[] reverseArray(int[] Arr){
        int start = 0;
        int end = Arr.length-1;
        recursive(start, end, Arr);
        return Arr;
    }

    private static void recursive(int start, int end, int[] Arr){
        if(start >= end){
            return;
        }
        int temp = Arr[start];
        Arr[start] = Arr[end];
        Arr[end] = temp;
        recursive(start+1, end-1, Arr);
    }
}
