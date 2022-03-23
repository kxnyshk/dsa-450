import java.util.Arrays;

public class _9minHeights {

    // https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
    
    public static void main(String[] args) {
        
        int[] Arr = {1, 15, 10};
        int K = 6;
        
        int min = minHeight(K, Arr);
        System.out.println(min);
    }

    private static int minHeight(int K, int[] Arr){
        Arrays.sort(Arr);
        
        int currMin = Arr[0];
        int currMax = Arr[Arr.length-1];
        int diff = currMax-currMin;

        for(int i=0; i<Arr.length; i++){
            if(Arr[i] >= K){
                int min = Math.min(currMin+K, Arr[i+1]-K);
                int max = Math.max(currMax-K, Arr[i]+K);
                
                diff = Math.min(diff, max-min);
            }
        }

        return diff;
    }
}
