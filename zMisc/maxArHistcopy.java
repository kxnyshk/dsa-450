// import java.util.ArrayList;
// import java.util.Collections;
import java.util.Stack;
// import java.util.Arrays;

public class maxArHistcopy {
    
    public static void main(String[] args) {
        
        long[] Arr1 = {4,5,2,10,8};
        // long[] Arr2 = {6,2,5,4,5,1,6};

        long Max = maxArea(Arr1, Arr1.length);
        System.out.println(Max);
    }

    private static long maxArea(long[] hist, long n){
        if(hist == null){
            return 0;
        }

        // Left & Right Stacks
        Stack<Integer> LS = new Stack<Integer>();
        Stack<Integer> RS = new Stack<Integer>();
        // Nearest Smallest to Left/Right
        long[] NSL = new long[hist.length];
        long[] NSR = new long[hist.length];
        // ArrayList<Long> NSL = new ArrayList<Long>();
        // ArrayList<Long> NSR = new ArrayList<Long>();

        // NSL
        for(long i=0; i<n; i++){
            while(!LS.isEmpty() && (hist[LS.peek()] >= hist[(int) i])){
                LS.pop();
            }
            if(LS.isEmpty()){
                // NSL.add((long) -1);
                NSL[(int) i] = (long) -1;
            }
            else{
                // NSL.add((long) LS.peek());
                NSL[(int) i] = LS.peek();
            }
            LS.add((int) i);
        }
        // NSR
        for(long i=(n - 1); i>=0; i--){
            while(!RS.isEmpty() && (hist[RS.peek()] >= hist[(int) i])){
                RS.pop();
            }
            if(RS.isEmpty()){
                // NSR.add(n);
                NSR[(int) i] = n;
            }
            else{
                // NSR.add((long) RS.peek());
                NSR[(int) i] = RS.peek();
            }
            RS.add((int) i);
        }
        // Collections.reverse(NSR);

        // System.out.println(Arrays.toString(NSL.toArray()));
        // System.out.println(Arrays.toString(NSR.toArray()));
        
        long MAX = Integer.MIN_VALUE;
        for(long i=0; i<n; i++){
            // MAX = Math.max(MAX, ((NSR.get((int) i) - (NSL.get((int) i)) - (long) 1)*(hist[(int) i])));
            MAX = Math.max(MAX, ((NSR[(int) i] - (NSL[(int) i]) - 1))*hist[(int) i]);
        }

        return MAX;
    }
}
