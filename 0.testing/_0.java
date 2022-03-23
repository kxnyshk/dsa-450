import java.util.Scanner;

public class _0 {
    
    private static Scanner s = new Scanner(System.in);
    
	public static void main (String[] args) {
	    
	    int T = s.nextInt();
	    
	    while(T > 0){
	        int N = s.nextInt();
	        int[] Arr = new int[N];
	        for(int i=0; i<N; i++){
	            int A = s.nextInt();
	            Arr[i] = A;
	        }
	        
	        int start = 0;
	        int end = Arr.length-1;
	        
	        while(start < end){
	            int temp = Arr[start];
	            Arr[start] = Arr[end];
	            Arr[end] = temp;
	            start++;
	            end--;
	        }
            for(int i=0; i<Arr.length; i++){
                System.out.print(Arr[i] + " ");
            }
            System.out.println();
            
            T--;
	    }
	}
}
