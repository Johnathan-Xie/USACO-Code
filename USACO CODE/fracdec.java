/*ID: johnath8
 LANG: JAVA
 TASK: fracdec
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class fracdec
{
    
    public static String fracToDec(int in1, int in2)
    { 
        long start=System.currentTimeMillis();
        String out="";
        StringBuilder outDecimal=new StringBuilder();
        int remainder=in1%in2;
        int whole=(int)((in1-remainder)/in2);
        out=out+Integer.toString(whole)+".";
        if(remainder==0)
        {
            return out+"0";
        }
        int[] seen=new int[in2];
        String repeater="";
        int startOfRepeater=0;
        for(int i=0; i<200000; i++)
        {
            seen[remainder]=i+1;
            int temp=remainder*10;
            remainder=temp%in2;
            //StringBuilder s=new StringBuilder();
            outDecimal.append((int)((temp)/in2));
            if(seen[remainder]!=0)
            {
                repeater=outDecimal.substring(seen[remainder]-1, i+1);
                startOfRepeater=seen[remainder]-1;
                break;
            }
            
            
            
            if(remainder==0)
                return out+outDecimal;
        }
        long finish=System.currentTimeMillis();
        System.out.println(finish-start);
        String finalOut=whole+"."+outDecimal.substring(0, startOfRepeater)+"("+repeater+")";
        return finalOut;
        
    }
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("fracdec.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
        String print=fracToDec(f.nextInt(), f.nextInt());
        int at=0;
        while(print.length()-at>76)
        {
            out.println(print.substring(at, at+76));
            at+=76;
        }
        if(print.length()-at!=0)
        {
            out.println(print.substring(at, print.length()));
        }
        //out.println(print);
        out.close();
    }
}
