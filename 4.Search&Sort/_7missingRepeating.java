import java.util.Arrays;

public class _7missingRepeating{

    // https://leetcode.com/problems/missing-number/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {0, 1, 3};
        System.out.println(findMissingRepeating(Arr));
    }

    private static int findMissingRepeating(int[] Arr){
        long S = Arrays.stream(Arr).map(i -> i).sum();  // use your simple for loop for this. 
                                                        // Java's Stream API takes atleast 6x 
                                                        // the time than your simpler for loop.
        long N = (((Arr.length)*(Arr.length + 1))/2);
        
        return (int) Math.abs(S - N);
    }
}