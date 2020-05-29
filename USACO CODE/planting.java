import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class planting
{
    
    static int N;
    static ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException 
    {
        //go to each point and floodfill out with max distance 2
        BufferedReader f=new BufferedReader(new FileReader(new File("planting.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        N=Integer.parseInt(f.readLine());
        for(int i=0; i<N; i++) adjList.add(new ArrayList<Integer>());
        for(int i=0; i<N-1; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            int from=Integer.parseInt(st.nextToken())-1;
            int to=Integer.parseInt(st.nextToken())-1;
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        int max=0;
        for(int i=0; i<N; i++) max=Math.max(max, adjList.get(i).size());
        out.println(max+1);
        out.close();
    }
}