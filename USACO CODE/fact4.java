/*ID: johnath8
 LANG: JAVA
 TASK: fact4
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class fact4
{
    
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("fact4.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
        int in=f.nextInt();
        //int in=7;
        int counter=1;
        int numOf2s=0;
        int numOf5s=0;
        for(int i=1; i<=in; i++)
        {
            int temp=i;
            
            if(i%2==0)
            {
                while(temp%2==0)
                {
                    numOf2s++;
                    temp/=2;
                }
                
            }
            if(i%5==0)
            {
                while(temp%5==0)
                {
                    numOf5s++;
                    temp/=5;
                }
                
            }
            
           
            counter=(counter*temp)%10;
            
            //System.out.println(counter);
            
        }
        for(int i=numOf5s; i<numOf2s; i++)
            counter=(2*counter)%10;
        //System.out.println(counter);
        out.println(counter);
        out.close();
    }
}
