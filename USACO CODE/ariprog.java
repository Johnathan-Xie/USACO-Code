/*ID: johnath8
 LANG: JAVA
 TASK: ariprog
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class ariprog
{
    static long startTime=System.currentTimeMillis();
    public static boolean testIfInteger(double input)
    {
        
        if(Math.floor(input)==input)
        {
            return true;
        }
        return false;
    }
    public static boolean isBisquare(int num, int limit)
    {
        if(num==0) return true;
        for(int i=0; i<Math.sqrt(num); i++)
        {
            if(testIfInteger(Math.sqrt(num-i*i))==true && i*i<=limit && num-i*i<=limit)
            {
                return true;
            }
                   
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int lengthOfProg=Integer.parseInt(f.readLine());
        int upperBound=Integer.parseInt(f.readLine());
        int j=0;
        boolean found=false;
        boolean[] biSquares=new boolean[upperBound*upperBound*2+1];
        for(int i=0; i<=upperBound; i++)
        {
            for(int l=0; l<=upperBound; l++)
            {
                biSquares[i*i+l*l]=true;
            }
        }
        for(int i=1; i*(lengthOfProg-1)+j<=upperBound*upperBound*2; i++)
        {
            for(j=0; i*(lengthOfProg-1)+j<=2*upperBound*upperBound; j++)
            {
                
                for(int k=0; k<lengthOfProg; k++)
                {
                    if(biSquares[i*k+j]==false)
                        break;
                    if(k==lengthOfProg-1)
                    {
                        out.println(j + " " + i);
                        found=true;
                    }
                }
            }
            j=0;
        }
        if(found==false)
            out.println("NONE");
        out.close();
         long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
