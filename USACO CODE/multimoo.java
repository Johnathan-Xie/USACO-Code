import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class multimoo
{
    
    // debugstatic Printer debug;
    static int[][] comp;
    static int[][] vals;
    static ArrayList<MultiMooNode> groups=new ArrayList<MultiMooNode>();
    static int N;
    static int size;
    static boolean[] visited;
    public static void floodFill(int r, int c, int id)
    {
        comp[r][c]=id;
        groups.get(id).size++;
        
        if(r+1<=N-1 && comp[r+1][c]!=id)
        {
            if(vals[r+1][c]==vals[r][c])
                floodFill(r+1, c, id);
            else if(comp[r+1][c]>=0)
            {
                groups.get(id).neighbors.add(comp[r+1][c]);
                groups.get(comp[r+1][c]).neighbors.add(id);
            }
        }
        if(c+1<=N-1 && comp[r][c+1]!=id)
        {
            if(vals[r][c+1]==vals[r][c])
                floodFill(r, c+1, id);
            else if(comp[r][c+1]>=0)
            {
                groups.get(id).neighbors.add(comp[r][c+1]);
                groups.get(comp[r][c+1]).neighbors.add(id);
            }
        }
        if(r-1>=0 && comp[r-1][c]!=id)
        {
            if(vals[r-1][c]==vals[r][c])
                floodFill(r-1, c, id);
            else if(comp[r-1][c]>=0)
            {
                groups.get(id).neighbors.add(comp[r-1][c]);
                groups.get(comp[r-1][c]).neighbors.add(id);
            }
        }
        if(c-1>=0 && comp[r][c-1]!=id)
        {
            if(vals[r][c-1]==vals[r][c])
                floodFill(r, c-1, id);
            else if(comp[r][c-1]>=0)
            {
                groups.get(id).neighbors.add(comp[r][c-1]);
                groups.get(comp[r][c-1]).neighbors.add(id);
            }
        }
        
    }
    public static int[] strToIntArr(int numOfTokens, String in)
    {
        int prev=0;
        int[] comp=new int[numOfTokens];
        int val;
        for(int i=0; i<numOfTokens; i++)
        {
            val=in.indexOf(" ", prev);
            if(val<0)
                val=in.length();
            comp[i]=Integer.parseInt(in.substring(prev, val));
            prev=val+1;
        }
        return comp;
    }
    public static void DFS(int val1, int val2, MultiMooNode at)
    {
        if(visited[at.id]) return;
        visited[at.id]=true;
        // debugSystem.out.println(at.id);
        size+=at.size;
        HashSet<Integer> tempNbr=new HashSet<Integer>(at.neighbors);
        for(Integer i:tempNbr)
        {
            if((groups.get(i).value==val1 || groups.get(i).value==val2) && at.neighbors.contains(i))
            {
                at.neighbors.remove(i);
                groups.get(i).neighbors.remove(at.id);
                DFS(val1, val2, groups.get(i));
            }
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("multimoo.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
        N=Integer.parseInt(f.readLine());
        comp=new int[N][N];
        vals=new int[N][N];
        
        for(int i=0; i<N; i++)
            vals[i]=strToIntArr(N, f.readLine());
        for(int i=0; i<N; i++) Arrays.fill(comp[i], -1);
        int counter=0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(comp[i][j]<0) 
                {
                    groups.add(new MultiMooNode(0, vals[i][j], counter));
                    floodFill(i, j, counter++);
                }
            }
        }
        visited=new boolean[groups.size()];
        //debug debug=new Printer("multimoo.debug");
        //debug debug.printInt(comp);
        int max1=0;
        for(int i=0; i<groups.size(); i++) max1=Math.max(max1, groups.get(i).size);
        out.println(max1);
        /* debug for(int i=0; i<groups.size(); i++)
        {
            System.out.println();
            System.out.println(groups.get(i).id);
            System.out.println("size: "+ groups.get(i).size);
            System.out.println("value: "+ groups.get(i).value);
            for(Integer j:groups.get(i).neighbors) System.out.print(j + " ");
            System.out.println();
                
        }*/ 
        int max2=0;
        for(int i=0; i<groups.size(); i++)
        {
            if(groups.get(i).neighbors.size()==0) continue;
            HashSet<Integer> temp=new HashSet<Integer>(groups.get(i).neighbors);
            
            for(Integer j:temp)
            {
                //debug System.out.println(i + " " + j);
                DFS(groups.get(i).value, groups.get(j).value, groups.get(i));
                Arrays.fill(visited, false);
                //debug System.out.println(size);
                //debug System.out.println();
                max2=Math.max(max2, size);
                size=0;
            }
        }
        out.println(max2);
        //debug debug.close();
        out.close();
    }
}
class MultiMooNode
{
    HashSet<Integer> neighbors=new HashSet<Integer>();
    int size;
    int value;
    int id;
    public MultiMooNode(int size, int value, int id)
    {
        this.size=size;
        this.value=value;
        this.id=id;
    }
}