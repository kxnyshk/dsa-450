public class _5minMaxPair {

    // https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1/
    // TC : O(N)
    // SC : O(logN)
    
    public static void main(String[] args) {
        int[] Arr = {1000, 11, 445, 10, 330, 3000};
        pair p = findMinMax(Arr);
        System.out.println(p.min);
        System.out.println(p.max);
    }

    private static pair BinarySearch(int[] Arr, int start, int end){
        if(start == end){
            pair p = new pair();
            p.min = Arr[start]; p.max = Arr[end];
            return p;
        } if(start == (end - 1)){
            pair p = new pair();
            if(Arr[start] < Arr[end]){
                p.min = Arr[start]; p.max = Arr[end];
            } else {
                p.min = Arr[end]; p.max = Arr[start];
            } return p;
        }

        int mid = ((end - start)/2 + start);
        pair p = new pair();
        pair p1 = BinarySearch(Arr, start, mid);
        pair p2 = BinarySearch(Arr, (mid + 1), end);

        if(p1.min < p2.min){
            p.min = p1.min;
        } else {
            p.min = p2.min;
        } if(p1.max > p2.max){
            p.max = p1.max;
        } else {
            p.max = p2.max;
        } return p;
    }

    private static pair findMinMax(int[] Arr){
        pair p = new pair();
        p.min = -1; p.max = -1;
        
        p = BinarySearch(Arr, 0, (Arr.length - 1)); 
        return p;
    }
}

class pair{
    int min;
    int max;
}
