public class _26FlipsBinary {

    // https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        String S = "0001010111";
        System.out.println(BinaryFlips(S));
    }

    private static int FlipCount(String S, char even, int odd){
        int count = 0;
        for(int i=0; i<S.length(); i++){
            if((((i % 2) == 0) && (S.charAt(i) != even)) || (((i % 2) != 0) && (S.charAt(i) != odd))){
                count++;
            }
        }
        return count;
    }

    private static int BinaryFlips(String S){
        if((S == null) || (S.length() <= 1)){
            return 0;
        }
        if(S.length() == 2){
            return (S.charAt(0) == S.charAt(1)) ? 1 : 0;
        }
        
        return Math.min(FlipCount(S, '0', '1'), FlipCount(S, '1', '0'));
    }
}
