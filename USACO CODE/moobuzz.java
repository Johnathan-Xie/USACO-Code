 /*ID: johnath8
 LANG: JAVA
 TASK: moobuzz
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class moobuzz
{
    public static int numbersSkipped(int in)
    {
        return (int)(Math.floor((in)/3))+(int)(Math.floor((in)/5))-(int)(Math.floor((in)/15));
    }
    public static int numbersNotSkipped(int in)
    {
        return in-((int)(Math.floor((in)/3))+(int)(Math.floor((in)/5))-(int)(Math.floor((in)/15)));
    }
    public static int bad(int in)
    {
        int counter1=0;
        int counter2=0;
        while(counter1!=in)
        {
            if(counter2%3!=0 && counter2%5!=0)
            {
                counter1++;
            }
            counter2++;
        }
        return counter2;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("moobuzz.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        int n=Integer.parseInt(f.readLine());
        
        for(int i=numbersSkipped(n)+n; i<Integer.MAX_VALUE; i+=0)
        {
            if(numbersNotSkipped(i)!=n || i%3==0 || i%5==0)
            {
                i+=n-numbersNotSkipped(i);
            }
            else
            {
                out.println(i);
                out.close();
                System.exit(0);
            }
            
        }
        
        out.close();
    }
}
