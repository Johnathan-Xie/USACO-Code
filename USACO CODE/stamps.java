/*ID: johnath8
 LANG: JAVA
 TASK: stamps
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class stamps
{
    static int[] dp;
    static ArrayList<Integer> stamps=new ArrayList<Integer>();
    static boolean[] skip;
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("stamps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
        int k=f.nextInt(); /*num of stamps used*/int n=f.nextInt();/*num of possible stamps*/
        int currMaxValue=0;
        
        for(int i=0; i<n; i++)
        {
            stamps.add(f.nextInt());
        }
        Collections.sort(stamps);
        //System.out.println(stamps);
        dp=new int[k*stamps.get(stamps.size()-1)+1];
        skip=new boolean[dp.length];
        for(int i=0; i<n; i++)
        {
            dp[stamps.get(i)]=1;
        }
        for(int i=0; i<dp.length; i++)
        {
            if(dp[i]==0)
                dp[i]=Integer.MAX_VALUE;
        }
        
        currMaxValue=stamps.get(stamps.size()-1);
        boolean loop=true;
        while(loop)
        {
            
            loop=false;
            for(int i=0; i<=currMaxValue; i++)
            {
                
                if(!skip[i] && dp[i]<k)
                {
                    skip[i]=true;
                    loop=true;
                    for(int j=0; j<stamps.size(); j++)
                    {
                        dp[i+stamps.get(j)]=Math.min(dp[i+stamps.get(j)], dp[i]+1);
                        currMaxValue=Math.max(i+stamps.get(j), currMaxValue);
                    }
                }
            }
            
        }
        
        int counter;
        for(counter=1; counter<dp.length; counter++)
        {
            if(dp[counter]>k)
                break;
        }
        out.println(counter-1);
        out.close();
    }
}
