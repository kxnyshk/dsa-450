import java.util.Arrays;

public class _5validShuffle {
    
    public static void main(String[] args) {
        
        String S1 = "XY";
        String S2 = "12";
        String[] Arr = {"1XY2", "Y1X2", "Y21XX"};

        arrayTraverser(S1, S2, Arr);
    }

    private static boolean validShuffle(String S1, String S2, String Shuffle){
        if((S1 == null) || (S2 == null) || (Shuffle == null)){
            return false;
        }
        if((S1.length() + S2.length() != Shuffle.length())){
            return false;
        }

        String newS1 = stringSorter(S1);
        String newS2 = stringSorter(S2);
        String newShuffle = stringSorter(Shuffle);
        
        int i=0;
        int j=0;
        int k=0;

        while(k < newShuffle.length()){

            if((i < newS1.length()) && (newS1.charAt(i) == newShuffle.charAt(k))){
                i++;
            }
            else if((j < newS2.length()) && (newS2.charAt(j) == newShuffle.charAt(k))){
                j++;
            }
            else{
                return false;
            }
            k++;
        }

        if((i < newS1.length()) || (j < newS2.length())){
            return false;
        }

        return true;
    }

    private static String stringSorter(String S){
        char[] Char1 = S.toCharArray();
        Arrays.sort(Char1);
        S = String.valueOf(Char1);

        return S;
    }

    private static void arrayTraverser(String S1, String S2, String[] Arr){
        for(int i=0; i<Arr.length; i++){
            System.out.println(validShuffle(S1, S2, Arr[i]));
        }
    }
}
