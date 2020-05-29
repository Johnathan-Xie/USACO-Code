/*ID: johnath8
 LANG: JAVA
 TASK: runround
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class runround
{
    public static boolean uniqueDigits(String in)
    {
        for(int i=0; i<in.length(); i++)
        {
            for(int j=i+1; j<in.length(); j++)
            {
                if(in.charAt(i)==in.charAt(j))
                    return false;
            }
        }
        return true;
    }
    public static boolean tryRun(int in)
    {
        
        String inStr=Integer.toString(in);
        
        boolean[] visited=new boolean[inStr.length()];
        int currentStarter=0;
        for(int i=0; i<inStr.length(); i++)
        {
            
            if(visited[(currentStarter+Integer.parseInt(inStr.charAt(currentStarter)+""))%inStr.length()]==true)
                return false;
            visited[(currentStarter+Integer.parseInt(inStr.charAt(currentStarter)+""))%inStr.length()]=true;
            currentStarter=(currentStarter+Integer.parseInt(inStr.charAt(currentStarter)+""))%inStr.length();
            //System.out.println(currentStarter);
            //System.out.println(Arrays.toString(visited));
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        int n=Integer.parseInt(f.readLine());
        for(int i=n+1; i<Integer.MAX_VALUE; i++)
        {
            String inStr=Integer.toString(i);
            if(uniqueDigits(inStr))
            {
                System.out.println(i);
                if(tryRun(i))
                {
                    out.println(i);
                    out.close();
                    System.exit(0);
                }
            }
        }
        
        
        
        
    }
}
