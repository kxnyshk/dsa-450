public class _11splitBinStr {

    // https://practice.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1/
    // TC : O(N)
    // SC : O(1)

    public static void main(String[] args) {
        
        // String S = "0100110101";
        String S = "001110010";
        // String S = "0111100010";
        System.out.println(BinaryStrings(S));
    }

    private static int BinaryStrings(String str){
        int x = 0;
        int y = 0;
        int c = 0;
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                x++;
            } else if(str.charAt(i) == '1'){ y++; }
            if(x == y){ c++;}
        }

        if(x == y){
            return c;
        } else{ return -1; }
    }
}
