import java.util.Stack;

public class _15balParenth{

    // https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
    // https://leetcode.com/problems/valid-parentheses/
    // TC : O(N)
    // SC : O(N)

    public static void main(String[] args) {
        
        String x = "[()]{}{[()()]()}";
        System.out.println(isValid(x));
    }

    private static boolean isValid(String x){
        Stack<Character> S = new Stack<Character>();
        boolean valid = true;

        for(int i=0; i<x.length(); i++){
            if((x.charAt(i) == '(') || (x.charAt(i) == '{') || (x.charAt(i) == '[')){
                S.push(x.charAt(i));
            } else if (x.charAt(i) == ')'){
                if((!S.isEmpty()) && (S.peek() == '(')){
                    S.pop();
                } else { 
                    valid = false;
                    break; 
                }
            } else if (x.charAt(i) == '}'){
                if((!S.isEmpty()) && (S.peek() == '{')){
                    S.pop();
                } else { 
                    valid = false;
                    break; 
                }
            } else if (x.charAt(i) == ']'){
                if((!S.isEmpty()) && (S.peek() == '[')){
                    S.pop();
                } else { 
                    valid = false;
                    break; 
                }
            }
        }

        if(!S.isEmpty()){
            return false;
        } else{
            return valid;
        }
    }
}