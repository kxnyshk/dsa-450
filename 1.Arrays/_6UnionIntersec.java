import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _6UnionIntersec {

    // https://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
    
    public static void main(String[] args) {
        
        // int[] Arr1 = {1,3,4,5,7};
        // int[] Arr2 = {2,3,5,6};
        int[] Arr1 = {2,5,6};
        int[] Arr2 = {4,6,8,10} ;

        Set<Integer> union = new HashSet<Integer>();
        Set<Integer> inter = new HashSet<Integer>();

        union = unionArray(Arr1, Arr2);
        inter = intersectArray(Arr1, Arr2);

        System.out.print(union);
        System.out.print(inter);
    }

    private static Set<Integer> unionArray(int[] Arr1, int[] Arr2){
        Set<Integer> union = new HashSet<Integer>();
        
        int i = 0;
        int j = 0;
    
        while((i < Arr1.length) && (j < Arr2.length)){   
            if(Arr1[i] < Arr2[j]){
                union.add(Arr1[i++]);
            }
            else if(Arr1[i] > Arr2[j]){
                union.add(Arr2[j++]);
            }
            else{
                union.add(Arr1[i++]);
                j++;
            }
        }

        while(i < Arr1.length){
            union.add(Arr1[i++]);
        }
        while(j < Arr2.length){
            union.add(Arr2[j++]);
        }

        return union;
    }

    private static Set<Integer> intersectArray(int[] Arr1, int[] Arr2){
        Set<Integer> inter = new HashSet<Integer>();

        Arrays.sort(Arr1);
        Arrays.sort(Arr2);

        int i = 0;
        int j = 0;

        while((i < Arr1.length) && (j < Arr2.length)){   
            if(Arr1[i] < Arr2[j]){
                i++;
            }
            else if(Arr1[i] > Arr2[j]){
                j++;
            }
            else{
                inter.add(Arr1[i++]);
                j++;
            }
        }

        return inter;
    }
}
