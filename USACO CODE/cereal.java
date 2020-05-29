import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class cereal
{
    //Debugstatic Printer debug;
    static int N;
    static int M;
    static HashSet<Integer> cereals=new HashSet<Integer>();
    static HashSet<Integer> cerealsTemp=new HashSet<Integer>();
    static ArrayList<CerealCow> cows=new ArrayList<CerealCow>();
    static ArrayList<ArrayList<CerealCow>> cowsP=new ArrayList<>();
    //static ArrayList<ArrayList<CerealCow>> cowsS=new ArrayList<>();
    static boolean[] first;
    static boolean[] second;
    static int[] dp;
    public static boolean suc(int id, int look, int index)
    {
        System.out.println(id + " " + look+ " " + index);
        if(!first[id] && !second[id])
        {
            if(cows.get(id).f==look) first[id]=true;
            else second[id]=true;
            return true;
        }
        if(first[id])
        {
            //System.out.println(cowsP.get(look).get(index+1)+ " "+look+ " " +index+1);
            if(index!=cowsP.get(look).size()-1) return suc(cowsP.get(look).get(++index).id, look, index);
            else return false;
        }
        else
        {
            second[id]=false;
            first[id]=true;
            if(cowsP.get(cows.get(id).s).size()==1) return false;
            return suc(cowsP.get(cows.get(id).s).get(1).id, cows.get(id).s, 1);
        }
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader b=new BufferedReader(new FileReader(new File("cereal.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        //Debugdebug=new Printer("cereal.debug");
        StringTokenizer st=new StringTokenizer(b.readLine());
        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        dp=new int[N];
        first=new boolean[N];
        second=new boolean[N];
        for(int i=0; i<N; i++)
        {
            StringTokenizer cowSt=new StringTokenizer(b.readLine());
            int f=Integer.parseInt(cowSt.nextToken());
            int s=Integer.parseInt(cowSt.nextToken());
            if(!cereals.contains(f)) cereals.add(f);
            if(!cereals.contains(s)) cereals.add(s);
            cows.add(new CerealCow(f, s, i));
        }
        HashSet<Integer> cerealsTemp=new HashSet<Integer>(cereals);
        //basic compute for zero case
        int count=0;
        for(int i=0; i<N; i++)
        {
            
            if(cereals.contains(cows.get(i).f))
            {
                cereals.remove(cows.get(i).f);
                count++;
                first[i]=true;
                continue;
            }
            else if(cereals.contains(cows.get(i).s))
            {
                cereals.remove(cows.get(i).s);
                count++;
                second[i]=true;
                continue;
            }
        }
        dp[0]=count;
        for(int i=0; i<1000000; i++)
        {
            cowsP.add(new ArrayList<CerealCow>());
        }
        for(int i=0; i<N; i++)
        {
            cowsP.get(cows.get(i).f).add(cows.get(i));
            cowsP.get(cows.get(i).s).add(cows.get(i));
        }
        for(int i=1; i<N; i++)
        {
            //System.out.println(i);
            CerealCow last=cowsP.get(cows.get(i-1).f).remove(0);
            cowsP.get(last.s).remove(0);
            first[last.id]=false;
            dp[i]=dp[i-1];
            if(cowsP.get(last.f).isEmpty() || !suc(cowsP.get(last.f).get(0).id, last.f, 0)) dp[i]--;
        }
        for(int i=0; i<dp.length; i++)
        {
            out.println(dp[i]);
        }
        out.close();
    }
}
class CerealCow
{
    public int f;
    public int s;
    public int id;
    public CerealCow(int f, int s, int id)
    {
        this.f=f;
        this.s=s;
        this.id=id;
    }
}