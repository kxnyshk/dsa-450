// import java.util.ArrayList;
import java.util.HashMap;

public class _17RabinKarp {

    private static HashMap<Character, Integer> Map = new HashMap<>();
    // private static final int R = 26;
    static {
        HashMapPopulate();
    }
    
    public static void main(String[] args) {
        
        // String txt = "GEEKS FOR GEEKS";
        // String pat = "GEEKS";

        // System.out.println(RabinKarp(txt, pat).toString());
    }

    // private static ArrayList<Integer> RabinKarp(String txt, String pat){
    //     int i = 0;
    //     int j = pat.length();

    //     while(j < txt.length()){
    //         // int HashLeft = HashForIdx();
    //         // int HashMiddle = HashForRange();
    //         // int HashRight = HashForIdx();
    //     }
    // }

    // private static int HashInitial(String txt, String pat){
    //     int HashValue = 0;
    //     int pow = (pat.length() - 1);
    //     for(int i=0; i<pat.length(); i++){
    //         int CurrValue = (int) (txt.charAt(i)*(Math.pow(R, pow)));
    //         HashValue += CurrValue;
    //     }
    //     return HashValue;
    // }

    private static void HashMapPopulate(){
        int start = 65;
        int end = 90;
        int val = 1;

        for(int i=start; i<=end; i++){
            Character c = (char) i;
            Map.put(c, val++);
        }
    }
}
