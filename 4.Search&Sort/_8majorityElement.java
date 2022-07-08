public class _8majorityElement{

    // https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1/
    // https://leetcode.com/problems/majority-element/
    // TC : O(N)
    // SC : O(1)

    public static void main(String[] args) {
        
        // int[] Arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        // int[] Arr = {3, 3, 4, 2, 4, 4, 2, 4};
        // int[] Arr = { 1, 1, 2, 1, 3, 5, 1 };
        // int[] Arr = { 1, 3, 3, 3, 2 };
        // int[] Arr = { 1, 3, 3, 1, 2 };
        int[] Arr = {2,2,2,2,5,5,2,3,3};
        System.out.println(MajorityElement(Arr));
    }

    private static boolean valid(int X, int[] Arr){
        int Count = 0;
        for(int i=0; i<Arr.length; i++){
            if(Arr[i] == X){
                Count++;
            }
        } if(Count > (Arr.length / 2)){
            return true;
        } else{
            return false;
        }
    }

    private static int MajorityElement(int[] Arr){
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } if(Arr.length == 1){
            return Arr[0];
        } if(Arr.length == 2){
            return (Arr[0] == Arr[1]) ? Arr[0] : -1;
        }

        int Count = 1;
        int Element = Arr[0];

        for(int i=1; i<Arr.length; i++){
            if(Count == 0){
                Count++; Element = Arr[i];
            } else{
                if(Arr[i] == Element){
                    Count++;
                } else {
                    Count --;
                }
            }    
        } if(valid(Element, Arr)){
            return Element;
        } else{
            return -1;
        }
    }
}