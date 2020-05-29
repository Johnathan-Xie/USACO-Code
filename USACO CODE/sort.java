import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class sort
{
    
    //Debug static Printer debug;
    static int N;
    static ArrayList<SortVal> vals=new ArrayList<SortVal>();
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("sort.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        //Debug debug=new Printer("countCross.debug");
        //boolean[] contains=new boolean[1000000000];
        N=Integer.parseInt(f.readLine());
        for(int i=0; i<N; i++)
        {
            vals.add(new SortVal(i, Integer.parseInt(f.readLine())));
        }
        /*for(SortVal i:vals)
            System.out.println(i.val+ " "+i.index);*/
        Collections.sort(vals);
        int ans=0;
        /*for(SortVal i:vals)
            System.out.println(i.val+ " "+i.index);*/
        for(int i=0; i<vals.size(); i++)
        {
            if(i<vals.get(i).index)
            {
                ans=Math.max(ans, vals.get(i).index-i);
            }
        }
        out.println(ans+1);
        //Debug debug.close();
        out.close();
    }
}
class SortVal implements Comparable<SortVal>
{
    public int index;
    public int val;
    public SortVal(int index, int val)
    {
        this.index=index;
        this.val=val;
    }
    public int compareTo(SortVal o)
    {
        if(o.val==this.val)
            return this.index-o.index;
        return this.val-o.val;
    }
}