/*ID: johnath8
 LANG: JAVA
 TASK: zerosum
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class zerosum
{
   
    static ArrayList<String> answers=new ArrayList<String>();
    static int n;
    public static void test(String in)
    {
        
        String s=in.replace(" ", "");
        String curr="";
        int place=0;
        while(place<s.length())
        {
            if((s.charAt(place)+"").equals("+") || (s.charAt(place)+"").equals("-"))
                break;
            
            curr=curr+s.charAt(place);
            place++;
        }
        int counter=Integer.parseInt(curr);
        curr="";
        for(int i=place; i<s.length();)
        {
            char sign=s.charAt(i);
            i++;
            while(i<s.length())
            {
                
                if((s.charAt(i)=='+' || s.charAt(i)=='-'))
                {
                    break;
                }
                
                curr=curr+s.charAt(i);
                i++;
            }
            
            if(sign=='+')
                counter+=Integer.parseInt(curr);
            else
                counter-=Integer.parseInt(curr);
            curr="";
        }
        
        if(counter==0)
            answers.add(in);
    }
    public static void generate(String in, int num)
    {
        if(num==n)
        {
            test(in);
            return;
        }
        
        generate(in+"+"+Integer.toString(num+1), num+1);
        generate(in+"-"+Integer.toString(num+1), num+1);
        generate(in+" "+Integer.toString(num+1), num+1);
    }
        
    public static void main(String[] args) throws IOException 
    {
        Scanner in = new Scanner(new File("zerosum.in"));
        PrintWriter out = new PrintWriter(new File("zerosum.out"));
        n=in.nextInt();
        
        String base="1";
        generate(base, 1);
        Collections.sort(answers);
        for(int i=0; i<answers.size(); i++)
            out.println(answers.get(i));
        out.close();
        
        
        
        //System.exit(0);
    }
}
