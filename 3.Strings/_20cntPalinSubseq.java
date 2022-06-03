public class _20cntPalinSubseq {

    // https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1/
    // TN : O(N*N)
    // SC : O(N*N)

    private static final long mod = (long) (Math.pow(10, 9) + 7);
    
    public static void main(String[] args) {
        
        String s = "abccbc";
        System.out.println(CountPalindromeSubSequence(s));
    }

    private static long CountPalindromeSubSequence(String str){
        if(str.length() == 1){
            return (long) 1;
        }
        if(str.length() == 2){
            return (str.charAt(0) == str.charAt(1) ? (long) 3 : (long) 2);
        }

        long[][] dp = new long[str.length()][str.length()];

        int i = 0;
        while((i < dp.length)){
            dp[i][i++] = (long) 1;
        }

        int i1 = 0;
        int j1 = 1;
        while((i1 < (dp.length - 1)) && (j1 < dp.length)){
            if(str.charAt(i1) == str.charAt(j1)){
                dp[i1][j1] = (long) 3;
            } else { dp[i1][j1] = (long) 2; }
            i1++; j1++;
        }

        int i2 = 0;
        int j2 = 2;
        int iCounter = 2;
        while((j2 < dp.length)){
            int i3 = i2;
            int j3 = j2;
            while((i3 < (dp.length - iCounter)) && (j3 < dp.length)){
                if(str.charAt(i3) == str.charAt(j3)){
                    long temp1 = dp[i3][j3 - 1] % mod;
                    long temp2 = dp[i3 + 1][j3] % mod;
                    long temp3 = (temp1 + temp2) % mod;
                    long temp4 = (temp3 + 1) % mod;
                    dp[i3][j3] = temp4 % mod;
                } else { 
                    long temp1 = dp[i3][j3 - 1] % mod;
                    long temp2 = dp[i3 + 1][j3] % mod;
                    long temp3 = dp[i3 + 1][j3 - 1] % mod;
                    long temp4 = (temp1 + temp2) % mod;
                    long temp5 = (temp4 - temp3) % mod;
                    dp[i3][j3] = temp5 % mod; 
                }
                i3++; j3++;
            }
           j2++; iCounter++;
        }

        //    debug-1
        // for(int iP=0; iP<dp.length; iP++){
        //     for(int jP=0; jP<dp.length; jP++){
        //         System.out.print(dp[iP][jP] + " ");
        //     }
        //     System.out.println();
        // }

        return (dp[0][dp.length - 1] % mod);
    }
}

// failed test case
// String s = "mbcgepnkdqemhmkuqosgeonbcrphobcmbhrgppkfpdqckigsomktpsurknsospighufulqijcupisnuqcqfpuckrndmqeeklqfcrfnemeghmnlunlpslncqllmbebnoudihgpigrfbrqbcurmqnfroheqltkbnpocousjepehgppmblodppsqrglprtekmsqlqekhjseotocgkfcrkssmmenhitupdcoujscnetbrrcdoctqdfssupfnuolrobckseuromqsuoctmnbudnthrctndtrnietrkqbropugptpuhclftohuendhhnpnhqqkmksigbcrtrtjtmhonnumnnupgtntdhefushmrshselrdfqnoddmqqhjrjtknmokrlgdrcomnbjdlcothrhgsljreflusnnnrkckstoluhduguicfomgjkorgmujoonekscbikeshbqfqfrbcmspqphujltqebostmbkunhhhqmdqdqmfsbekeonmsiqsbomhmrtnqtmutrbmrlthhieihqjebklckemustsufbqmbjcqdtkdjscmdsrkkqdfojplektrsinjfbhmfoumqirfehdhgdkejefupstmhqesqobcqftpgbrckqrjqdosfjschbhbuobhriguipdkeeggbtecsqheelrqiqfdokqhrdsdcifnkulloeckeghochpdfjpqesqmqsngcbpngjurdsbhtsilkoiglbgmofnjuojtgjqnpgobmfehjnqbfmternugrhbnrgqusloiuusqogtqsclesqsmhjghqdtqkgikghflotgfmkdngklcorqlegpdidptohlgnnnflhtcmpcehogooflhujpichtknfqicpkjmgjjdnmtsprcueeolruiqjpeldelnukfitfgqsdejupshdtebtqfrqbtuttkldbuupidurhimnrmpdfjtbuinfchjormhissgpdbisugtrqqdiqekpnicpej";
