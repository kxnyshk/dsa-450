import java.util.ArrayList;
import java.util.Arrays;

public class _41printAllStrings {

    // https://practice.geeksforgeeks.org/problems/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/1
    // TC : O(M^N)
    // SC : O(M^N)
    
    public static void main(String[] args) {
        
        String[][] list = { {"you", "we"},
                            {"have", "are"},
                            {"sleep", "eat", "drink"} };
        ArrayList<ArrayList<String>> L = PrintAllStrings(list);
        for(ArrayList<String> l: L){
            System.out.println(l);
        }
    }

    private static void Recursive(String[][] list, int Row, String string, ArrayList<ArrayList<String>> L){
        if((list == null) || (list.length <= 0)){
            return;
        }
        if(list.length == 1){
            ArrayList<String> L1 = new ArrayList<>();
            L1.add(string);
            L.add(L1);
            return;
        }
        
        if(Row == (list.length - 1)){
            for(int i=0; i<list[Row].length; i++){
                StringBuilder temp = new StringBuilder();
                temp.append(string); temp.append(" "); temp.append(list[Row][i]);
                
                String[] strSplit = temp.toString().split(" ");
                ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));

                L.add(strList);
            } return;
        } else{
            for(int i=0; i<list[Row].length; i++){
                StringBuilder temp = new StringBuilder();
                temp.append(string); temp.append(" "); temp.append(list[Row][i]);
                Recursive(list, (Row + 1), temp.toString(), L);
            }
        }
    }

    private static ArrayList<ArrayList<String>> PrintAllStrings(String[][] list){
        ArrayList<ArrayList<String>> L = new ArrayList<ArrayList<String>>();
        
        for(int i=0; i<list[0].length; i++){
            StringBuilder temp = new StringBuilder();
            temp.append(list[0][i]);
            Recursive(list, (0 + 1), temp.toString(), L);
        }
        
        return L;
    }
}
