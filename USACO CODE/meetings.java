/*ID: johnath8
 LANG: JAVA
 TASK: meetings
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class meetings
{
    static ArrayList<Cow> cows;
    static ArrayList<Integer> barn0=new ArrayList<Integer>();
    static ArrayList<Integer> barnL=new ArrayList<Integer>();
    static int totalW=0;
    public static boolean valid(int time)
    {
        int weight=0;
 
        for(int i=0; i<barn0.size(); i++)
        {
            if(barn0.get(i)<=time)
            {
                weight+=cows.get(i).w;
            }
            else
                break;
        }
        for(int i=0; i<barnL.size(); i++)
        {
            if(barnL.get(i)<=time)
            {
                weight+=cows.get(cows.size()-i-1).w;
            }
            else
                break;
        }
        return weight>=((totalW+1)/2);
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("meetings.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        cows=new ArrayList<Cow>();
        for(int i=0; i<N; i++)
        {
            StringTokenizer cowSt=new StringTokenizer(f.readLine());
            int weight=Integer.parseInt(cowSt.nextToken());
            cows.add(new Cow(weight, Integer.parseInt(cowSt.nextToken()), Integer.parseInt(cowSt.nextToken())));
            totalW+=weight;
        }
        Collections.sort(cows);
        
        for(Cow i:cows)
        {
            if(i.d==1)
                barnL.add(L-i.x);
            else
                barn0.add(i.x);
        }
        Collections.reverse(barnL);
        
        int lhs=0;
        int rhs=Math.max(barn0.get(barn0.size()-1), barnL.get(barnL.size()-1));
        while(rhs-lhs>1)
        {
            int mid=(lhs+rhs)/2;
            if(valid(mid))
                rhs=mid;
            else
                lhs=mid;
        }
        int finalTime=0;
        if(valid(lhs))
            finalTime=lhs;
        else
            finalTime=rhs;
        //System.out.println(lhs);
        
        int ans=0;
        ArrayList<Integer> movRight=new ArrayList<Integer>();
        for(int i=0; i<cows.size(); i++)
        {
            if(cows.get(i).d==1) movRight.add(cows.get(i).x);
            else
            {
                for(int j=0; j<movRight.size(); j++)
                {
                    if(movRight.get(j)+2*finalTime>=cows.get(i).x)
                        ans++;
                }
            }
            
        }
        out.println(ans);
        out.close();
    }
}
class Cow implements Comparable<Cow>
{
    int w;
    int x;
    int d;
    public Cow(int w, int x, int d)
    {
        this.w=w;
        this.x=x;
        this.d=d;
    }
    public int compareTo(Cow o)
    {
        return this.x-o.x;
    }
}
