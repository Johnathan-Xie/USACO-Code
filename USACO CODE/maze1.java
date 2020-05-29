/*ID: johnath8
 LANG: JAVA
 TASK: maze1
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class maze1
{
    static char[][] maze;
    static int[][] vals;
    static boolean[][] visited;
    static boolean[][] done;
    
    
    public static void fillVals(int down, int right)
    {
        visited[down][right]=true;
        
        /*int down1=down*2+1;
         int right1=right*2+1;
         boolean downb=false;
         boolean upb=false;
         boolean rightb=false;
         boolean leftb=false;
         for(int i=0; i<vals.length; i++)
         {
         for(int j=0; j<vals[0].length; j++)
         {
         System.out.print(vals[i][j]+ " ");
         }
         System.out.print("\n");
         }
         System.out.print("\n");
         visited[down][right]=true;
         if(maze[down1+1][right1]==' ' && down<vals.length-1 && !visited[down+1][right])
         {
         
         vals[down+1][right]=Math.min(vals[down][right]+1, vals[down+1][right]);
         if(Math.min(vals[down][right]+1, vals[down+1][right])<=round.size()+2)
         downb=true;
         else
         fillVals(down+1, right);
         }
         
         if(maze[down1-1][right1]==' ' && down>0 && !visited[down-1][right])
         {
         
         vals[down-1][right]=Math.min(vals[down][right]+1, vals[down-1][right]);
         if(Math.min(vals[down][right]+1, vals[down-1][right])<=round.size()+2)
         upb=true;
         else
         fillVals(down-1, right);
         }
         if(maze[down1][right1+1]==' ' && right<vals[0].length-1 && !visited[down][right+1])
         {
         
         vals[down][right+1]=Math.min(vals[down][right]+1, vals[down][right+1]);
         if(Math.min(vals[down][right]+1, vals[down][right+1])<=round.size()+2)
         leftb=true;
         else
         fillVals(down, right+1);
         }
         if(maze[down1][right1-1]==' ' && right>0 && !visited[down][right-1])
         {
         
         vals[down][right-1]=Math.min(vals[down][right]+1, vals[down][right-1]);
         if(Math.min(vals[down][right]+1, vals[down][right-1])<=round.size()+2)
         rightb=true;
         else
         fillVals(down, right-1);
         }
         if(downb && Math.min(vals[down][right]+1, vals[down+1][right])<=round.size()+2)
         fillVals(down, right-1);
         if(upb && Math.min(vals[down][right]+1, vals[down-1][right])<=round.size()+2)
         fillVals(down, right-1);
         if(leftb && Math.min(vals[down][right]+1, vals[down][right-1])<=round.size()+2)
         fillVals(down, right-1);
         if(rightb && Math.min(vals[down][right]+1, vals[down][right+1])<=round.size()+2)
         fillVals(down, right+1);
         round.add(1);*/
        for(int i=0; i<vals.length*vals[0].length; i++)
        {
            /*for(int a=0; a<vals.length; a++)
            {
                for(int b=0; b<vals[0].length; b++)
                {
                    System.out.print(vals[a][b]+ " ");
                }
                System.out.print("\n");
            }
            for(int a=0; a<visited.length; a++)
            {
                for(int b=0; b<visited[0].length; b++)
                {
                    System.out.print(visited[a][b]+ " ");
                }
                System.out.print("\n");
            }*/
            System.out.print("\n");
            for(int j=0; j<vals.length; j++)
            {
                for(int k=0; k<vals[0].length; k++)
                {
                    if(visited[j][k] && !done[j][k] && vals[j][k]<=i+1)
                    {
                        if(j<vals.length-1 && !visited[j+1][k] && maze[j*2+2][k*2+1]==' ')
                        {
                            vals[j+1][k]=Math.min(vals[j+1][k], vals[j][k]+1);
                            visited[j+1][k]=true;
                        }
                        if(j>0 && !visited[j-1][k]  && maze[j*2][k*2+1]==' ')
                        {
                            vals[j-1][k]=Math.min(vals[j-1][k], vals[j][k]+1);
                            visited[j-1][k]=true;
                        }
                        if(k<vals[0].length-1 && !visited[j][k+1] && maze[j*2+1][k*2+2]==' ')
                        {
                            vals[j][k+1]=Math.min(vals[j][k+1], vals[j][k]+1);
                            visited[j][k+1]=true;
                        }
                        if(k>0 && !visited[j][k-1] && maze[j*2+1][k*2]==' ')
                        {
                            vals[j][k-1]=Math.min(vals[j][k-1], vals[j][k]+1);
                            visited[j][k-1]=true;
                        }
                        done[j][k]=true;
                    }
                }
            } 
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
        PrintWriter out = new PrintWriter(new File("maze1.out"));
        StringTokenizer st=new StringTokenizer(f.readLine());
        int w=Integer.parseInt(st.nextToken());
        int h=Integer.parseInt(st.nextToken());
        maze=new char[2*h+1][2*w+1];
        vals=new int[h][w];
        visited=new boolean[h][w];
        done=new boolean[h][w];
        for(int i=0; i<2*h+1; i++)
        {
            String s=f.readLine();
            for(int j=0; j<2*w+1; j++)
            {
                maze[i][j]=s.charAt(j);
            }
        }
        for(int i=0; i<vals.length; i++)
        {
            for(int j=0; j<vals[0].length; j++)
            {
                vals[i][j]=Integer.MAX_VALUE;
            }
        }
        
        boolean exit1Found=false;
        for(int i=1; i<2*h+1; i+=2)
        {
            if(maze[i][0]==' ')
            {
                exit1Found=true;
                vals[(int)((i-1)/2)][0]=1;
                if(exit1Found)
                {
                    visited=new boolean[h][w];
                    done=new boolean[h][w];
                }
                fillVals((int)((i-1)/2), 0);
                
            }
            if(maze[i][2*w]==' ')
            {
                exit1Found=true;
                vals[(int)((i-1)/2)][w-1]=1;
                if(exit1Found)
                {
                    visited=new boolean[h][w];
                    done=new boolean[h][w];
                }
                fillVals((int)((i-1)/2), w-1);
                
            }
        }
        for(int i=1; i<2*w+1; i+=2)
        {
            if(maze[0][i]==' ')
            {
                exit1Found=true;
                vals[0][(int)((i-1)/2)]=1;
                if(exit1Found)
                {
                    visited=new boolean[h][w];
                    done=new boolean[h][w];
                }
                fillVals(0,(int)((i-1)/2));
                
            }
            if(maze[2*h][i]==' ')
            {
                exit1Found=true;
                vals[h-1][(int)((i-1)/2)]=1;
                if(exit1Found)
                {
                    visited=new boolean[h][w];
                    done=new boolean[h][w];
                }
                fillVals(h-1,(int)((i-1)/2));
                
            }
        }
        int ans=0;
        for(int i=0; i<vals.length; i++)
        {
            for(int j=0; j<vals[0].length; j++)
            {
                ans=Math.max(ans,vals[i][j]);
            }
        }
        for(int i=0; i<vals.length; i++)
        {
            for(int j=0; j<vals[0].length; j++)
            {
                System.out.print(vals[i][j]+ " ");
            }
            System.out.print("\n");
        }
        out.println(ans);
        out.close();
        //System.exit(0);
    }
}
