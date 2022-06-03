public class _24RomaToDec {

    // https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1/
    // TC : O(N)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        String str = "XXIII";
        System.out.println(RomanToDecimal(str));
    }

    private static int RomanToDecimal(String str){
        int DecVal = 0;
        
        for(int i=(str.length() - 1); i>=0; i--){
            if(i == (str.length() - 1)){
                DecVal += RomanValue(str.charAt(i));
                // Debug
                // System.out.println(DecVal);
            } else {
                if(((str.charAt(i) == 'I') || (str.charAt(i) == 'X') || (str.charAt(i) == 'C')) && (RomanValue(str.charAt(i)) < RomanValue(str.charAt(i + 1)))){
                    if(str.charAt(i) == 'I'){
                        DecVal -= RomanValue('I');
                        // Debug
                        // System.out.println(DecVal);
                    } else if (str.charAt(i) == 'X'){
                        DecVal -= RomanValue('X');
                        // Debug
                        // System.out.println(DecVal);
                    } else if (str.charAt(i) == 'C'){
                        DecVal -= RomanValue('C');
                        // Debug
                        // System.out.println(DecVal);
                    }
                } else {
                    DecVal += RomanValue(str.charAt(i));
                    // Debug
                    // System.out.println(DecVal);
                }
            }
        }

        return DecVal;
    }

    private static int RomanValue(char C){
        if(C == 'I'){
            return 1;
        }
        else if(C == 'V'){
            return 5;
        }
        else if(C == 'X'){
            return 10;
        }
        else if(C == 'L'){
            return 50;
        }
        else if(C == 'C'){
            return 100;
        }
        else if(C == 'D'){
            return 500;
        }
        else {
            return 1000;
        }
    }
}
