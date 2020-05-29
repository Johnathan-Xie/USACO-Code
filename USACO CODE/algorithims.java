/*ID: johnath8
 LANG: JAVA
 TASK: algorithims
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class algorithims
{
    static int numOfNodes;/*numOfNodes for Dijkstra*/ 
    static ArrayList<ArrayList<Integer>> adjList;/*adjacency List for Dijkstra and floodFill*/
    static int[][] graph;/*adjacency array for Dijkstra*/
    static int[] comp;/*same type indicator for floodFill*/
    static int label;/*++ at the start of each new floodFill*/
    public static boolean works(int in)
    {
        //placeholder
        return false;
    }
    public static Node[] Dijkstra(int in) //returns the distance to each node in the distances array(requires Node class; algorithim from butter.java)
    {
        Node[] distances=new Node[numOfNodes];
        for(int i=0; i<numOfNodes; i++) distances[i]=new Node(i);
        
        PriorityQueue<Node> queue=new PriorityQueue<Node>();
        distances[in].dist=0;
        queue.add(distances[in]);
        while(!queue.isEmpty())
        {
            Node tempNode=queue.poll();
            int id=tempNode.ID;
            if(!distances[id].visited)
            {
                distances[id].visited=true;
                int siz=adjList.get(id).size();
                for(int i=0; i<siz; i++)
                {
                    int to=adjList.get(id).get(i);
                    //if(graph[id][to]==Integer.MAX_VALUE) continue;
                    
                    if(!distances[to].visited || distances[to].dist>distances[id].dist+graph[id][to])
                    {
                        distances[to].dist=Math.min(distances[to].dist, distances[id].dist+graph[id][to]);
                        queue.add(distances[to]);
                    }
                }
            }
        }
        return distances;
    }
    public static void flood(int at)
    {
        if(comp[at]==label)
            return;
        for(Integer i: adjList.get(at)) if(true/*replace with condition*/) flood(i);
    }
    public static int gcd(int a, int b)
    {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    public static int lcm(int a, int b)
    {
        return a*(b/gcd(a, b));
    }
    public static int lcmArr(int[] in)
    {
        int result=in[0];
        for(int i=1; i<in.length; i++) result=lcm(result, in[i]);
        return result;
    }
    public static int gcdArr(int[] in)
    {
        int result=in[0];
        for(int i=1; i<in.length; i++) result=gcd(result, in[i]);
        return result;
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
    public static ArrayList<Integer> strToIntArrList(int numOfTokens, String in)
    {
        int prev=0;
        ArrayList<Integer> out=new ArrayList<Integer>();
        int val;
        for(int i=0; i<numOfTokens; i++)
        {
            val=in.indexOf(" ", prev);
            if(val<0)
                val=in.length();
            out.add(Integer.parseInt(in.substring(prev, val)));
            prev=val+1;
        }
        return out;
    }
    public static int BSH(int lowBound, int highBound)
    {
        boolean method=false;
        int lhs=lowBound;
        int rhs=highBound;
        while(lhs<rhs-1)
        {
            
            int mid=(lhs+rhs+1)/2;
            if(works(mid)) rhs=mid;
            else lhs=mid;
        }
        if(works(rhs))
            return rhs;
        return lhs;
    }
    public static int BSL(int lowBound, int highBound)
    {
        boolean method=false;
        int lhs=lowBound;
        int rhs=highBound;
        while(lhs<rhs-1)
        {
            int mid=(lhs+rhs+1)/2;
            if(works(mid)) lhs=mid;
            else rhs=mid;
        }
        if(works(lhs))
            return lhs;
        return rhs;
    }
}
class Node implements Comparable<Node>
{
    public boolean visited;
    public int ID; //Node number
    public int dist;
    public Node(int ID)
    {
        this.visited=false;
        this.ID=ID;
        this.dist=Integer.MAX_VALUE;
    }
    public int compareTo(Node a)
    {
        if(this.ID==a.ID)
            return this.ID-a.ID;
        else
            return this.dist-a.dist;
    }
}/*
class SLComparator implements Comparator<ClassName>
{
    public int compare(ClassName one, ClassName two)
    {
        return one.val-two.val;
    }
}*/
    

