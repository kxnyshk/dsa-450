public class _4checkRot {

    // https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
    // TC : O(N)
    // SC : O(1)

    public static void main(String[] args) {
        
        String S1 = "CDABA";
        String S2 = "ABACD";

        System.out.println(checkRotation(S1, S2));
    }

    private static boolean checkRotation(String S1, String S2){
        if((S1 == null) || (S2 == null) || (S1.length() != S2.length())){
            return false;
        }
        if((S1.length() == 1) && (S2.length() == 1)){
            return (S1.charAt(0) == S2.charAt(0)) ? true : false;
        }

        String mutable = S1;
        int count = 0;

        while(count <= (S1.length() - 1)){
            mutable = mutable.substring((1), mutable.length()) + mutable.charAt(0);
            if(mutable.equals(S2)){
                return true;
            }
            count++;
            System.out.println(mutable);
        }

        return false;
    }
}
