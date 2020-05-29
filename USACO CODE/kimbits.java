/*ID: johnath8
 LANG: JAVA
 TASK: kimbits
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class kimbits
{
    static int n;
    static int l;
    static long i;
    static long[][] dp;
    static PrintWriter out;
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("kimbits.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
        n=f.nextInt(); //length
        l=f.nextInt(); //num of 1-bits
        i=f.nextLong(); //index of returned String
        boolean cont=true;
        long[][] dp=new long[n+1][l+1];
        for(int j=0; j<n+1; j++) dp[j][0]=1;
        for(int j=0; j<l+1; j++) dp[0][j]=1;
        
        for(int j=1; j<n+1; j++)
        {
            for(int k=1; k<l+1; k++)
            {
                if(j>=k)
                    dp[j][k]=dp[j-1][k-1]+dp[j-1][k];
                else
                    dp[j][k]=dp[j][j];
            }
        }
        System.out.println(dp[0][0]);
        printBit(n, l, i, dp);
        out.print("\n");
        out.close();
    }
    
    public static void printBit(int a, int b, long c, long[][] dp) throws IOException
    {
        
        if(a<b)
            b=a;
        if(dp[a][b]==c)
        {
            for(int i=0; i<b; i++)
                out.print("1");
            for(int i=0; i<a-b; i++)
                out.print("0");
        }
        else{
            if(c<=dp[a-1][b])
            {
                out.print("0");
                printBit(a-1, b, c, dp);
            }
            else
            {
                out.print("1");
                printBit(a-1, b-1, c-dp[a-1][b], dp);
            }
        }
        
        
    }
}
