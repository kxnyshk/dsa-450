public class _21wrdSrch2DArr {

    // https://practice.geeksforgeeks.org/problems/count-occurences-of-a-given-word-in-a-2-d-array/1/
    // TC : O(N*M*(4^Len))
    // SC : O(1)
    
    public static void main(String[] args) {
        
        String target = "GEEKS";
        char[][] mat = {{'D','D','D','G','D','D'},
                        {'B','B','D','E','B','S'},
                        {'B','S','K','E','B','K'},
                        {'D','D','D','D','D','E'},
                        {'D','D','D','D','D','E'},
                        {'D','D','D','D','D','G'}};

        System.out.println(WordSearch(target, mat));
    }

    private static int FindWord(int i, int j, String target, char[][] mat, int Idx){
        int count = 0;

        if(((i >= 0) && (i < mat.length)) && ((j >= 0) && (j < mat[0].length)) && (target.charAt(Idx) == mat[i][j])){
            char temp = target.charAt(Idx);
            mat[i][j] = '0';
            Idx += 1;

            if(Idx == target.length()){
                count += 1;
            } else {
                count += FindWord((i + 1), j, target, mat, Idx);
                count += FindWord((i - 1), j, target, mat, Idx);
                count += FindWord(i, (j + 1), target, mat, Idx);
                count += FindWord(i, (j - 1), target, mat, Idx);
            }

            mat[i][j] = temp;
        }

        return count;
    }

    private static int WordSearch(String target, char[][] mat){
        int Idx = 0;
        int Count = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                Count += FindWord(i, j, target, mat, Idx);
            }
        }
        return Count;
    }
}
