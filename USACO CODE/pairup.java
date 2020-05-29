import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class pairup
{
    //Debugstatic Printer debug;
    static int N;
    static ArrayList<PairupCow> cows=new ArrayList<PairupCow>();
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("pairup.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        //Debugdebug=new Printer("where.debug");
        N=Integer.parseInt(f.readLine());
        
        for(int i=0; i<N; i++) 
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            cows.add(new PairupCow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(cows);
        int ans=0;
        while(cows.size()>0)
        {
            ans=Math.max(ans, cows.get(0).output+cows.get(cows.size()-1).output);
            if(cows.get(0).num>cows.get(cows.size()-1).num)
            {
                cows.get(0).num-=cows.get(cows.size()-1).num;
                cows.remove(cows.size()-1);
            }
            else if(cows.get(cows.size()-1).num>cows.get(0).num)
            {
                cows.get(cows.size()-1).num-=cows.get(0).num;
                cows.remove(0);
            }
            else
            {
                cows.remove(cows.size()-1);
                if(cows.size()>0)
                cows.remove(0);
            }
        }
        out.println(ans);
        out.close();
    }
}
class PairupCow implements Comparable<PairupCow>
{
    public int num;
    public int output;
    public PairupCow(int num, int output)
    {
        this.num=num;
        this.output=output;
        
    }
    public int compareTo(PairupCow o)
    {
        return this.output-o.output;
    }
}