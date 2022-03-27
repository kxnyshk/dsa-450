import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _22LgFactorial {

    // https://www.geeksforgeeks.org/factorial-large-number/
    
    public static void main(String[] args) {
        
        int N = 100;
        ArrayList<Integer> L = new ArrayList<Integer>();

        L = factorial(N);
        System.out.println(Arrays.toString(L.toArray()));
    }

    private static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> L = new ArrayList<Integer>();

        L.add(1);

        for(int i=2; i<=N; i++){
            int carry = 0;
            for(int j=0; j<L.size(); j++){
                int val = ((L.get(j) * i) + carry);
                L.set(j, (val % 10));
                carry = (val / 10);
            }

            while(carry != 0){
                L.add(carry % 10);
                carry /= 10;
            }
        }

        Collections.reverse(L);
        return L;
    }
}
