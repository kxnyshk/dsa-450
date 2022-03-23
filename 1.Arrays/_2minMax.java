public class _2minMax {

    // https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
    
    public static void main(String[] args) {
        
        int[] Arr = {-78,45,-96,89,12,45,-65};
        pair p = new pair();
        p = minMax(Arr);
        System.out.println("Min: " + p.min);
        System.out.println("Max: " + p.max);
    }

    private static pair minMax(int[] Arr){
        int start = 0;
        int end = Arr.length-1;

        pair p = new pair();
        p = recursive(start, end, Arr);
        return p;
    }

    private static pair recursive(int start, int end, int[] Arr){
        if(start == end){
            pair p1 = new pair();
            p1.min = Arr[start];
            p1.max = Arr[start];
            return p1;
        }

        if(start == end-1){
            pair p2 = new pair();
            if(Arr[start] >= Arr[end]){
                p2.min = Arr[end];
                p2.max = Arr[start];
                return p2;
            }
            else{
                p2.min = Arr[start];
                p2.max = Arr[end];
                return p2;
            }
        }

        pair temp1 = new pair();
        pair temp2 = new pair();
        pair finalp = new pair();

        int mid = (start + (end-start)/2);
        temp1 = recursive(start, mid, Arr);
        temp2 = recursive(mid+1, end, Arr);

        if(temp1.min <= temp2.min){
            finalp.min = temp1.min;
        }
        else{
            finalp.min = temp2.min;
        }

        if(temp1.max >= temp2.max){
            finalp.max = temp1.max;
        }
        else{
            finalp.max = temp2.max;
        }

        return finalp;
    }
}

class pair{
    int min;
    int max;
}
