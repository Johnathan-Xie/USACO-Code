import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class fenceplan
{
    
    //Debug static Printer debug;
    static ArrayList<FPCow> adjList=new ArrayList<FPCow>();
    static boolean[] visited;
    static int maxX=0;
    static int maxY=0;
    static int minX=Integer.MAX_VALUE;
    static int minY=Integer.MAX_VALUE;
    public static void floodFill(int at)
    {
        if(visited[at]) return;
        visited[at]=true;
        
        maxX=Math.max(maxX, adjList.get(at).x);
        maxY=Math.max(maxY, adjList.get(at).y);
        minX=Math.min(minX, adjList.get(at).x);
        minY=Math.min(minY, adjList.get(at).y);
        for(Integer i:adjList.get(at).adj)
        {
            floodFill(i);
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("fenceplan.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken());
        visited=new boolean[N];
        for(int i=0; i<N; i++)
        {
            StringTokenizer stCow=new StringTokenizer(f.readLine());
            adjList.add(new FPCow(Integer.parseInt(stCow.nextToken()), Integer.parseInt(stCow.nextToken())));
        }
        for(int i=0; i<M; i++)
        {
            StringTokenizer adjSt=new StringTokenizer(f.readLine());
            int from=Integer.parseInt(adjSt.nextToken())-1;
            int to=Integer.parseInt(adjSt.nextToken())-1;
            adjList.get(to).adj.add(from);
            adjList.get(from).adj.add(to);
        }
        /*for(int i=0; i<adjList.size(); i++)
        {
            //DebugSystem.out.println(i);
            //DebugSystem.out.println(adjList.get(i).x);
            //DebugSystem.out.println(adjList.get(i).y);
            for(Integer j:adjList.get(i).adj)
                //DebugSystem.out.print(j+ " ");
            //DebugSystem.out.println("\n");
        }*/
            
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<N; i++)
        {
            if(!visited[i])
            {
                floodFill(i);
                //DebugSystem.out.println("i: " + i);
                //DebugSystem.out.println("maxX: " + maxX);
                //DebugSystem.out.println("maxY: " + maxY);
                //DebugSystem.out.println("minX: " + minX);
                //DebugSystem.out.println("minY: " + minY);
                //DebugSystem.out.println(Arrays.toString(visited));
                ans=Math.min(2*(maxX-minX)+2*(maxY-minY), ans);
                //DebugSystem.out.println(ans);
                maxX=0;
                maxY=0;
                minX=Integer.MAX_VALUE;
                minY=Integer.MAX_VALUE;
            }
        }
        out.println(ans);
        out.close();
    }
}
class FPCow
{
    HashSet<Integer> adj=new HashSet<Integer>();
    int x;
    int y;
    public FPCow(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
}