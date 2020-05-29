/*ID: johnath8
 LANG: JAVA
 TASK: clocktree
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class clocktree
{
    static int N;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> edges=new ArrayList<>();
    static int[] q=new int[N];
    public static int[] strToIntArr(String in, int numOfTokens)
    {
        int prev=0;
        int[] comp=new int[numOfTokens];
        int val;
        for(int i=0; i<numOfTokens; i++)
        {
            val=in.indexOf(" ", prev);
            if(val<0)
                val=in.length();
            //System.out.println(prev + " " + val);
            comp[i]=Integer.parseInt(in.substring(prev, val));
            prev=val+1;
        }
        return comp;
    }
    public static void dfs(int distance, int to)
    {
        dist[to]=distance;
        for(Integer i:edges.get(to))
        {
            edges.get(i).remove(edges.get(i).indexOf(to));
            dfs(distance+1, i);
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("clocktree.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
        int N=Integer.parseInt(f.readLine());
        int[] clockStart=strToIntArr(f.readLine(), N);
        //System.out.println(Arrays.toString(clockStart));
        dist=new int[N];
        for(int i=0; i<N; i++) edges.add(new ArrayList<Integer>());
        
        while(f.ready())
        {
            StringTokenizer edgeSt=new StringTokenizer(f.readLine());
            int from=Integer.parseInt(edgeSt.nextToken())-1;
            int to=Integer.parseInt(edgeSt.nextToken())-1;
            edges.get(from).add(to);
            edges.get(to).add(from);
        }
        dfs(0, 0);
        //System.out.println(Arrays.toString(dist));
        int s0=0;
        int s1=0;
        int n0=0;
        int n1=0;
        for(int i=0; i<N; i++)
        {
            if(dist[i]%2==1)
            {
                s1+=clockStart[i];
                n1++;
            }
            else
            {
                s0+=clockStart[i];
                n0++;
            }
        }
        
        if(s0%12==s1%12)
            out.println(N);
        else if((s0+1)%12==s1%12)
            out.println(n1);
        else if(s0%12==(s1+1)%12)
            out.println(n0);
        else
            out.println(0);
        out.close();
    }
}
