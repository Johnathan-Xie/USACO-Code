import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class where
{
    //Debugstatic Printer debug;
    static char[][] map;
    static int[] seen;
    static int[][] comp;
    static int N;
    static ArrayList<WhereRect> pcls=new ArrayList<WhereRect>();
    public static void pcl(WhereRect rect)
    {
        int counter=0;
        for(int i=rect.x1; i<=rect.x2; i++)
        {
            for(int j=rect.y1; j<=rect.y2; j++)
            {
                if(comp[i][j]==0) 
                {
                    seen[map[i][j]-65]++;
                    //DebugSystem.out.println(map[i][j]-65);
                    DFS(i, j, ++counter, map[i][j]-65, rect);
                }
            }
        }
        boolean one=false;
        boolean two=false;
        int count=0;
        for(int i=0; i<26; i++)
        {
            if(seen[i]>0) count++;
            if(seen[i]==1) one=true;
            else if(seen[i]>1) two=true;
        }
        boolean ind=true;
        for(int i=0; i<pcls.size(); i++)
        {
            if(rect.in(pcls.get(i)))
            {
                ind=false;
                break;
            }
        }
        //DebugSystem.out.println(rect.x1 + " "+ rect.y1 + " " + rect.x2 + " " + rect.y2);
        //DebugSystem.out.println(Arrays.toString(seen));
        //DebugSystem.out.println(one + " " + two + " " + count + " " + ind);
        //DebugSystem.out.println();
        if(one && two && count==2 && ind) pcls.add(rect);
    }
    public static void DFS(int a, int b, int id, int type, WhereRect rect)
    {
        if(map[a][b]-65!=type || comp[a][b]==id) return;
        comp[a][b]=id;
        if(a-1>=rect.x1) DFS(a-1, b, id, type, rect);
        if(b-1>=rect.y1) DFS(a, b-1, id, type, rect);
        if(a+1<=rect.x2) DFS(a+1, b, id, type, rect);
        if(b+1<=rect.y2) DFS(a, b+1, id, type, rect);
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("where.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        //Debugdebug=new Printer("where.debug");
        N=Integer.parseInt(f.readLine());
        map=new char[N][N];
        for(int i=0; i<N; i++)
        {
            String temp=f.readLine();
            for(int j=0; j<N; j++)
            {
                map[i][j]=temp.charAt(j);
            }
        }
        for(int x1=0; x1<N; x1++)
        {
            for(int y1=0; y1<N; y1++)
            {
                for(int x2=N-1; x2>=x1; x2--)
                {
                    for(int y2=N-1; y2>=y1; y2--)
                    {
                        seen=new int[26];
                        comp=new int[N][N];
                        pcl(new WhereRect(x1, y1, x2, y2));
                    }
                }
            }
        }
        out.println(pcls.size());
        out.close();
    }
}
class WhereRect
{
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public WhereRect(int x1, int y1, int x2, int y2)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    public boolean in(WhereRect o)
    {
        return (this.x1>=o.x1 && this.y1>=o.y1 && this.x2<=o.x2 && this.y2<=o.y2);
    }
}