public class _18keypadSeq {

    // https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1
    // TC : O(N)
    // SC : O(N)

    private static final String[] Keypad = {"2", "22", "222",
                                            "3", "33", "333",
                                            "4", "44", "444",
                                            "5", "55", "555",
                                            "6", "66", "666",
                                            "7", "77", "777", "7777",
                                            "8", "88", "888",
                                            "9", "99", "999", "9999"};
    
    public static void main(String[] args) {
        
        String S = "KANISHK";
        System.out.println(KeypadSequence(S).toString());
    }

    private static String KeypadSequence(String S){
        String SEQ = "";
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == ' '){
                SEQ += "0";
            } else {
                int IDX = (int) S.charAt(i);
                SEQ += Keypad[IDX - 'A'];
            }
        }

        return SEQ;
    }
}
