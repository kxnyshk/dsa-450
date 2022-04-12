import java.util.Arrays;

public class _30chocolateDist {
    
    public static void main(String[] args) {
        
        int[] Arr = {7,3,2,4,9,12,56};
        int S = 3;

        int D = minDiff(Arr, S);
        System.out.println(D);
    }

    private static int minDiff(int[] Arr, int S){
        int Min = Integer.MAX_VALUE;

        Arrays.sort(Arr);
        for(int i=0; (i+S-1)<Arr.length; i++){
            Min = Math.min((Arr[i+S-1] - Arr[i]), Min);
        }

        return Min;
    }
}
