/*ID: johnath8
 LANG: JAVA
 TASK: castle
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class castle
{
    //m is x size
    //n is y size
    static int[][] grid;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[][] id;
    public static void print2DArray(int[][] in)
    {
        for(int i=0; i<in.length; i++)
        {
            System.out.print("\n");
            for(int j=0; j<in[0].length; j++)
            {
                System.out.print(in[i][j]+" ");
            }
        }
            
    }
    public static boolean readRoom(int in, String dir)
    {
        if(dir=="W")
        {
            if(in%2==1)
                return true;
            else
                return false;
        }
        if(dir=="N")
        {
            if(in%4>=2)
                return true;
            else
                return false;
        }
        if(dir=="E")
        {
            if(in%8>=4)
                return true;
            else
                return false;
        }
        if(dir=="S")
        {
            if(in>=8)
                return true;
            else
                return false;
        }
        return false;
    }
    public static void roomSize(int i, int j, ArrayList<Integer> count, int identity)
    {
        
        if(i<0 || j<0 || i>n-1|| j>m-1 || visited[i][j]==true)
            return;
        id[i][j]=identity;
        visited[i][j]=true;
        count.add(1);
        /*System.out.println(i + " " + j + " " +grid[i][j]);
        System.out.println("W"+readRoom(grid[i][j], "W"));
        System.out.println("N"+readRoom(grid[i][j], "N"));
        System.out.println("E"+readRoom(grid[i][j], "E"));
        System.out.println("S"+readRoom(grid[i][j], "S"));*/
        if(!readRoom(grid[i][j], "W"))
            roomSize(i, j-1, count, identity);
        if(!readRoom(grid[i][j], "N"))
            roomSize(i-1, j, count, identity);
        if(!readRoom(grid[i][j], "E"))
            roomSize(i, j+1, count, identity);
        if(!readRoom(grid[i][j], "S"))
            roomSize(i+1, j, count, identity);
        
    }
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        m=f.nextInt();
        n=f.nextInt();
        grid=new int[n][m];
        visited=new boolean[n][m];
        id=new int[n][m];
        int[] roomSizes=new int[n*m];
        ArrayList<Integer> count=new ArrayList<Integer>();
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                grid[i][j]=f.nextInt();
            }
        }
        
        //System.out.println(grid[0][1]);
        int counter=0;
        int max=0;
        int cnt=0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(!visited[i][j])
                {
                    //System.out.println(i+" "+j);
                    roomSize(i, j, count, cnt);
                    max=Math.max(count.size(), max);
                    roomSizes[cnt]=count.size();
                    counter++;
                    cnt++;
                    count.clear();
                }
            }
        }
        
        out.println(counter);
        out.println(max);
        
        int max2=0;
        int index1=0;
        int index2=0;
        String direction="N";
        
        for(int i=0; i<m; i++)
        {
            for(int j=n-1; j>=0; j--)
            {
                //System.out.println(j +" "+ i);
                if(readRoom(grid[j][i], "N") && j-1>=0)
                {
                    if(max2<roomSizes[id[j][i]]+roomSizes[id[j-1][i]] && id[j][i]!=id[j-1][i])
                    {
                        max2=roomSizes[id[j][i]]+roomSizes[id[j-1][i]];
                        index1=i+1;
                        index2=j+1;
                        direction="N";
                    }
                    
                }
                count.clear();
                if(readRoom(grid[j][i], "E") && i+1<m)
                {
                    if(max2<roomSizes[id[j][i]]+roomSizes[id[j][i+1]] && id[j][i]!=id[j][i+1])
                    {
                        max2=roomSizes[id[j][i]]+roomSizes[id[j][i+1]];
                        index1=i+1;
                        index2=j+1;
                        direction="E";
                    }
                }
                
            }
        }
        out.println(max2);
        out.println(index2+" "+index1+" "+direction);
        out.close();
        System.exit(0);
    }
}
