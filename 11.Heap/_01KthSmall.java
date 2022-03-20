import java.util.Collections;
import java.util.PriorityQueue;

public class _01KthSmall {
    
    // https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

    public static void main(String[] args) {
        
        int[] Arr = {45,58,89,96,65,54,41,12,23,37};
        int K = 5;
        int el = KSmallest(K, Arr);
        System.out.println("Smallest " + K + "th element: " + el);
    }

    private static int KSmallest(int K, int[] Arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // max heap

        for(int i=0; i<K; i++){
            pq.add(Arr[i]);
        }

        for(int i=K; i<Arr.length; i++){
            if(Arr[i] < pq.peek()){
                pq.poll();
                pq.add(Arr[i]);
            }
        }
        
        return pq.peek();
    }
}
