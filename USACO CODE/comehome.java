/*ID: johnath8
 LANG: JAVA
 TASK: comehome
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class comehome
{
    static int[][] adj=new int[52][52];
    public static void print2DArray(int[][] in)
    {
        for(int i=0; i<in.length; i++)
        {
            System.out.println(Arrays.toString(in[i]));
        }
    }
    public static void intake(String in1, String in2, int val)
    {
        if(in1.equals(in2))
            return;
        String index="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int adj1=0;
        int adj2=0;
        for(int i=0; i<index.length(); i++)
        {
            if(in1.equals(index.charAt(i)+""))
            {
                adj1=i;
            }
            if(in2.equals(index.charAt(i)+""))
            {
                adj2=i;
            }
        }
        adj[adj1][adj2]=Math.min(adj[adj1][adj2], val);
        adj[adj2][adj1]=Math.min(adj[adj2][adj1], val);
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
        PrintWriter out = new PrintWriter(new File("comehome.out"));
        int n=Integer.parseInt(f.readLine());
        for(int i=0; i<52; i++)
        {
            for(int j=0; j<52; j++)
            {
                if(adj[i][j]==0)
                {
                    if(i!=j)
                        adj[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            intake(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        
        print2DArray(adj);
        for(int k=0; k<52; k++)
        {
            for(int i=0; i<52; i++)
            {
                for(int j=0; j<52; j++)
                {
                    if(adj[k][j]!=Integer.MAX_VALUE && adj[i][k]!=Integer.MAX_VALUE)
                    {
                        adj[i][j]=Math.min(adj[i][j], adj[k][j]+adj[i][k]);
                    }
                }
            }
        }
        System.out.println();
        print2DArray(adj);
        int ans=Integer.MAX_VALUE;
        int indexAns=0;
        String index="ABCDEFGHIJKLMNOPQRSTUVWXY";
        for(int i=26; i<51; i++)
        {
            if(ans>adj[i][51])
            {
                ans=adj[i][51];
                indexAns=i;
            }
        }
        
        out.println(index.charAt(indexAns-26)+" "+ans);
        out.close();
        //System.exit(0);
    }
}
