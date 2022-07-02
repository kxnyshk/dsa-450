import java.util.HashSet;

public class _38customerSim {

    // https://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
    // TC : O(N)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        int Computers = 1;
        String Customers = "ABCBCADEED";
        System.out.println(runCustomerSimulation(Computers, Customers));
    }

    private static int runCustomerSimulation(int Com, String Cus){
        HashSet<Character> Customers = new HashSet<>();
        int notGet = 0;

        for(int i=0; i<Cus.length(); i++){
            char ch = Cus.charAt(i);
            if(!Customers.contains(ch)){
                if(Customers.size() >= Com){
                    notGet++;
                } Customers.add(ch);
            } else if(Customers.contains(ch)){
                Customers.remove(ch);
            }
        }

        return notGet;
    }
}
