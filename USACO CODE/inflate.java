/*ID: johnath8
 LANG: JAVA
 TASK: inflate
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class inflate
{
    
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        int t=Integer.parseInt(st.nextToken());
        int ty=Integer.parseInt(st.nextToken());
        int[] times=new int[ty];
        int[] vals=new int[ty];
        for(int i=0; i<ty; i++)
        {
            StringTokenizer temp=new StringTokenizer(f.readLine());
            vals[i]=Integer.parseInt(temp.nextToken());
            times[i]=Integer.parseInt(temp.nextToken());
        }
        int[] score=new int[t+1];
        for(int i=0; i<ty; i++)
        {
            for(int j=times[i]; j<t+1; j++)
            {
                score[j]=Math.max(score[j], score[j-times[i]]+vals[i]);
            }
        }
        //System.out.println(Arrays.toString(score));
        out.println(score[t]);
        out.close();
        //knapsack
    }
}
