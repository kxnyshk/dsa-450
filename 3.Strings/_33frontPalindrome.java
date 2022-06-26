public class _33frontPalindrome {

    // https://practice.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/1/
    // 605/622 TEST CASES
    // TC : >O(N)
    // SC : O(N)

    public static void main(String[] args) {
        
        String str = "qsjhbqd";
        System.out.println(MinCharacters(str));
    }

    private static boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0, j=(n - 1); i<=j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    private static int MinCharacters(String str){
        if((str == null) || (str.length() <= 0)){return -1;}
        if(str.length() == 1){return 0;}
        if(str.length() == 2){return (str.charAt(0) == str.charAt(1)) ? 0 : 1;}

        StringBuilder strBuild = new StringBuilder(str);
        int count = 0;

        while(str.length() > 0){
            if(isPalindrome(strBuild.toString())){
                break;
            } else{
                count++;
                strBuild.deleteCharAt(strBuild.length() - 1);
            }
        }

        return count;
    }
}