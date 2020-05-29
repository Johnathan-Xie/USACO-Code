
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class Writer
{
    
    static long startTime=System.currentTimeMillis();
    public static void permute(String str, int l, int r, ArrayList<String> output) 
    { 
        
        //System.out.println("str" + str);
        if (l == r) 
        {
            String outputString="";
            for(int i=0; i<str.length(); i++)
            {
                outputString+=str.charAt(i)+" ";
            }
            output.add(outputString);
        }
        else
        {
            for (int i = l; i <= r; i++) 
            {
                str = swap(str,l,i); 
                permute(str, l+1, r, output); 
                str = swap(str,l,i); 
            }
        }
    }
    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    }
    public static int findHighest(int x)
    {
        int highest=0;
        while(Math.pow(highest, 2)<x)
            highest++;
        return highest;
        
    }
    public static String flip(String s)
    {
        String temp="";
        for(int i=0; i<s.length(); i++)
        {
            temp+=s.charAt(s.length()-i);
        }
        return temp;
    }
    public static void setEqualTo(String[] a, String[] b)
    {
        for(int i=0; i<a.length; i++)
        {
            b[i]=a[i];
        }
    }
    public static void print2DArray(int[][] input, PrintWriter out) throws IOException
    {
        
        
        for(int i=0; i<input.length; i++)
        {
            for(int j=0; j<input[i].length; j++)
            {
                out.print(input[i][j]+ " ");
            }
            out.print("\n");
        }
    }
    public static void setArrayListEqualTo(ArrayList<String> a, ArrayList<String> b)
    {
        for(int i=0; i<a.size(); i++)
        {
            b.add(a.get(i));
        }
    }
    public static boolean isCycle(int[] xVals, int[] yVals, int[][] pairs)
    {
        int currentXpos;
        int currentYpos;
        int currentWormholeExited;
        
        for(int i=0; i<xVals.length; i++)
        {
            int counter=0;
            while(counter<xVals.length)
            {
            }
        }
        return false;
    }
    public static void printArrayList(ArrayList<Integer> n)
    {
        System.out.print("\n");
        for(int i=0; i<n.size(); i++)
        {
            System.out.print(n.get(i)+" ");
        }
        
    }
    public static boolean compare2DArray(int[][] input1, int[][] input2)
    {
        
        int[][] temp1=new int[input1.length][input1[0].length];
        int[][] temp2=new int[input1.length][input1[0].length];
        for(int i=0; i<temp1.length; i++)
        {
            if(input1[i][0]>input1[i][1])
            {
                temp1[i][0]=input1[i][1];
                temp1[i][1]=input1[i][0];
            }
            else
            {
                temp1[i][0]=input1[i][0];
                temp1[i][1]=input1[i][1];
            }
            if(input2[i][0]>input2[i][1])
            {
                temp2[i][0]=input2[i][1];
                temp2[i][1]=input2[i][0];
            }
            else
            {
                temp2[i][0]=input2[i][0];
                temp2[i][1]=input2[i][1];
            }
        }
        int[] index1=new int[input1.length];
        int[] index2=new int[input1.length];
        for(int i=0; i<input1.length; i++)
        {
            for(int j=0; j<input1.length; j++)
            {
                if(temp1[i][0]>temp1[j][0])
                    index1[i]++;
                if(temp2[i][0]>temp2[j][0])
                    index2[i]++;
            }
        }
        int[][] temp3=new int[input1.length][2];
        int[][] temp4=new int[input1.length][2];
        for(int i=0; i<temp3.length; i++)
        {
            temp3[index1[i]][0]=temp1[i][0];
            temp3[index1[i]][1]=temp1[i][1];
            temp4[index2[i]][0]=temp2[i][0];
            temp4[index2[i]][1]=temp2[i][1];
        }
        
        
        for(int i=0; i<temp3.length; i++)
        {
            for(int j=0; j<temp3[0].length; j++)
            {
                if(temp3[i][j]!=temp4[i][j])
                {
                    return false;
                }
            }
        }
        return true;
        
    }
    public static boolean contains(int[][] input1, ArrayList<int[][]> input2)
    {
        for(int i=0; i<input2.size(); i++)
        {
            if(compare2DArray(input1, input2.get(i)))
                return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException 
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole12.out")));
        BufferedReader f = new BufferedReader(new FileReader("writer.in"));
        int n = Integer.parseInt(f.readLine());
        int[] pairings=new int[n];
        ArrayList<String> output=new ArrayList<String>();
        ArrayList<String> doubleIndicator=new ArrayList<String>();
        String index="";
        
        for(int i=0; i<n/2; i++)
        {
            index+=Integer.toString(i);
        }
        int val=index.length();
        
        for(int i=0; i<Math.pow(2, val); i++)
        {
            String curr="";
            
            curr+=Integer.toBinaryString(i);
            while(curr.length()<val)
            {
                curr="0"+curr;
            }
            doubleIndicator.add(curr);
        }
        
        
        //System.out.println(doubleIndicator.get(j));
        //System.out.println(j);
        
        
        //System.out.println(output.size());
        
        ArrayList<int[][]> totalPairings=new ArrayList<int[][]>();
        
        for(int j=0; j<doubleIndicator.size(); j++)
        {
            System.out.println(j);
            String tempString1="";
            String tempString2="";
            
            
            for(int k=0; k<index.length(); k++)
            {
                int temp=Integer.parseInt(index.charAt(k)+ "");; 
                int tempOutput=Integer.parseInt(index.charAt(k)+ "");;
                
                if((doubleIndicator.get(j)).charAt(k)=='1')
                {
                    temp+=val;
                    
                }
                else
                {
                    tempOutput+=val;
                    
                }
                tempString1+=Integer.toString(temp);
                tempString2+=Integer.toString(tempOutput) + " ";
            }
            
            output.clear();
            permute(tempString1, 0, val-1, output);
            int count=output.size();
            for(int i=0; i<output.size(); i++)
            {
                int[][] tempPairings=new int[n/2][2];
                StringTokenizer temporary=new StringTokenizer(output.get(i));
                //System.out.println("output(i) " + output.get(i));
                StringTokenizer temporary2=new StringTokenizer(tempString2);
                
                for(int m=0; m<val; m++)
                {
                    tempPairings[m][0]=Integer.parseInt(temporary.nextToken());
                    tempPairings[m][1]=Integer.parseInt(temporary2.nextToken());
                }
                //System.out.println("tempPairings");
                
                
                if(contains(tempPairings, totalPairings)==false)
                {
                    totalPairings.add(tempPairings);
                }
            }
        }
       
        for(int o=0; o<totalPairings.size(); o++)
        {
            print2DArray(totalPairings.get(o), out);
        }
        out.close();
        System.exit(0);
    }
}