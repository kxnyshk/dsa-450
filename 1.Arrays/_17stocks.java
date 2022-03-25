public class _17stocks {
    
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    
    public static void main(String[] args) {
        
        int[] Stocks = {7,1,5,3,6,4};
        
        int profit = maxProfit(Stocks);
        System.out.println(profit);
    }

    private static int maxProfit(int[] Arr){
        int min = Arr[0];
        int max = Arr[0];
        int profit = (max - min); 
        
        for(int i=1; i<Arr.length; i++){
            if(Arr[i] < min){
                min = Arr[i];
                max = Arr[i];
            }
            if(Arr[i] > max){
                max = Arr[i];
            }
            if((max - min) > profit){
                profit = (max - min);
            }
        }
        
        return profit;
    }
}
