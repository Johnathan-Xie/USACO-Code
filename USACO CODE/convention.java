/*ID: johnath8
 LANG: JAVA
 TASK: convention
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class convention
{
    static int M;
    static int N;
    static int C;
    static int[] times;
    public static int[] strToIntArr(String in, int numOfTokens)
    {
        int prev=0;
        int[] comp=new int[numOfTokens];
        int val;
        for(int i=0; i<numOfTokens; i++)
        {
            val=in.indexOf(" ", prev);
            if(val<0)
                val=in.length();
            //System.out.println(prev + " " + val);
            comp[i]=Integer.parseInt(in.substring(prev, val));
            prev=val+1;
        }
        return comp;
    }
    public static boolean works(int low)
    {
        //System.out.println();
        //System.out.println(low);
        int startIndex=0;
        int startTime=times[0];
        int buses=1;
        for(int i=0; i<N; i++)
        {
            
            if(times[i]-startTime>low || i+1-startIndex>C)
            {
                buses++;
                startIndex=i;
                startTime=times[i];
            }
            
            
        }
        return buses<=M;
    }
    public static int binarySearchLow(int lowBound, int highBound)
    {
        int lhs=lowBound;
        int rhs=highBound;
        while(rhs-lhs>1)
        {
            int mid=(lhs+rhs)/2;
            if(works(mid)) rhs=mid;
            else lhs=mid;
        }
        return rhs;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("convention.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken());
        times=strToIntArr(f.readLine(), N);
        Arrays.sort(times);
        int lhs=0;
        int rhs=times[times.length-1];
        out.println(binarySearchLow(lhs, rhs));
        out.close();
        
        //System.out.println(Arrays.toString(times));
    }
}
