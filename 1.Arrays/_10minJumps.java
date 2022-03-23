public class _10minJumps{

    // https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/

    public static void main(String[] args) {
        
        int[] Arr = {1,3,5,8,9,2,6,7,6,8,9};
        
        int min = Jumps(Arr);
        System.out.println(min);
    }

    private static int Jumps(int[] Arr){
        if(Arr.length == 1){
            return 0;
        }
        if((Arr[0] == 0) || (Arr.length == 0)){
            return -1;
        }

        int range = Arr[0];
        int steps = Arr[0];
        int jumps = 1;

        for(int i=1; i<Arr.length; i++){
            if(i == Arr.length-1){
                return jumps;
            }

            range = Math.max(range, (i + Arr[i]));
            steps--;

            if(steps == 0){
                jumps++;
                if(i >= range){
                    return -1;
                }
                steps = range-i;
            }
        }

        return -1;
    }
}