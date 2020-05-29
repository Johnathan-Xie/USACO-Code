/*ID: johnath8
 LANG: JAVA
 TASK: agrinet
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class agrinet
{
    static int[][] adj;
    static boolean[] visited;
    static int[] dToFarm;
    
    public static int connect()
    {
        int total=0;
        visited[0]=true;
        for(int i=0; i<dToFarm.length; i++)
        {
            dToFarm[i]=Integer.MAX_VALUE;
        }
        for(int i=0; i<visited.length-1; i++) //farms done so far
        {
            
            for(int j=0; j<dToFarm.length; j++)//reducing distance to farm j
            {
                if(visited[j])
                    continue;
                for(int k=0; k<adj[0].length; k++) //viewing all distances to j
                {
                    if(visited[k] && k!=j)
                        dToFarm[j]=Math.min(dToFarm[j], adj[j][k]);
                }
            }
            System.out.println(Arrays.toString(dToFarm));
            int minIndex=0;
            for(int a=0; a<dToFarm.length; a++)
            {
                if(dToFarm[a]<dToFarm[minIndex] && !visited[a])
                    minIndex=a;
            }
            visited[minIndex]=true;
           
            total+=dToFarm[minIndex];
        }
        return total;
    }
    
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("agrinet.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
        int n=f.nextInt();
        agrinet temp=new agrinet();
        
        //Prints printer=new Prints();
        
        adj=new int[n][n];
        visited=new boolean[n];
        dToFarm=new int[n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                adj[i][j]=f.nextInt();
            }
        }
        int result=temp.connect();
        out.println(result);
        out.close();
        
    }
}
