import java.util.HashMap;

public class _3dupInStr {
    
    // https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
    // TC : O(N*log(N))
    // SC : O(N)

    public static void main(String[] args) {
        
        String S = "test string";
        printDuplicates(S);
    }

    private static void printDuplicates(String S){
        if(S.length() <= 1){
            return;
        }

        HashMap<Character, Integer> HM = new HashMap<Character, Integer>();
        
        for(int i=0; i<S.length(); i++){
            if(!HM.containsKey(S.charAt(i))){
                HM.put(S.charAt(i), 1);
            }
            else{
                HM.put(S.charAt(i), (HM.get(S.charAt(i)) + 1));
            }
        }

        HM.forEach((key, value) -> {
            if (value > 1) {
                System.out.println(key + " : " + value);
            }
       });
    }
}
