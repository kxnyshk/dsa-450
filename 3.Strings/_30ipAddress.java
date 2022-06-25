import java.util.ArrayList;

public class _30ipAddress {

    // https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1/
    // https://leetcode.com/problems/restore-ip-addresses/
    // TC : O(N^3)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        String s = "25525511135";
        System.out.println(generateIpAdresses(s).toString());
    }

    private static boolean isValid(String ip){
        if(ip.length() > 3){
            return false;
        }
        if((ip.charAt(0) == '0') && (ip.length() > 1)){
            return false;
        }
        long longIP = Long.valueOf(ip);
        return ((longIP >= 0) && (longIP <= 255));
    }

    private static ArrayList<String> generateIpAdresses(String s){
        ArrayList<String> storeIp = new ArrayList<>();
        if((s == null) || (s.length() <= 0)){
            return storeIp;
        }
        
        for(int i=1; i<=3 && i<s.length(); i++){
            String first = s.substring(0, i);
            
            if(isValid(first)){
                for(int j=1; j<=3 && (i+j)<s.length(); j++){
                    String second = s.substring(i, (i + j));

                    if(isValid(second)){
                        for(int k=1; k<=3 && (i+j+k)<s.length(); k++){
                            String third = s.substring((i+j), (i + j + k));
                            String fourth = s.substring(i + j + k);

                            if(isValid(third) && isValid(fourth)){
                                String ip = first + "." + second + "." + third + "." + fourth;
                                storeIp.add(ip);
                            }
                        }
                    }
                }
            }
        }

        return storeIp;
    }
}
