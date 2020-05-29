import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class mountains
{
    //static Printer debug;
    static ArrayList<Peak> peaks=new ArrayList<Peak>();
    static ArrayList<Peak> finalP=new ArrayList<Peak>();
    static int N;
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("mountains.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        N=Integer.parseInt(f.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer peakSt=new StringTokenizer(f.readLine());
            peaks.add(new Peak(Integer.parseInt(peakSt.nextToken()), Integer.parseInt(peakSt.nextToken())));
        }
        Collections.sort(peaks);
        for(int i=0; i<N; i++)
        {
            boolean works=true;
            for(int j=0; j<finalP.size(); j++)
            {
                if(Math.abs(peaks.get(i).x-finalP.get(j).x)<=Math.abs(peaks.get(i).y-finalP.get(j).y))
                {
                    works=false;
                    break;
                }
            }
            if(works) finalP.add(peaks.get(i));
        }
        out.println(finalP.size());
        out.close();
    }
}
class Peak implements Comparable<Peak>
{
    public int x;
    public int y;
    public Peak(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    public int compareTo(Peak o)
    {
        return o.y-this.y;
    }
}