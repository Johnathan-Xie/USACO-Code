import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class socdist
{
    //Debugstatic Printer debug;
    static int N;
    static int M;
    static ArrayList<SDArea> pastures=new ArrayList<SDArea>();
    
    public static boolean valid(long D)
    {
        long next=pastures.get(0).start;
        int last=0;
        for(int i=0; i<N; i++)
        {
            //System.out.println("next "+next);
            //System.out.println("last "+last);
            boolean works=false;
            for(int j=last; j<pastures.size(); j++)
            {
                if(next>=pastures.get(j).start && next<=pastures.get(j).end)
                {
                    last=j;
                    next+=D;
                    works=true;
                    break;
                }
                if(pastures.get(j).start>next)
                {
                    last=j;
                    next=pastures.get(j).start+D;
                    works=true;
                    break;
                }
            }
            //System.out.println(i);
            if(!works) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException 
    {
        //Binary Search high
        BufferedReader f=new BufferedReader(new FileReader(new File("socdist.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        //Debugdebug=new Printer("where.debug");
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        for(int i=0; i<M; i++)
        {
            StringTokenizer aSt=new StringTokenizer(f.readLine());
            pastures.add(new SDArea(Long.parseLong(aSt.nextToken()), Long.parseLong(aSt.nextToken())));
        }
        
        Collections.sort(pastures);
        
        boolean method=false;
        long lhs=1;
        long rhs=(pastures.get(pastures.size()-1).end-pastures.get(0).start)/(N-1)+1;
        //System.out.println((pastures.get(pastures.size()-1).end-pastures.get(0).start));
        while(lhs<rhs)
        {
            long mid=(lhs+rhs+1)/2;
            System.out.println(lhs+ " " +rhs);
            if(valid(mid)) lhs=mid;
            else rhs=mid-1;
        }
        out.println(lhs);
        out.close();
    }
}
class SDArea implements Comparable<SDArea>
{
    public long start;
    public long end;
    public SDArea(long start, long end)
    {
        this.start=start;
        this.end=end;
    }
    public int compareTo(SDArea o)
    {
        if(this.start>o.start) return 1;
        else if(o.start>this.start) return -1;
        else return 0;
    }
}