import java.util.Stack;

public class _6maxBinAr {

    // https://practice.geeksforgeeks.org/problems/max-rectangle/1/
    // https://leetcode.com/problems/maximal-rectangle/
    // TC : O(N*M)
    // SC : O(N+M)
    
    public static void main(String[] args) {
        
        int[][] M1 = {{ 0, 1, 1, 0 },
                     { 1, 1, 1, 1 },
                     { 1, 1, 1, 1 },
                     { 1, 1, 0, 0 },};
        // int[][] M2 = {{1,0,0,0},
        //               {0,1,1,1},
        //               {0,0,1,0},
        //               {0,1,1,1},};
        // int[][] M3 = {{1,1,1},
        //               {1,0,1},
        //               {0,0,0},
        //               {1,1,0},};

        int Max = maxAreaBinary(M1);
        System.out.println(Max);
    }

    private static int maxAreaBinary(int[][] M){
        long start = System.nanoTime();
        if(M == null){
            return 0;
        }

        int[] Arr = new int[M[0].length];
        int Max = Integer.MIN_VALUE;

        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[0].length; j++){
                if(M[i][j] == 0){
                    Arr[j] = 0;
                }
                else{
                    Arr[j] += M[i][j];
                }
            }

            Max = Math.max(Max, maxAreaHistogram(Arr));
        }

        long end = System.nanoTime();
        System.out.println((end - start)/Math.pow(10, 6));
        return Max;
    }

    private static int maxAreaHistogram(int[] Arr){
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
