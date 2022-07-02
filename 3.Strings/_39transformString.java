import java.util.HashMap;

public class _39transformString {

    // https://practice.geeksforgeeks.org/problems/b6b3297ccfb1ad5f66a9c2b92979170417adf114/1/
    // https://practice.geeksforgeeks.org/problems/transform-string5648/1
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        String A = "abbc";
        String B = "addc";
        System.out.println(TransformString(A, B));
    }

    private static int TransformString(String A, String B){
        if(A.length() != B.length()){
            return -1;
        }

        HashMap<Character, Integer> hashA = new HashMap<>();
        HashMap<Character, Integer> hashB = new HashMap<>();
        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            hashA.put(ch, (hashA.getOrDefault(ch, 0) + 1));
        }
        for(int j=0; j<B.length(); j++){
            char ch = B.charAt(j);
            hashB.put(ch, (hashB.getOrDefault(ch, 0) + 1));
        }
        if(!hashA.equals(hashB)){
            return -1;
        }

        int i = (A.length() - 1);
        int j = (B.length() - 1);
        int count = 0;

        while((i >= 0) && (j >= 0)){
            if(A.charAt(i) == B.charAt(j)){
                i--; j--;
            } else {
                count++; i--;
            }
        }

        return count;
    }
}
