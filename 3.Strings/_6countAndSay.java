public class _6countAndSay{

    // https://practice.geeksforgeeks.org/problems/decode-the-pattern1138/1/
    // https://leetcode.com/problems/count-and-say/

    // TC : O(N^2)
    // SC : O(1)

    public static void main(String[] args) {
        
        for(int i=1; i<=8; i++){
            int n  = i;
            System.out.println("n : " + n);
            System.out.println((countSay(n)));
        }
    }

    private static String countSay(int n){
        if(n == 2){
            return "11";
        }
        if(n == 1){
            return "1";
        }

        String var = countSay(n - 1);
        
        int i = 0;
        String say = "";

        while(i < var.length()){
            int j = i;
            int count = 0;

            while(j < var.length()){
                if(var.charAt(j) == var.charAt(i)){
                    count++;
                    j++;
                }
                else{
                    break;
                }
            }

            say += count;
            say += var.charAt(i);
            i = j;
        }

        
        return say;
    }
}