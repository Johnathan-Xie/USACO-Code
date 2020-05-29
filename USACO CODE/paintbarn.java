import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class paintbarn
{
    //static Printer debug;
    static int[][] dp=new int[1001][1001];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("paintbarn.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++)
        {
            StringTokenizer rectSt=new StringTokenizer(f.readLine());
            int x1=Integer.parseInt(rectSt.nextToken());
            int y1=Integer.parseInt(rectSt.nextToken());
            int x2=Integer.parseInt(rectSt.nextToken());
            int y2=Integer.parseInt(rectSt.nextToken());
            dp[x1][y1]++;
            dp[x1][y2]--;
            dp[x2][y1]--;
            dp[x2][y2]++;
        }
        int ans=0;
        for(int i=0; i<1000; i++)
        {
            for(int j=0; j<1000; j++)
            {
                if(i-1>=0) dp[i][j]+=dp[i-1][j];
                if(j-1>=0) dp[i][j]+=dp[i][j-1];
                if(i-1>=0 && j-1>=0) dp[i][j]-=dp[i-1][j-1];
                if(dp[i][j]==K) ans++;
            }
        }
        out.println(ans);
        out.close();
    }
}