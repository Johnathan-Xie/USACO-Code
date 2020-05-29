/*ID: johnath8
 LANG: JAVA
 TASK: contact
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class contact
{
    static long[][] total=new long[13][1<<12];
    static StringBuilder tran=new StringBuilder();
    
    static int min;
    static int max;
    static int n;
    public static void intake()
    {
        for(int i=min; i<=max; i++)//length;
        {
            for(int j=0; j<=tran.length()-i; j++)
            {
                total[i][Integer.parseInt(tran.substring(j, j+i), 2)]++;
            }
        }
    }
    /*public static ArrayList<Integer> specialSort(ArrayList<Integer> in)
     {
     
     ArrayList<String> out=new ArrayList<String>();
     
     while(in.size()!=0)
     {
     
     System.out.println("loop");
     int maxX=0;
     for(int i=0; i<in.size(); i++)
     {
     maxX=Math.max(maxX, in.get(i).length());
     }
     ArrayList<Integer> temp=new ArrayList<Integer>();
     for(int j=0; j<in.size(); j++)
     {
     if((in.get(j)).length()==maxX)
     {
     temp.add(Integer.parseInt(in.get(j), 2));
     }
     }
     Collections.sort(temp);
     for(int k=0; k<temp.size(); k++)
     {
     String outTemp=Integer.toBinaryString(temp.get(k));
     while(outTemp.length()<maxX);
     {
     outTemp="0"+outTemp;
     }
     in.remove(k);
     out.add(outTemp);
     }
     }
     return out;
     }*/
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("contact.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
        //scan String for substrings of length between the two min and maxes
        //convert those into int's and place them in an array
        //use a hashmap to store transmissions, occurences
        StringTokenizer st=new StringTokenizer(f.readLine());
        min=Integer.parseInt(st.nextToken()); max=Integer.parseInt(st.nextToken()); n=Integer.parseInt(st.nextToken());
        
        while(f.ready())
        {
            tran.append(f.readLine());
        }
        
        ArrayList<Long> sortedTotals=new ArrayList<Long>();
        
        
        intake();
        for(int i=min; i<=max; i++)
        {
            for(int j=0; j<4096; j++)
            {
                if(total[i][j]>0)
                {
                    sortedTotals.add((total[i][j]<<18)+(j<<5)+i);
                    System.out.println(((total[i][j]<<18)+(j<<5)+i)>>18);
                }
            }
        }
        
        for(int i=0; i<=max-min; i++)
        {
            Collections.sort(sortedTotals);
            Collections.reverse(sortedTotals);
        }
        
        for(int i=0; i<sortedTotals.size(); i++)
        {
            String tran=Long.toBinaryString(((sortedTotals.get(i)%(1<<18))>>5));
            while(tran.length()<(sortedTotals.get(i)%(1<<5)))
                tran="0"+tran;
            System.out.println(tran);
        }
        
        for(int i=0; i<n; i++) //number of frequeincies printed
        {
            ArrayList<Long> tempOut=new ArrayList<Long>();
            int curMax=(int)(sortedTotals.get(0)>>18);
            out.println(curMax);
            while((sortedTotals.get(0))>>18==curMax)
            {
                int l=(int)(sortedTotals.get(0)%(1<<5));
                int freq=(int)((sortedTotals.get(0)%(1<<18))>>5);
                int v=curMax;
                
                tempOut.add((long)(l<<27)+(freq<<14)+v);
                sortedTotals.remove(0);
                if(sortedTotals.size()==0)
                {
                    i=n;
                    break;
                }
            }
            Collections.sort(tempOut);
            for(int a=0; a<tempOut.size(); a++)
            {
                int l=(int)(tempOut.get(a)>>27);
                String freq=Long.toBinaryString(((tempOut.get(a))%(1<<27))>>14);
                
                while(freq.length()<l)
                    freq="0"+freq;
                out.print(freq);
                if((a%6!=5 && a!=tempOut.size()-1))
                    out.print(" ");
                else
                    out.print("\n");
                
            }
            
            
        }
        
        out.close();
        //System.exit(0);
    }
}
