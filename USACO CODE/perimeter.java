import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class perimeter
{
    
    static int N;
    static char[][] map;
    static int area;
    static int peri;
    static boolean[][] visited;
    //static boolean[][] periVisited;
    //static Printer debug;
    public static void DFS(int a, int b)
    {
        if(visited[a][b])
            return;
        if(map[a][b]=='.' || map[a][b]=='\u0000')
        {
            peri++;
            return;
        }
        area++;
        visited[a][b]=true;
        DFS(a+1, b);
        DFS(a-1, b);
        DFS(a, b+1);
        DFS(a, b-1);
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("perimeter.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        //debug=new Printer("perimeter.debug");
        N=Integer.parseInt(f.readLine());
        map=new char[N+2][N+2];
        visited=new boolean[N+2][N+2];
        for(int i=0; i<N; i++)
        {
            String temp=f.readLine();
            for(int j=0; j<N; j++)
            {
                map[i+1][j+1]=temp.charAt(j);
            }
        }
        
        //debug.printChar(map);
        //debug.close();
        int maxArea=0;
        int minPeri=0;
        for(int i=1; i<N; i++)
        {
            for(int j=1; j<N; j++)
            {
                if(map[i][j]=='#')
                {
                    //periVisited=new boolean[N+2][N+2];
                    area=0;
                    peri=0;
                    DFS(i, j);
                    if(area>maxArea)
                    {
                        maxArea=area;
                        minPeri=peri;
                    }
                    else if(area==maxArea)
                    {
                        minPeri=Math.min(minPeri, peri);
                    }
                    area=0;
                    peri=0;
                }
            }
        }
        out.println(maxArea+ " " + minPeri);
        
        out.close();
    }
}