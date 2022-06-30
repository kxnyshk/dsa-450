import java.util.HashMap;

public class _35smallStringWindow {
    
    // https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
    // https://leetcode.com/problems/minimum-window-substring/
    // TC : O(N)
    // SC : O(N)

    public static void main(String[] args) {
        
        String s = "adobecodebanc";
        String t = "abc";
        System.out.println(SmallestStringWindow(s, t));
    }

    private static String SmallestStringWindow(String s, String t){
        String Res = "";

        HashMap<Character, Integer> freqMapT = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            freqMapT.put(ch, (freqMapT.getOrDefault(ch, 0) + 1));
        }
        
        int count = 0;
        int desCount = t.length();
        HashMap<Character, Integer> freqMapS = new HashMap<>();
        
        int i = -1;
        int j = -1;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while((i < (s.length() - 1)) && (count < desCount)){
                i++;
                char ch = s.charAt(i);
                freqMapS.put(ch, (freqMapS.getOrDefault(ch, 0) + 1));
                
                if(freqMapS.getOrDefault(ch, 0) <= freqMapT.getOrDefault(ch, 0)){
                    count++;
                } f1 = true;
            }
            
            while((j < i) && (count == desCount)){
                String temp = s.substring((j + 1), (i + 1));
                if((Res.length() == 0) || (temp.length() < Res.length())){
                    Res = temp;
                }
                
                j++;
                char ch = s.charAt(j);
                if(freqMapS.get(ch) == 1){
                    freqMapS.remove(ch);
                } else {
                    freqMapS.put(ch, (freqMapS.get(ch) - 1));
                }
                
                if(freqMapS.getOrDefault(ch, 0) < freqMapT.getOrDefault(ch, 0)){
                    count--;
                } f2 = true;
            }
            
            if(!f1 && !f2){break;}
        }
        
        return (Res == "") ? "-1" : Res;
    }
}
