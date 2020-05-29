/*ID: johnath8
 LANG: JAVA
 TASK: barn1
*/
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class barn1
{
    public static int findLowest(ArrayList<Integer> rates)
    {
        int farmer=0;
        int lowest=10000;
        for(int i=0; i<rates.size(); i+=2)
        {
            if(rates.get(i)<lowest)
            {
                lowest=rates.get(i);
                farmer=i;
                
            }
        }
        return farmer;
    }
    public static void setEqualTo(int[] a, int [] b)
    {
        for(int i=0; i<a.length; i++)
        {
            b[i]=a[i];
        }
    }
    public static void sort(int[] input)
    {
        int[] index=new int[input.length];
        int[] temp=new int[input.length];
        for(int i=0; i<input.length; i++)
        {
            for(int j=0; j<input.length; j++)
            {
                if(input[i]>input[j])
                {
                    index[i]++;
                }
            }
        }
        for(int i=0; i<input.length; i++)
        {
            temp[index[i]]=input[i];
        }
        setEqualTo(temp, input);
    }
    
    
    
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        int m=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] stalls=new int[c];
        for(int i=0; i<c; i++)
        {
            stalls[i]=Integer.parseInt(f.readLine());
        }
        Arrays.sort(stalls);
        ArrayList<Integer> gaps=new ArrayList<Integer>();
        for(int i=1; i<c; i++)
        {
            gaps.add(stalls[i]-stalls[i-1]-1);
        }
        Collections.sort(gaps);
        int boards=gaps.size()+1;
        int stallsCovered=boards;
        while(boards>m)
        {
            stallsCovered+=gaps.get(0);
            boards--;
            gaps.remove(0);
        }
        out.println(stallsCovered);
        out.close();
        System.exit(0);
    }
    
} 
