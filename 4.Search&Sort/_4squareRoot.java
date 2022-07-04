public class _4squareRoot {

    // https://practice.geeksforgeeks.org/problems/square-root/1
    // https://leetcode.com/problems/sqrtx/
    // TC : O(logN)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int X = 20148714;
        int Limit = X;
        while(X <= Limit){
            System.out.println(X + " : " + sqaureRoot(X)); X++;
        }
    }

    private static int BinarySearch(long X, long start, long end){
        long root = -1;
        while(start <= end){
            long mid = ((end - start)/2 + start);
            long square = (mid*mid);
            if(square <= (long) X){
                root = mid;
                start = (mid + 1);
            } else if(square > X){
                end = (mid - 1);
            }
        } return (int) root;
    }

    private static int sqaureRoot(int X){
        if(X == 0){return 0;}
        if(X == 1){return 1;}
        if(X < 0){return -1;}

        return BinarySearch(X, 1, X/2);
    }
}
