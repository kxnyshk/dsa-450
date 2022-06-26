import java.util.HashMap;
import java.util.PriorityQueue;

public class _32reArrangeString {

    // https://practice.geeksforgeeks.org/problems/rearrange-characters4649/1/
    // https://leetcode.com/problems/reorganize-string/
    // TC : O(NlogN)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        String str = "geeksforgeeks";
        System.out.println(reArrangeString(str));
    }

    private static String reArrangeString(String str){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c: str.toCharArray()){
            freqMap.put(c, (freqMap.getOrDefault(c, 0) + 1));
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> (freqMap.get(b) - freqMap.get(a)));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder res = new StringBuilder();
        while(maxHeap.size() > 1){
            char curr = maxHeap.remove();
            char next = maxHeap.remove();
            res.append(curr);
            res.append(next);

            freqMap.put(curr, (freqMap.get(curr) - 1));
            freqMap.put(next, (freqMap.get(next) - 1));
            if(freqMap.get(curr) > 0){maxHeap.add(curr);}
            if(freqMap.get(next) > 0){maxHeap.add(next);}
        }

        if(!maxHeap.isEmpty()){
            char last = maxHeap.remove();
            if(freqMap.get(last) > 1){
                return "-1";
            } res.append(last);
        }

        return res.toString();
    }
}
