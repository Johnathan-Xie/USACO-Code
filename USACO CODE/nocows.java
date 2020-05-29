/*ID: johnath8
 LANG: JAVA
 TASK: nocows
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class nocows
{
    
    public static void main(String[] args) throws IOException 
    {
        Scanner in = new Scanner(new File("nocows.in"));
        PrintWriter out = new PrintWriter(new File("nocows.out"));
        int N = in.nextInt();
        int K = in.nextInt();
        long [][] dp = new long[N+1][K+1];
        in.close();
        for(int k = 1; k <= K; k++)
        {
            dp[1][k] = 1;
            for(int n = 2; n <= N; n++)
            { 
                for(int p = 1; p <= n - 2; p++)
                { 
                    dp[n][k] += dp[p][k - 1] * dp[n - p - 1][k - 1];
                    dp[n][k] %= 9901;
                }
            }
        }
        
        out.println((dp[N][K] - dp[N][K - 1] + 9901) % 9901);
        out.close();
        System.exit(0);
    }
}
