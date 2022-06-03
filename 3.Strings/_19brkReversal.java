import java.util.Stack;

public class _19brkReversal{

    // https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1/
    // TN : O(N)
    // SC : O(N)

    public static void main(String[] args) {
        
        String s = "}{{}}{{{";
        System.out.println(BracketReversal(s));
    }

    private static int BracketReversal(String s){
        if((s.length()%2) != 0){
            return -1;
        }

        Stack<Character> S = new Stack<Character>();
        int openCounter = 0;
        int closeCounter = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '{'){
                S.push('{');
                openCounter++;
            } else if((s.charAt(i) == '}') && (!S.isEmpty()) && (S.peek() == '{')){
                S.pop();
                openCounter--;
            } else if(s.charAt(i) == '}'){
                closeCounter++;
            }
        }

        // debug-1
        // System.out.println(openCounter);
        // System.out.println(closeCounter);

        if((openCounter%2) == 0){
            if((closeCounter%2) == 0){
                return ((openCounter + closeCounter) / 2);
            } else { return (((closeCounter / 2) + 1) + (openCounter / 2)); }
        } else {
            if((closeCounter%2) != 0){
                return (((openCounter/2) + 1) + ((closeCounter/2) + 1));
            } else { return (((openCounter / 2) + 1) + (closeCounter / 2)); }
        }
    }
}