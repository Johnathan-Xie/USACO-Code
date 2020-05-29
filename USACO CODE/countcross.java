import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class countcross
{
    static int N;
    static int K;
    static int R;
    static boolean[][][][] roads;
    static int[][] distant;
    //Debug static Printer debug;
    public static void floodFill(int r, int c, int id)
    {
        distant[r][c]=id;
        
        if(r+1<=N-1 && distant[r+1][c]!=id && !roads[r][c][r+1][c]) floodFill(r+1, c, id);
        if(c+1<=N-1 && distant[r][c+1]!=id && !roads[r][c][r][c+1]) floodFill(r, c+1, id);
        if(r-1>=0 && distant[r-1][c]!=id && !roads[r][c][r-1][c]) floodFill(r-1, c, id);
        if(c-1>=0 && distant[r][c-1]!=id && !roads[r][c][r][c-1]) floodFill(r, c-1, id);
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("countcross.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        //Debug debug=new Printer("countCross.debug");
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        roads=new boolean[N][N][N][N];
        distant=new int[N][N];
        for(int i=0; i<N; i++)
        {
            Arrays.fill(distant[i], -1);
        }
        for(int i=0; i<R; i++)
        {
            StringTokenizer roadSt=new StringTokenizer(f.readLine());
            int x1=Integer.parseInt(roadSt.nextToken())-1;
            int y1=Integer.parseInt(roadSt.nextToken())-1;
            int x2=Integer.parseInt(roadSt.nextToken())-1;
            int y2=Integer.parseInt(roadSt.nextToken())-1;
            roads[x1][y1][x2][y2]=true;
            roads[x2][y2][x1][y1]=true;
        }
        
        int counter=0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                
                if(distant[i][j]<0)
                {
                    floodFill(i, j, counter++);
                    
                }
            }
        }
        
        int ans=0;
        ArrayList<CountCrossCow> cows=new ArrayList<CountCrossCow>();
        for(int i=0; i<K; i++)
        {
            StringTokenizer cowSt=new StringTokenizer(f.readLine());
            cows.add(new CountCrossCow(Integer.parseInt(cowSt.nextToken())-1, Integer.parseInt(cowSt.nextToken())-1));
            for(int j=cows.size()-2; j>=0; j--)
            {
                if(distant[cows.get(j).row][cows.get(j).column]!=distant[cows.get(cows.size()-1).row][cows.get(cows.size()-1).column])
                    ans++;
            }
        }
        out.println(ans);
        //Debug debug.close();
        out.close();
    }
}
class CountCrossCow
{
    public int row;
    public int column;
    public CountCrossCow(int row, int column)
    {
        this.row=row;
        this.column=column;
    }
}