/*ID: johnath8
 LANG: JAVA
 TASK: fence
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class fence
{
    static ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> tour=new ArrayList<Integer>();
    static ArrayList<Integer> best=null;
    public static void findTour(int start)
    {
        
        tour.clear();
        for(int i=0; i<500; i++) temp.add(new ArrayList<Integer>());
        
        for(int i=0; i<adjList.size(); i++)
        {
            temp.get(i).addAll(adjList.get(i));
        }
        circuit(start);
        Collections.reverse(tour);
        System.out.println(tour);
        System.out.println(best);
        System.out.println(better(best,tour));
        if(better(best, tour))  best=tour;
        System.out.println(best);
        
           
    }
    public static void circuit(int at)//Needs adjList
    {
        
        if(adjList.get(at).size()==0) tour.add(at);
            
        else
        {
            while(temp.get(at).size()>0)
            {
                int to=temp.get(at).remove(0);
                temp.get(to).remove(new Integer(at));
                circuit(to);
            }
            tour.add(at);
        }
    }
    public static boolean better(ArrayList<Integer> best, ArrayList<Integer> temp)
    {
        if(temp==null) return false;
        if(best==null) return true;
        for(int i=0; i<best.size(); i++)
        {
            if(best.get(i)<temp.get(i))
                return false;
            if(temp.get(i)<best.get(i))
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("fence.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
        int F=Integer.parseInt(f.readLine());
        for(int i=0; i<500; i++) adjList.add(new ArrayList<Integer>());
        for(int i=0; i<F; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            int node1=Integer.parseInt(st.nextToken())-1;
            int node2=Integer.parseInt(st.nextToken())-1;
            adjList.get(node1).add(node2);
            
            adjList.get(node2).add(node1);
            
        }
        boolean odd=false;
        for(int i=0; i<500; i++)
        {
            Collections.sort(adjList.get(i));
            if(adjList.get(i).size()%2==1)
            {
                
                odd=true;
            }
        }
        
        for(int i=0; i<500; i++)
        {
            if(adjList.get(i).size()==0) continue;
            if((odd && adjList.get(i).size()%2==0) || best!=null && i>best.get(0)) continue;
            
            findTour(i);
        }
        for(int i=0; i<best.size(); i++) out.println(best.get(i)+1);
        out.close();
    }
}
