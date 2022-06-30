public class _36removeAdjacent {

    // https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1/
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        String s = "ocvvcolop";
        System.out.println(RemoveAdjacent(s));
    }

    private static String RemoveAdjacent(String s){
        // debug-1 System.out.println("String rcvd -> " + s);
        if((s == null) || (s.length() <= 0)){return "";}
        if(s.length() == 1){return s;}
        if(s.length() == 2){return (s.charAt(0) == s.charAt(1)) ? "" : s;}

        StringBuilder temp = new StringBuilder();
        boolean flag = false;
        int i = 1;
        
        while(i < s.length()){
            if(s.charAt(i) != s.charAt(i - 1)){
                temp.append(s.charAt(i - 1));
                if(i == (s.length() - 1)){
                    temp.append(s.charAt(i));
                } i++;
            }
            else {
                char repeatedChar = s.charAt(i);
                while((i < s.length()) && (s.charAt(i) == repeatedChar)){
                    i++;
                } if(i == (s.length() - 1)){
                    temp.append(s.charAt(i));
                } i++; flag = true;
            }
        }

        if(!flag){
            return temp.toString();
        }
        // debug-2 System.out.println("String sent -> " + temp.toString());
        return RemoveAdjacent(temp.toString());
    }
}
