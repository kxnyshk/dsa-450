import java.util.Arrays;

public class _10 {
    
    public static void main(String[] args) {
        
        stringSorter("hello", "world", "wtf");
    }

    private static void stringSorter(String S1, String S2, String Shuffle){
        char[] Char1 = S1.toCharArray();
        char[] Char2 = S2.toCharArray();
        char[] CharS = Shuffle.toCharArray();

        Arrays.sort(Char1);
        Arrays.sort(Char2);
        Arrays.sort(CharS);

        S1 = String.valueOf(Char1);
        S2 = String.valueOf(Char2);
        Shuffle = String.valueOf(CharS);

        System.out.println(S1);
        System.out.println(S2);
        System.out.println(Shuffle);
    }
}
