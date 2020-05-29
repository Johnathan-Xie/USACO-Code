 
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class helpcross
{
    static int C;
    static int N;
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("helpcross.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        C=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        ArrayList<Integer> c=new ArrayList<Integer>();
        ArrayList<HelpCrossCow> cows=new ArrayList<>();
        for(int i=0; i<C; i++)
        {
            c.add(Integer.parseInt(f.readLine()));
        }
        for(int i=0; i<N; i++)
        {
            StringTokenizer cowSt=new StringTokenizer(f.readLine());
            cows.add(new HelpCrossCow(Integer.parseInt(cowSt.nextToken()), Integer.parseInt(cowSt.nextToken())));
        }
        Collections.sort(cows);
        Collections.sort(c);
        //for(HelpCrossCow i:cows) System.out.println(i.start + " " + i.end);
        //for(Integer i:c) System.out.println(i);
        int ans=0;
        while(c.size()>0)
        {
            int curr=c.remove(0);
            for(int i=0; i<cows.size(); i++)
            {
                if(curr>=cows.get(i).start && curr<=cows.get(i).end)
                {
                    cows.remove(i);
                    ans++;
                    break;
                }
            }
        }
        out.println(ans);
        out.close();
    }
}
class HelpCrossCow implements Comparable<HelpCrossCow>
{
    int start;
    int end;
    public HelpCrossCow(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
    public int compareTo(HelpCrossCow o)
    {
        if(this.end-o.end==0)
            return this.start-o.start;
        return this.end-o.end;
    }
}
