/*ID: johnath8
 LANG: JAVA
 TASK: camelot
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class camelot
{
    private static int[] dx={1, 1, -1, -1, 2, 2, -2, -2};
    private static int[] dy={2, -2, 2, -2, 1, -1, 1, -1};
    
    private static int[][][][] steps;
    static Printer print;
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("camelot.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
        ArrayList<Position> knights=new ArrayList<Position>();
        String[] str=f.readLine().split("\\s");
        int R=Integer.parseInt(str[0]);
        int C=Integer.parseInt(str[1]);
        System.out.println(R + " " + C);
        steps=new int[R][C][R][C];
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                for(int k=0; k<R; k++)
                {
                    //System.out.println(i + " " + j + " " + k);
                    Arrays.fill(steps[i][j][k], -1);
                }
            }
        }
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                move2Dest(R, C, new Position(i, j));
            }
        }
        //move2Dest(R, C, new Position(0,0));
        System.out.println("reached");
        str=f.readLine().split("\\s");
        Position king=new Position(str[0].charAt(0)-'A', Integer.parseInt(str[1])-1);
        while(f.ready())
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            while(st.hasMoreTokens())
            {
                knights.add(new Position(st.nextToken().charAt(0)-'A', Integer.parseInt(st.nextToken())-1));
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                ans=Math.min(ans, minSteps(R, C, new Position(i, j), king, knights));
            }
        }
        out.println(ans);
    }
    public static void move2Dest(int R, int C, Position dest)
    {
        Queue<Position> queue=new LinkedList<Position>();
        queue.add(dest);
        steps[dest.x][dest.y][dest.x][dest.y]=0;
        //System.out.println(dest.x + " " + dest.y);
        //int counter=0;
        while(!queue.isEmpty())
        {
            Position curr=queue.poll();
            int currX=curr.x;
            int currY=curr.y;
            //counter++;
            for(int i=0; i<dx.length; i++)
            {
                int toX=curr.x+dx[i];
                int toY=curr.y+dy[i];
                if(toX>=0 && toY>=0 && toX<R && toY<C)
                {
                    if(steps[dest.x][dest.x][toX][toY]==-1 ||
                steps[dest.x][dest.y][toX][toY]>steps[dest.x][dest.y][currX][currY]+1)
                    {
                        
                        steps[dest.x][dest.y][toX][toY]=steps[dest.x][dest.y][currX][currY]+1;
                        steps[toX][toY][dest.x][dest.y]=steps[dest.x][dest.y][currX][currY]+1;
                        queue.add(new Position(toX, toY));
                    }
                }
            }
        }
    }
    public static int minSteps(int R, int C, Position dest, Position king, ArrayList<Position> knights)
    {
        int moves=0;
        for(Position knight : knights)
        {
            if(steps[knight.x][knight.y][dest.x][dest.y]==-1) return Integer.MAX_VALUE;
            moves+=steps[knight.x][knight.y][dest.x][dest.y];
        }
        int temp=Math.max(Math.abs(king.x-dest.x), Math.abs(king.y-dest.y));
        
        for(int i=Math.max(0, king.x-2); i<Math.min(R, king.x+3); i++)
        {
            for(int j=Math.max(0, king.y-2); j<Math.min(C, king.y+3); j++)
            {
                for(Position knight : knights)
                {
                    if(steps[knight.x][knight.y][i][j]!=-1 && steps[i][j][dest.x][dest.y]!=-1)
                    {
                        temp=Math.min(temp, steps[knight.x][knight.y][i][j]+steps[i][j][dest.x][dest.y]
                                          -steps[knight.x][knight.y][dest.x][dest.y]+Math.max(Math.abs(king.x-dest.x), Math.abs(king.y-dest.y)));
                    }
                        
                }
                
            }
        }
        return temp+moves;
    }
}
class Position
{
    public int x;
    public int y;
    public Position(int a, int b)
    {
        this.x=a;
        this.y=b;
    }
    public String toString()
    {
        return String.format("(%d, %d)", x, y);
    }
}
