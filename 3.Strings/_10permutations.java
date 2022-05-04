public class _10permutations {

    // https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
    // TC: O(N*N!)
    // SC: O(1)

    public static void main(String[] args) {
        
        String S = "abc";
        String E = "";
        PrintAllPermutations(S, E);
    }

    private static void PrintAllPermutations(String S, String E){
        if(S.length() == 0){
            System.out.println(E);
            return;
        }

        for(int i=0; i<S.length(); i++){
            char C = S.charAt(i);
            String L = S.substring(0, i);
            String R = S.substring(i + 1);

            String J = L + R;
            PrintAllPermutations(J, (E + C));
        }
    }
}
