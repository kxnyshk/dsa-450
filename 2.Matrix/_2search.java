public class _2search {

    // https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1/
    // https://leetcode.com/problems/search-a-2d-matrix/
    
    public static void main(String[] args) {
        
        int[][] M = {{1,3,5,7},
                     {10,11,16,20},
                     {23,30,34,60},};
        int T = 3;
        
        boolean found = Search(M, T);
        System.out.println(found);
    }

    private static boolean Search(int[][] M, int T){
        if(M == null){
            return false;
        }

        int i = 0;
        int j = (M[0].length - 1);

        while((i < M.length) && (j >= 0)){
            if(M[i][j] == T){
                return true;
            }
            else if(M[i][j] < T){
                i++;
            }
            else if(M[i][j] > T){
                j--;
            }
        }

        return false;
    }
}
