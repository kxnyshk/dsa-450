public class _36removeConsecutive {
    
    // https://practice.geeksforgeeks.org/problems/consecutive-elements2306/1
    // TC : O(N)
    // SC : O(N)

    public static void main(String[] args) {
        
        String S = "aabbaa";
        System.out.println(RemoveConsecutive(S));
    }

    private static String RemoveConsecutive(String S){
        StringBuilder Res = new StringBuilder();
        char prev = ' ';
        
        for(char ch: S.toCharArray()){
            if(Res.toString() == ""){
                Res.append(ch);
            } else {
                if(ch != prev){
                    Res.append(ch);
                }
            } prev = ch;
        }
        
        return Res.toString();
    }
}
