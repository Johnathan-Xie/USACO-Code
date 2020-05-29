/*ID: johnath8
 LANG: JAVA
 TASK: wormsort
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class wormsort
{
    static ArrayList<Wormhole>[] edges;
    static Queue<Integer> stack=new LinkedList<Integer>();
    static int[] comps;
    static int[] cowStart;
    static int[] cowTemp;
    static int N;
    static int M;
    //debug: static Printer debug;
    static PrintWriter debugPrinter;
    public static boolean valid(int lowest)
    {
        Arrays.fill(comps, -1);
        int label=0;
        for(int i=0; i<comps.length; i++)
        {
            if(comps[i]<0)
            {
                //dfs(i, label++, lowest);
                label++;
                stack.add(i);
                while(!stack.isEmpty())
                {
                    int curr=stack.poll();
                    if(comps[curr]==label)
                        continue;
                    comps[curr]=label;
                    for(Wormhole w:edges[curr])
                    {
                        if(w.width>=lowest)
                            stack.add(w.to);
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(comps));
        for(int i=0; i<N; i++)
        {
            if(comps[i]!=comps[cowStart[i]])
                return false;
        }
        return true;
    }
    public static void dfs(int curr, int label, int lowest)
    {
        if(comps[curr]==label)
            return;
        comps[curr]=label;
        for(Wormhole i:edges[curr]) 
        {
            if(i.width>=lowest)
                dfs(i.to, label, lowest);
        }
    }
    /*
    public static boolean works(int lowest) throws IOException
    {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
        boolean[][] adjMatrix=new boolean[N][N];
        //for(int i=0; i<N; i++) adjMatrix[i][i]=true;
        //HashSet<Integer> visited=new HashSet<Integer>();
        for(int i=0; i<N; i++) adjList.add(new ArrayList<Integer>());
        for(int i=0; i<wormholes.size(); i++)
        {
            if(wormholes.get(i).width>=lowest)
            {
                adjList.get(wormholes.get(i).start).add(wormholes.get(i).end);
                adjList.get(wormholes.get(i).end).add(wormholes.get(i).start);
            }
        }
        //for(ArrayList<Integer> a:adjList) debugPrinter.print(a.size()+" ");
        
        for(int i=0; i<adjList.size(); i++)
        {
            
                System.out.println(i);
            Queue<Integer> queue=new LinkedList<Integer>();
            ArrayList<Integer> connected=new ArrayList<Integer>();
            queue.add(i);
            connected.add(i);
            while(!queue.isEmpty())
            {
                int curr=queue.poll();
                int size=adjList.get(curr).size();
                for(int j=0; j<size; j++)
                {
                    int to=adjList.get(curr).remove(0);
                    connected.add(to);
                    queue.add(to);
                }
            }
            for(int a=0; a<connected.size(); a++)
            {
                for(int b=0; b<connected.size(); b++)
                {
                    adjMatrix[connected.get(a)][connected.get(b)]=true;
                }
            }
        }
        //debug:debugPrinter.println(lowest);
        //debug:debug.printBoolean(adjMatrix);
        boolean out=true;
        for(int i=0; i<N; i++)
        {
            if(!adjMatrix[i][cowStart[i]])
            {
                out=false;
                break;
            }
        }
        return out;
    }*/
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("wormsort.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
        debug:debugPrinter=new PrintWriter(new BufferedWriter(new FileWriter("wormsort.debug")));
        //debug:debug=new Printer(debugPrinter);
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken()); //cows
        M=Integer.parseInt(st.nextToken()); //wormholes
        //debug:System.out.println(N+" "+M);
        cowTemp=new int[N];
        cowStart=new int[N];
        edges=new ArrayList[N];
        comps=new int[N];
        StringTokenizer cowStartSt=new StringTokenizer(f.readLine());
        for(int i=0; i<N; i++) cowStart[i]=Integer.parseInt(cowStartSt.nextToken())-1;
        //System.out.println(Arrays.toString(cowTemp));
        //for(int i=0; i<N; i++) cowStart[cowTemp[i]]=i;
        //System.out.println(Arrays.toString(cowStart));
        for(int i=0; i<N; i++) edges[i]=(new ArrayList<Wormhole>());
        for(int i=0; i<M; i++)
        {
            StringTokenizer wormholeSt=new StringTokenizer(f.readLine());
            int from=Integer.parseInt(wormholeSt.nextToken())-1;
            int to=Integer.parseInt(wormholeSt.nextToken())-1;
            int width=Integer.parseInt(wormholeSt.nextToken());
            edges[from].add(new Wormhole(to, width));
            edges[to].add(new Wormhole(from, width));
        }
        
        int rhs=1000000001;
        int lhs=1;
        //valid(500000000);
        while(lhs<rhs)
        {
            int mid=(rhs+lhs+1)/2;
            if(valid(mid)) lhs=mid;
            else rhs=mid-1;
            System.out.println(lhs+ " "+rhs);
        }
        if(lhs>1000000000) lhs=-1;
        
        out.println(lhs);
        //debug:debug.end();
        out.close();
    }
}
class Wormhole
{
    
    public int to;
    public int width;
    public Wormhole(int to, int width)
    {
        this.width=width;
        this.to=to;
    }
}
