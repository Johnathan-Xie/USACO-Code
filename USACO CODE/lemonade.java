import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class lemonade
{
    
    //Debug static Printer debug;
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
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("lemonade.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        //Debug debug=new Printer("countCross.debug");
        int N=Integer.parseInt(f.readLine());
        ArrayList<Integer> w=strToIntArrList(N, f.readLine());
        Collections.sort(w);
        Collections.reverse(w);
        for(Integer i:w)
            System.out.print(i+ " ");
        System.out.println();
        int counter=0;
        int i=0;
        while(!w.isEmpty())
        {
            if(w.get(w.size()-1)<i)
            {
                w.remove(w.size()-1);
                counter++;
            }
            else
            {
                w.remove(0);
                i++;
            }
            
        }
        //int[] w=new int[N];
        /*
        for(int i=0; i<N; i++)
        {
            w[N-i-1]=temp[i];
        }*/
        
        
        out.println(N-counter);
        //Debug debug.close();
        out.close();
    }
}
