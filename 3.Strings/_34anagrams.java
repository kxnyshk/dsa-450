import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _34anagrams {

    // https://practice.geeksforgeeks.org/problems/print-anagrams-together/1
    // https://leetcode.com/problems/group-anagrams/
    // TC : O(N*M)
    // SC : O(N*M)
    
    public static void main(String[] args) {
        
        String[] string_list = {"act","god","cat","dog","tac"};
        System.out.println(groupAnagrams(string_list).toString());
    }

    private static List<List<String>> groupAnagrams(String[] string_list){
        HashMap<HashMap<Character, Integer>, ArrayList<String>> Map = new HashMap<>();
        
        for(String str: string_list){
            HashMap<Character, Integer> freqMap = new HashMap<>();
            for(char ch: str.toCharArray()){
                freqMap.put(ch, (freqMap.getOrDefault(ch, 0) + 1));
            }

            if(!Map.containsKey(freqMap)){
                ArrayList<String> L = new ArrayList<>();
                L.add(str);
                Map.put(freqMap, L);
            } else {
                ArrayList<String> L = Map.get(freqMap);
                L.add(str);
            }
        }

        List<List<String>> Res = new ArrayList<>();
        for(ArrayList<String> L: Map.values()){
            Res.add(L);
        } return Res;
    }
}
