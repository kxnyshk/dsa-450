import java.util.HashMap;
import java.util.HashSet;

public class _31smallestWindow {

    // https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1/
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        String str = "aabcbcdbca";
        System.out.println(MinWindow(str));
    }

    private static int MinWindow(String str){
        HashSet<Character> uniqueSet = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            uniqueSet.add(ch);
        }

        int distinct = uniqueSet.size();
        int len = Integer.MAX_VALUE;
        int n = str.length();
        int count = 0;
        int head = -1;
        int tail = 0;

        HashMap<Character, Integer> freqMap = new HashMap<>();
        while(tail < n){
            while(((head + 1) < n) && (count < distinct)){
                ++head;
                char ch = str.charAt(head);
                freqMap.put(ch, (freqMap.getOrDefault(ch, 0) + 1));
                if(freqMap.get(ch) == 1){
                    count++;
                }
            } 
            
            if(count == distinct){
                len = Math.min(len, (head - tail + 1));
            } 
            
            if(head >= tail){
                char ch = str.charAt(tail);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) -  1);
                if(freqMap.get(ch) == 0){
                    count--;
                } tail++;
                if(count == distinct){
                    len = Math.min(len, (head - tail + 1)); 
                }
            }
        }

        return len;
    }
}
