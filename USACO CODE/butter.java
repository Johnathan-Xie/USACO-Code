/*ID: johnath8
 LANG: JAVA
 TASK: butter
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class butter
{
    static int N;
    static int P;
    static int C;
    static int[][] graph;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] cows;
    public static void main(String[] args) throws IOException 
    {
        long start=System.currentTimeMillis();
        BufferedReader f=new BufferedReader(new FileReader(new File("butter.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken());/*Cows*/ P=Integer.parseInt(st.nextToken());/*Pastures*/ C=Integer.parseInt(st.nextToken()); /*Paths*/
        
        int[][] adj=new int[C][C];
        cows=new int[N];
        for(int i=0; i<N; i++) cows[i]=Integer.parseInt(f.readLine())-1;
        
        edges=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<C; i++) edges.add(new ArrayList<Integer>());
        graph=new int[P][P];
        for(int i=0; i<P; i++)
        {
            for(int j=0; j<P; j++)
                graph[i][j]=Integer.MAX_VALUE;
            graph[i][i]=0;
        }
        for(int i=0; i<C; i++)//parsing paths
        {
            
            StringTokenizer temp=new StringTokenizer(f.readLine());
            int from=Integer.parseInt(temp.nextToken());
            int to=Integer.parseInt(temp.nextToken());
            int dist=Integer.parseInt(temp.nextToken());
            //For adjacency matrix which is used for recording distance
            graph[from-1][to-1]=dist;
            graph[to-1][from-1]=dist;
            //For adjacency list which is used for Dijkstra
            edges.get(from-1).add(to-1);
            edges.get(to-1).add(from-1);
                
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<P; i++) min=Math.min(min, Dijkstra(i));
        out.println(min);
        out.close();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static int Dijkstra(int in)
    {
        Node[] distances=new Node[P];
        for(int i=0; i<P; i++) distances[i]=new Node(i);
        
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
                int siz=edges.get(id).size();
                for(int i=0; i<siz; i++)
                {
                    int to=edges.get(id).get(i);
                    //if(graph[id][to]==Integer.MAX_VALUE) continue;
                    
                    if(!distances[to].visited || distances[to].dist>distances[id].dist+graph[id][to])
                    {
                        distances[to].dist=Math.min(distances[to].dist, distances[id].dist+graph[id][to]);
                        queue.add(distances[to]);
                    }
                }
            }
        }
        int total=0;
        for(int i=0; i<N; i++) total+=distances[cows[i]].dist;
        return total;
    }
}

