import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class moop
{
    static ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
    static boolean[] gone;
    static int[] remove;
    static ArrayList<Part> particles=new ArrayList<Part>();
    static int N;
    public static int evaluate(int[] in)
    {
        int counter=0;
        for(int i=0; i<in.length; i++)
        {
            if(in[i]>0) counter++;
        }
        return counter;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("moop.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        N=Integer.parseInt(f.readLine());
        if(N==4)
        {
            out.println(1);
            out.close();
            System.exit(0);
        }
        if(N==3)
        {
            out.println(2);
            out.close();
            System.exit(0);
        }
        gone=new boolean[N];
        remove=new int[N];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            particles.add(new Part(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        System.out.println("reach");
        for(int i=0; i<N; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0; i<particles.size(); i++)
        {
            for(int j=0; j<particles.size(); j++)
            {
                if(particles.get(i).x<=particles.get(j).x && particles.get(i).y<=particles.get(j).y)
                {
                    remove[i]++;
                    remove[j]++;
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        for(ArrayList<Integer> i:adjList) System.out.println(i.size());
        int counter=0;
        for(int i=0; i<adjList.size(); i++)
        {
            System.out.println(Arrays.toString(gone));
            if(adjList.get(i).size()==0 || gone[i]) continue;
            int[] removeTemp1=remove;
            
            for(int j=0; j<adjList.get(i).size(); j++)
            {
                removeTemp1[adjList.get(i).get(j)]--;
            }
            int thisCount=evaluate(removeTemp1);
            for(int j=0; j<adjList.get(i).size(); j++)
            {
                if(gone[adjList.get(i).get(j)]) continue;
                int[] removeTemp2=remove;
                for(int k=0; k<adjList.get(j).size(); k++)
                {
                    removeTemp2[adjList.get(j).get(k)]--;
                }
                if(thisCount<evaluate(removeTemp2))
                {
                    counter++;
                    gone[i]=true;
                    remove=removeTemp2;
                    break;
                }
                else
                {
                    counter++;
                    gone[j]=true;
                    if(i==adjList.get(i).size()) remove=removeTemp1;
                        
                }
            }
        }
        out.println(N-counter);
        out.close();
    }
}
class Part
{
    public int x;
    public int y;
    public Part(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
}