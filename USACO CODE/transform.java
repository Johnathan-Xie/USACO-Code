/*ID: johnath8
 LANG: JAVA
 TASK: transform
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class transform
{
    
    
    
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        int size=Integer.parseInt(f.readLine());
        char[][] before=new char[size][size];
        char[][] after=new char[size][size];
        for(int i=0; i<size; i++)
        {
            char[] curr=f.readLine().toCharArray();
            for(int j=0; j<size; j++)
            {
                before[i][j]=curr[j];
            }
        }
        for(int i=0; i<size; i++)
        {
            char[] curr=f.readLine().toCharArray();
            for(int j=0; j<size; j++)
            {
                after[i][j]=curr[j];
            }
        }
        int[] index=new int[8];
        for(int i=0; i<size; i++)
        {
            for(int j=0; j<size; j++)
            {
                if(before[i][j]==after[size-j-1][i])
                {
                    index[0]+=1;
                }
                if(before[i][j]==after[size-i-1][size-j-1])
                {
                    index[1]+=1;
                }
                if(before[i][j]==after[j][size-i-1])
                {
                    index[2]+=1;
                }
                if(before[i][j]==after[i][size-j-1])
                {
                    index[3]+=1;
                }
                if(before[i][j]==after[j][i])
                {
                    index[4]+=1;
                }
                if(before[i][j]==after[size-i-1][j])
                {
                    index[5]+=1;
                }
                if(before[i][j]==after[size-j-1][size-i-1])
                {
                    index[6]+=1;
                }
                if(before[i][j]==after[i][j])
                {
                    index[7]+=1;
                }
                System.out.println(index[4]);
                
                
                
            }
        }
        for(int i=0; i<8; i++)
        {
            if(index[i]==size*size)
            {
                if(i==4 || i==5 || i==6)
                {
                    out.println(5);
                    out.close();
                    System.exit(0);
                }
                else if(i==7)
                {
                    out.println(6);
                    out.close();
                    System.exit(0);
                }
                else
                {
                    out.println(i+1);
                    out.close();
                    System.exit(0);
                }
            }
        }
            out.println(7);
            out.close();
            System.exit(0);
            
        }
    }