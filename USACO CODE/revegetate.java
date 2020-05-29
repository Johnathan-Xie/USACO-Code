import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class revegetate
{
    
    //Debug static Printer debug;
    static ArrayList<ArrayList<RevegCow>> p=new ArrayList<>();
    static int[] comp;
    static int[] pVals;
    static int N;
    static int M;
    static boolean impossible=false;
    public static boolean convert(char in)
    {
        switch(in)
        {
            case 'D':
                return false;
            case 'S':
                return true;
        }
        return true;
    }
    
    public static void dfs(int at, int id)
    {
        
        if(comp[at]==id) return;
        comp[at]=id;
        for(int i=0; i<p.get(at).size(); i++)
        {
            RevegCow temp=p.get(at).get(i);
            if(temp.same)
            {
                if(pVals[temp.other]!=pVals[at] && pVals[temp.other]!=0)
                {
                    impossible=true;
                    break;
                }
                else pVals[temp.other]=pVals[at];
            }
            else
            {
                if(pVals[temp.other]==pVals[at] && pVals[temp.other]!=0)
                {
                    impossible=true;
                    break;
                }
                else pVals[temp.other]=pVals[at]%2+1;
            }
            dfs(temp.other, id);
        }
        return;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("revegetate.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken());
        comp=new int[N];
        pVals=new int[N];
        for(int i=0; i<N; i++) p.add(new ArrayList<RevegCow>());
        for(int i=0; i<M; i++)
        {
            StringTokenizer cowSt=new StringTokenizer(f.readLine());
            boolean same=convert(cowSt.nextToken().charAt(0));
            int fav1=Integer.parseInt(cowSt.nextToken())-1;
            int fav2=Integer.parseInt(cowSt.nextToken())-1;
            p.get(fav1).add(new RevegCow(same, fav2));
            p.get(fav2).add(new RevegCow(same, fav1));
        }
        Arrays.fill(comp, -1);
        int counter=0;
        for(int i=0; i<N; i++)
        {
            if(comp[i]<0)
            {
                pVals[i]=1;
                dfs(i, counter++);
                if(impossible)
                {
                    System.out.println("hit");
                    out.println(0);
                    out.close();
                    System.exit(0);
                }
            }
        }
        out.print(1);
        for(int i=0; i<counter; i++) out.print(0);
        out.println();
        out.close();
    }
}
class RevegCow
{
    public boolean same;
    public int other;
    public RevegCow(boolean same, int other)
    {
        this.same=same;
        this.other=other;
    }
}