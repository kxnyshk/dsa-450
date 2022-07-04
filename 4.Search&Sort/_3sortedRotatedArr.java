public class _3sortedRotatedArr {

    // https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1/
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    // https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array0959/1/?category
    // https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1/
    // https://practice.geeksforgeeks.org/problems/minimum-number-in-a-sorted-rotated-array-1587115620/1
    // https://practice.geeksforgeeks.org/problems/rotation4723/1
    // TC : O(logN)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {387, 691, 700, 702};
        int X = 909;
        System.out.println(findIndex(Arr, X));
    }

    private static int BinarySearch(int[] Arr, int X, int start, int end){
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } if(start == end){
            return (Arr[start] == X) ? start : -1;
        }

        while(start <= end){
            int mid = ((end - start)/2 + start);
            if(Arr[mid] == X){
                return mid;
            } else if(Arr[mid] > X){
                end = (mid - 1);
            } else {
                start = mid + 1;
            }
        } return -1;
    }

    private static int findIndex(int[] Arr, int X){
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } if(Arr.length == 1){
            return (Arr[0] == X) ? 0 : -1;
        }
        
        int p = findRotatedIndex(Arr);
        // System.out.println(p);

        if(p == 0){
            return BinarySearch(Arr, X, 0, (Arr.length - 1));
        } else if((X >= Arr[p]) && (X <= Arr[Arr.length - 1])){
            return BinarySearch(Arr, X, p, (Arr.length - 1));
        } else if((p != 0) && ((X >= Arr[0]) && (X <= Arr[(p - 1)]))){
            return BinarySearch(Arr, X, 0, (p - 1));
        } else {
            return -1;
        }
    }

    private static int findRotatedIndex(int[] Arr){
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } if(Arr.length == 1){
            return 0;
        } if(Arr.length == 2){
            return (Arr[0] > Arr[1])  ? 1 : 0;
        }

        int start = 0;
        int end = (Arr.length - 1);
        while(start <= end){
            int mid = ((end - start)/2 + start);
            int prev = (mid + Arr.length - 1) % Arr.length;
            int next = (mid + 1) % Arr.length;
            if((Arr[mid] < Arr[prev]) && (Arr[mid] < Arr[next])){
                return mid;
            } else if(Arr[mid] <= Arr[end]){
                end = prev;
            } else if(Arr[mid] >= Arr[start]){
                start = next;
            }
        } return -1;
    }
}
