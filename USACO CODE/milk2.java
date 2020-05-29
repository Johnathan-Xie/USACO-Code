/*ID: johnath8
 LANG: JAVA
 TASK: milk2
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class milk2
{
    
    public static void setEqualTo(int[] a, int [] b)
    {
        for(int i=0; i<a.length; i++)
        {
            b[i]=a[i];
        }
    }
    public static void sort(int[] startTimes, int[] endTimes)
    {
        int[]startTimes2=new int[startTimes.length];
        int[]endTimes2=new int[endTimes.length];
        int[] index=new int[startTimes.length];
        
        int counter=0;
        for(int i=0; i<startTimes.length; i++)
        {
            for(int j=0; j<startTimes.length; j++)
            {
                if(startTimes[i]>startTimes[j])
                {
                    index[i]++;
                }
            }
        }
        for(int i=0; i<index.length; i++)
        {
            int counter3=0;
            for(int j=i+1; j<index.length; j++)
            {
                if(index[i]==index[j])
                {
                    counter3++;
                    index[j]+=counter3;
                }
            }
        }
        for(int i=0; i<startTimes.length; i++)
        {
            
            startTimes2[index[i]]=startTimes[i];
            endTimes2[index[i]]=endTimes[i];
        }
        
        setEqualTo(startTimes2, startTimes);
        setEqualTo(endTimes2, endTimes);
    }
    public static void clump(int[] startTimes, int[] endTimes)
    {
        for(int i=0; i<startTimes.length; i++)
        {
            
            for(int j=i+1; j<startTimes.length; j++)
            {
                
                if(endTimes[i]>=startTimes[j])
                {
                    if(endTimes[i]<=endTimes[j])
                    {
                        endTimes[i]=endTimes[j];
                    }
                    if(startTimes[j]<=startTimes[i])
                    {
                        startTimes[i]=startTimes[j];
                    }
                    startTimes[j]=0;
                    endTimes[j]=0;
                    
                }
                
            }
        }
    }
    public static void main (String [] args) throws IOException
    {
        
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int numberOfFarmers=Integer.parseInt(f.readLine());
        
        int[] startTimes=new int [numberOfFarmers];
        int[] endTimes=new int[numberOfFarmers];
        
       
        
        for(int i=0; i<numberOfFarmers; i++)
        {
            StringTokenizer st= new StringTokenizer(f.readLine());
            startTimes[i]=Integer.parseInt(st.nextToken());
            endTimes[i]=Integer.parseInt(st.nextToken());
        }
        
        sort(startTimes, endTimes);
        System.out.println(Arrays.toString(startTimes));
        System.out.println(" ");
        System.out.println(Arrays.toString(endTimes));
        System.out.println(" ");
        clump(startTimes, endTimes);
        
        int counter=0;
        
        for(int i=0; i<startTimes.length; i++)
        {
            if(startTimes[i]!=0)
            {
                counter++;
            }
        }
        if(counter==0)
            counter++;
        System.out.println(counter);
        int[] startTimes2=new int [counter];
        int[] endTimes2=new int[counter];
        int counter2=0;
        for(int i=0; i<startTimes.length; i++)
        {
            if(startTimes[i]!=0 || i==0)
            {
                startTimes2[counter2]=startTimes[i];
                endTimes2[counter2]=endTimes[i];
                counter2++;
            }
        }
        System.out.println(Arrays.toString(startTimes2));
        System.out.println(Arrays.toString(endTimes2));
        int longestCont=0;
        int longestIdle=0;
        
        for(int i=0; i<startTimes2.length; i++)
        {
            longestCont=Math.max(endTimes2[i]-startTimes2[i], longestCont);
            if(i!=startTimes2.length-1)
            {
                longestIdle=Math.max(startTimes2[i+1]-endTimes2[i], longestIdle);
            }
        }
        out.println(longestCont + " " + longestIdle);
        out.close();
        System.exit(0);
        
        
        
        
    }
}