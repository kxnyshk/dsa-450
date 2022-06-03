import java.util.ArrayList;
import java.util.Arrays;

public class _22_2DGridChar {

    // https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1/
    // GFG TC Error

    private static ArrayList<Integer> L = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        
        // String target = "GEEKS";
        // char[][] mat = {{'D','D','D','G','D','D'},
        //                 {'B','B','D','E','B','S'},
        //                 {'B','S','K','E','B','K'},
        //                 {'D','D','D','D','D','E'},
        //                 {'D','D','D','D','D','E'},
        //                 {'D','D','D','D','D','G'}};
        
        // String target = "abc";
        // char[][] mat = {{'a','b','c'},
        //                 {'d','r','f'},
        //                 {'g','h','i'}};
        
        // String target = "abe";
        // char[][] mat = {{'a','b','a','b'},
        //                 {'a','b','e','b'},
        //                 {'e','b','e','b'}};

        // String target = "dcb";
        // char[][] mat = {{'b','b','d','d','e','d','b','d','d'},
        //                 {'b','c','b','c','e','c','a','d','c'},
        //                 {'a','e','b','e','d','b','e','e','d'},
        //                 {'d','c','d','e','c','b','b','b','e'},
        //                 {'b','c','a','e','c','c','d','a','a'},
        //                 {'a','a','c','b','a','c','a','c','a'},
        //                 {'a','c','b','d','b','d','b','e','c'}};
        // [[0 5] [2 4] [4 6]]

        String target = "dea";
        char[][] mat = {{'d','d','d'},
                        {'e','e','d'},
                        {'b','e','b'}};

        System.out.println(Arrays.deepToString(WordSearch(target, mat)));
    }

    // UP, DOWN, LEFT, RIGHT PATTERN SEARCH
    private static int FindWord1(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1;
            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord1((i + 1), j, target, mat, Idx);
            }
            mat[i][j] = temp;
        }      
        return count;
    }
    private static int FindWord2(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1;
            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord2((i - 1), j, target, mat, Idx);
            }
            mat[i][j] = temp;
        }      
        return count;
    }
    private static int FindWord3(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1;
            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord3(i, (j + 1), target, mat, Idx);
            }
            mat[i][j] = temp;
        }      
        return count;
    }
    private static int FindWord4(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1;
            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord4(i, (j - 1), target, mat, Idx);
            }
            mat[i][j] = temp;
        }      
        return count;
    }

    // DIAGONAL PATTERN SEARCH
    private static int FindWord5(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1; 
            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord5((i - 1), (j - 1), target, mat, Idx);
            }
            mat[i][j] = temp;
        }
        return count;
    }
    private static int FindWord6(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1; 
            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord6((i - 1), (j + 1), target, mat, Idx);
            }
            mat[i][j] = temp;
        }
        return count;
    }
    private static int FindWord7(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1; 
            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord7((i + 1), (j - 1), target, mat, Idx);
            }
            mat[i][j] = temp;
        }
        return count;
    }
    private static int FindWord8(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;
        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1; 
            if(Idx == target.length()){
                count += 1;
            } else {
                count += count += FindWord8((i + 1), (j + 1), target, mat, Idx);
            }
            mat[i][j] = temp;
        }
        return count;
    }      

    private static int[][] WordSearch(String target, char[][] mat){
        int Idx = 0;
        // int Count = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                int temp1 = FindWord1(i, j, target, mat, Idx);
                int temp2 = FindWord2(i, j, target, mat, Idx);
                int temp3 = FindWord3(i, j, target, mat, Idx);
                int temp4 = FindWord4(i, j, target, mat, Idx);
                int temp5 = FindWord5(i, j, target, mat, Idx);
                int temp6 = FindWord6(i, j, target, mat, Idx);
                int temp7 = FindWord7(i, j, target, mat, Idx);
                int temp8 = FindWord8(i, j, target, mat, Idx);

                if((temp1 != 0) || (temp2 != 0) || (temp3 != 0) || (temp4 != 0) || (temp5 != 0) || (temp6 != 0) || (temp7 != 0) || (temp8 != 0)){
                    L.add(i);
                    L.add(j);
                }
            }
        }
        
        if(!L.isEmpty()){
            int RC = 0;
            int[][] Arr = new int[L.size()/2][2];
            for(int i=0; i<L.size(); i+=2){
              Arr[RC][0] = L.get(i);
              Arr[RC++][1] = L.get(i + 1);
            }
            return Arr;
        } else {
            int[][] Arr = new int[1][1];
            Arr[0][0] = -1;
            return Arr;
        }
    }
}
