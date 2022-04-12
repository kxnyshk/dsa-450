import java.util.Arrays;
import java.util.stream.IntStream;

public class _28tripletSum {

    // https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
    
    public static void main(String[] args) {
        
        int[] Arr1 = {12,3,4,1,6,9}; int S1 = 24;
        // int[] Arr2 = {1,2,3,4,5};    int S2 = 9;
    
        triplet T = new triplet();
        T = triplets(Arr1, S1);
        System.out.println(T.t1 + " | " +  T.t2 + " | " + T.t3);
    }

    private static triplet triplets(int[] Arr, int S){
        triplet T = new triplet();
        
        if(Arr.length < 3){
            return null;
        }
        if(Arr.length == 3){
            if(IntStream.of(Arr).sum() == S){
                T.t1 = Arr[0];
                T.t2 = Arr[1];
                T.t3 = Arr[2];
                return T;
            }
            else{
                return null;
            }
        }

        Arrays.sort(Arr);
        boolean found = false;

        for(int i=0; i<Arr.length-2; i++){
            int left = (i + 1);
            int right = (Arr.length - 1);

            while(left < right){
                int Sum = (Arr[i] + Arr[left] + Arr[right]);
                
                if(Sum == S){
                    T.t1 = Arr[i];
                    T.t2 = Arr[left];
                    T.t3 = Arr[right];
                    found = true;
                    break;
                }
                else if(Sum < S){
                    left++;
                }
                else{
                    right--;
                }
            }

            if(found){
                break;
            }
        }

        return T;
    }
}

class triplet{
    int t1;
    int t2;
    int t3;
}
