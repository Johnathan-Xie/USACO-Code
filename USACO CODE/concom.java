/*ID: johnath8
 LANG: JAVA
 TASK: concom
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class concom
{
    
    public static void print2DArray(long[][] in) throws IOException
    {
        
        for(int i=0; i<in[0].length; i++)
        {
            for(int j=0; j<in.length; j++)
            {
                System.out.print(in[i][j]+" ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("concom.in"));
        PrintWriter out = new PrintWriter(new File("concom.out"));
        long[][] vals=new long[101][101];
        boolean[][] visited=new boolean[101][101];
        int n=f.nextInt();
        for(int i=0; i<n; i++)
        {
            int a=f.nextInt();
            int b=f.nextInt();
            vals[a][b]=f.nextInt();
        }
        
        boolean cont=true;
        while(cont)
        {
            cont=false;
            for(int i=0; i<vals.length; i++)
            {
                for(int j=0; j<vals[0].length; j++)
                {
                    if(vals[i][j]>=50 && !visited[i][j] && i!=j)
                    {
                        cont=true;
                        visited[i][j]=true;
                        for(int k=0; k<vals[0].length; k++)
                        {
                            if(i!=k && j!=k)
                                vals[i][k]+=vals[j][k];
                        }
                    }
                }
            }
        }
        print2DArray(vals);
        for(int i=0; i<vals.length; i++)
        {
            for(int j=0; j<vals[0].length; j++)
            {
                if(Math.abs(vals[i][j])>=50 && i!=j)
                {
                    out.println(i+" "+j);
                }
            }
        }
        
        out.close();
        //System.exit(0);
    }
}
