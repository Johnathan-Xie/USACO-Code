/*ID: johnath8
 LANG: JAVA
 TASK: hamming
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class hamming
{
    static int n;
    static int b;
    static int d;
    static ArrayList<Integer> totalSet=new ArrayList<Integer>();
    public static String intToBinary(int in)
    {
        String s=Integer.toBinaryString(in);
        while(s.length()!=b)
            s="0"+s;
        return s;
    }
    public static void checkAndRec(int in)
    {
        String temp1=intToBinary(in);
        
        for(int i=0; i<totalSet.size(); i++)
        {
            int dif=0;
            String temp2=intToBinary(totalSet.get(i));
            for(int j=0; j<b; j++)
            {
                if(temp1.charAt(j)!=temp2.charAt(j))
                {
                    dif++;
                }
            }
            if(dif<d)
                return;
        }
        
        totalSet.add(in);
    }
   
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        n=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        for(int i=0; totalSet.size()<n; i++)
        {
            checkAndRec(i);
        }
        for(int i=0; i<totalSet.size(); i++)
        {
            if(i%10==9)
            {
                out.print(totalSet.get(i));
                out.print("\n");
                i++;
                if(i==totalSet.size())
                    break;
            }
            if(i==totalSet.size()-1)
            {
                out.print(totalSet.get(i));
                out.print("\n");
                break;
            }
            out.print(totalSet.get(i)+" ");
            
        }
        //System.exit(0);
        out.close();
        
    }
}
