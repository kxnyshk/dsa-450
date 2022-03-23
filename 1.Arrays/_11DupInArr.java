public class _11DupInArr {

    // https://www.geeksforgeeks.org/find-duplicates-constant-array-elements-0-n-1-o1-space/
    // https://leetcode.com/problems/find-the-duplicate-number/

    // Flyod's Cycle Detection Algo (ref): https://www.geeksforgeeks.org/floyds-cycle-finding-algorithm/
    
    public static void main(String[] args) {
        
        int[] Arr = {1,2,3,4,5,6,3};
        
        int ans = Duplicate(Arr);
        System.out.println(ans);
    }

    private static int Duplicate(int[] Arr){
        if((Arr.length == 0) || (Arr.length == 1)){
            return -1;
        }
        if(Arr.length == 2){
            return (Arr[0] == Arr[1]) ? Arr[0] : -1; 
        }

        int slow = Arr[0];
        int fast = Arr[Arr[0]];

        while(slow != fast){
            slow = Arr[slow];
            fast = Arr[Arr[fast]];
        }

        slow = 0;
        while(slow != fast){
            slow = Arr[slow];
            fast = Arr[fast];
        }

        return slow;
    }
}
