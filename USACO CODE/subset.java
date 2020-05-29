/*ID: johnath8
 LANG: JAVA
 TASK: subset
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class subset
{
    
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        int n=Integer.parseInt(f.readLine());
        int total=n*(n+1)/2;
        if(total%2==1)
        {
            out.println(0);
            out.close();
            
            System.exit(0);
        }
        int target=(int)(total/2);
        long[][] numOfWays=new long[40][400];
        
        for(int i=0; i<n; i++)
            numOfWays[i][0]=1;
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=target; j++)
            {
                numOfWays[i][j]+=numOfWays[i-1][j];
                if(i<=j)
                    numOfWays[i][j]+=numOfWays[i-1][j-i];
            }
            System.out.println(Arrays.toString(numOfWays[i]));
        }
        
        System.out.println("hit");
        out.println((long)(numOfWays[n][target]/2));
        out.close();
                    
    }
}
