import java.util.Arrays;

public class _1firstLastIndex{

    // https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
    // https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x2041/1/
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    // TC : O(logN)
    // SC : O(N)

    public static void main(String[] args) {
        
        int[] Arr = {6, 9};
        int X = 9;
        System.out.println(Arrays.toString(IndexSearch(Arr, X)));
    }

    private static int BinarySearch(int[] Arr, int X, int start, int end, char indicator){
        int Idx = -1;
        while(start <= end){
            int mid = ((end - start)/2 + start);
            if(Arr[mid] == X){
                Idx = mid;
                if(indicator == 'L'){
                    end = (mid - 1);
                } else if(indicator == 'R'){
                    start = (mid + 1);
                }
            } else if(Arr[mid] > X){
                end = (mid - 1);
            } else {
                start = (mid + 1);
            }
        } return Idx;
    }

    private static int[] IndexSearch(int[] Arr, int X){
        int[] Res = {-1, -1};
        if((Arr == null) || (Arr.length <= 0)){
            return Res;
        }

        int start = 0;
        int mid = 0;
        int end = (Arr.length - 1);
        
        boolean flag = false;
        while(start <= end){
            mid = ((end - start)/2 + start);
            if(Arr[mid] == X){
                flag = true;
                Res[0] = mid; Res[1] = mid;
                break;
            } else if(Arr[mid] < X){
                start = (mid + 1);
            } else {
                end = (end - 1);
            }
        } 
        if(!flag){
            return Res;
        }

        if(((mid - 1) != -1) && (Arr[mid - 1] == X)){
            Res[0] = BinarySearch(Arr, X, 0, (mid - 1), 'L');
        } if(((mid + 1) != Arr.length) && (Arr[mid + 1] == X)){
            Res[1] = BinarySearch(Arr, X, (mid + 1), (Arr.length - 1), 'R');
        } return Res;
    }
}