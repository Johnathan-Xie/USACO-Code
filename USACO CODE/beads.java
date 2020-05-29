/*ID: johnath8
 LANG: JAVA
 TASK: beads
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class beads
{
    public static int findChainLength(String s)
    {
        char[] sArray=s.toCharArray();
        int count=0;
        char indexChar=sArray[0];
        char currChar;
        boolean switchedColor=false;
        for(int i=0; i<sArray.length; i++)
        {
            //System.out.println(count);
            currChar=sArray[i];
            //System.out.println(currChar);
            //System.out.println(indexChar);
                
            if(currChar=='w')
            {
                count++;
            }
            else
            {
                if(indexChar=='w' || currChar==indexChar)
                {
                    indexChar=currChar;
                    count++;
                }
                else
                {
                    if(switchedColor)
                    {
                        break;
                        
                    }
                    else
                    {
                        switchedColor=true;
                        indexChar=currChar;
                        count++;
                    }
                    
                }
                
            }
        }
        return count;
    }
    
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int numberOfBeads=Integer.parseInt(f.readLine());
        String necklace=f.readLine();
        System.out.println(necklace);
        int currentLargest=0;
        
        
        for(int i=0; i<necklace.length(); i++)
        {
            System.out.println("i: " + i);
            System.out.println("largest: " + currentLargest);
            int currentValue=findChainLength(necklace.substring(i, necklace.length())+necklace.substring(0,i));
            System.out.println("current: " + currentValue);
            if(currentValue>currentLargest)
                currentLargest=currentValue;
            
            
        }
        
        
        out.println(currentLargest);
        out.close();
        System.exit(0);
            
    }
    
    
    
}
