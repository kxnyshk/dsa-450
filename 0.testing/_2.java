public class _2 {
    
    public static void main(String[] args) {
        
    }

}

class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class Compute 
{
    static pair getMinMax(long a[], long n)  
    {
        long start = 0;
        long end = n-1;

        pair p = new pair(0,0);
        p = recursive(start, end, a);
        return p;
    }
    
    private static pair recursive(long start, long end, long[] Arr){
        if(start == end){
            pair p1 = new pair(0,0);
            p1.first = Arr[(int) start];
            p1.second = Arr[(int) start];
            return p1;
        }

        if(start == end-1){
            pair p2 = new pair(0,0);
            if(Arr[(int) start] >= Arr[(int) end]){
                p2.first = Arr[(int) end];
                p2.second = Arr[(int) start];
                return p2;
            }
            else{
                p2.first = Arr[(int) start];
                p2.second = Arr[(int) end];
                return p2;
            }
        }

        pair temp1 = new pair(0,0);
        pair temp2 = new pair(0,0);
        pair finalp = new pair(0,0);

        long mid = (start + (end-start)/2);
        temp1 = recursive(start, mid, Arr);
        temp2 = recursive(mid+1, end, Arr);

        if(temp1.first <= temp2.first){
            finalp.first = temp1.first;
        }
        else{
            finalp.first = temp2.first;
        }

        if(temp1.second >= temp2.second){
            finalp.second = temp1.second;
        }
        else{
            finalp.second = temp2.second;
        }

        return finalp;
    }
}