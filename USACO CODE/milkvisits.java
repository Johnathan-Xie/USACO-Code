 /*ID: johnath8
 LANG: JAVA
 TASK: milkvisits
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class milkvisits
{
    static int N;
    static int M;
    static int[] comp;
    static ArrayList<ArrayList<Integer>> adj;
    static String[] types;
    static int counter=0;
    public static void dfs(int at)
    {
        if(comp[at]==counter)
            return;
        comp[at]=counter;
        for(Integer i:adj.get(at))
        {
            if(types[at].equals(types[i])) dfs(i);
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("milkvisits.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        comp=new int[N];
        Arrays.fill(comp, -1);
        adj=new ArrayList<ArrayList<Integer>>();
        types=new String[N];
        String s=f.readLine();
        for(int i=0; i<N; i++) types[i]=(s.charAt(i)+"");
        for(int i=0; i<N; i++) adj.add(new ArrayList<Integer>());
        for(int i=0; i<N-1; i++)
        {
            StringTokenizer roadSt=new StringTokenizer(f.readLine());
            int from=Integer.parseInt(roadSt.nextToken())-1;
            int to=Integer.parseInt(roadSt.nextToken())-1;
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        
        for(int i=0; i<comp.length; i++)
        {
            if(comp[i]<0)
            {
                dfs(i);
                counter++;
            }
        }
        //System.out.println(Arrays.toString(comp));
        for(int i=0; i<M; i++)
        {
            StringTokenizer friendSt=new StringTokenizer(f.readLine());
            int start=Integer.parseInt(friendSt.nextToken())-1;
            int to=Integer.parseInt(friendSt.nextToken())-1;
            String type=friendSt.nextToken();
            if(types[start].equals(type) || comp[start]!=comp[to]) out.print("1");
            else out.print("0");
        }
        out.close();
    }
}
