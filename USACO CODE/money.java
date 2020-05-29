/*ID: johnath8
 LANG: JAVA
 TASK: money
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class money
{
    static int v;
    static int n;
    static int[] vals;
    static long[] ways;
    
    public static void countWays()
    {
        ways[0]=1;
        for(int i=0; i<vals.length; i++)
        {
            for(int j=0; j<ways.length; j++)
            {
                int coin=vals[i];
                if(coin<=j)
                    ways[j]+=ways[j-coin];
            }
        }
    }
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("money.in"));
        PrintWriter out = new PrintWriter(new File("money.out"));
        v=f.nextInt();
        n=f.nextInt();
        vals=new int[v];
        ways=new long[n+1];
        for(int i=0; i<v; i++)
            vals[i]=f.nextInt();
        countWays();
        out.println(ways[n]);
        out.close();
        System.exit(0);
    }
}
