import java.util.Arrays;

public class _3 {
    
    public static void main(String[] args) {
        
        int[] arr = new int[10];
        arr[5] = 10;
        arr[0] += 1;
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}
