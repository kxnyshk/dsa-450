import java.util.Stack;
// import java.util.Arrays;

public class maxArHist {

    // https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    // TC : O(N) -> Arrays | >O(N) -> ArrayLists
    // SC : O(N)
    
    public static void main(String[] args) {
        
        int[] Arr1 = {4,5,2,10,8};
        // int[] Arr2 = {6,2,5,4,5,1,6};

        int Max = maxArea(Arr1);
        System.out.println(Max);
    }

    private static int maxArea(int[] Arr){
        if(Arr == null){
            return 0;
        }

        // Left & Right Stacks
        Stack<Integer> LS = new Stack<Integer>();
        Stack<Integer> RS = new Stack<Integer>();
        // Nearest Smallest to Left/Right
        int[] NSL = new int[Arr.length];
        int[] NSR = new int[Arr.length];

        // NSL
        for(int i=0; i<Arr.length; i++){
            while(!LS.isEmpty() && (Arr[LS.peek()] >= Arr[i])){
                LS.pop();
            }
            if(LS.isEmpty()){
                NSL[i] = -1;
            }
            else{
                NSL[i] = LS.peek();
            }
            LS.add(i);
        }
        // NSR
        for(int i=(Arr.length - 1); i>=0; i--){
            while(!RS.isEmpty() && (Arr[RS.peek()] >= Arr[i])){
                RS.pop();
            }
            if(RS.isEmpty()){
                NSR[i] = Arr.length;
            }
            else{
                NSR[i] = RS.peek();
            }
            RS.add(i);
        }

        // System.out.println(Arrays.toString(NSL));
        // System.out.println(Arrays.toString(NSR));
        
        int MAX = Integer.MIN_VALUE;
        for(int i=0; i<Arr.length; i++){
            MAX = Math.max(MAX, ((NSR[i] - (NSL[i]) - 1)*(Arr[i])));
        }

        return MAX;
    }
}
