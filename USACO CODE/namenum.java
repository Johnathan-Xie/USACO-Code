/*ID: johnath8
 LANG: JAVA
 TASK: namenum
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
import java.util.Iterator;
class namenum
{
    
    
    public static ArrayList<String> nameCheck(long input, ArrayList dict)
    {
        ArrayList<String> output=new ArrayList<String>();
        String[] indexChar={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "X", "Y"};
        int length = (int)(Math.log10(input)+1);
        for (int i=0; i<dict.size(); i++)
        {
            String a = (String)(dict.get(i));
            if(a.length()==length)
            {
                int[] possible=new int[length];
                for(int j=0; j<length; j++)
                {
                    
                    int currDigit=(int)((input%Math.pow(10, length-j))/Math.pow(10, length-j-1));
                    String curr=indexChar[(currDigit-2)*3] + indexChar[(currDigit-2)*3 + 1] + indexChar[(currDigit-2)*3 + 2];
                    
                    for(int k=0; k<3; k++)
                    {
                        if(curr.charAt(k)==a.charAt(j))
                        {
                            possible[j]=1;
                        }
                    }
                }
                for(int x=0; x<length; x++)
                {
                    if(possible[x]!=1)
                        break;
                    else if(x==length-1)
                        output.add(a);
                }
            }
        }
        
        return output;
        
    }
    
    public static void name() throws IOException
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        String s=in.readLine();
        long input=Long.parseLong(s);
        
        int length = (int)(Math.log10(input)+1);
        
        
        
        ArrayList<String> dict=new ArrayList<String>();
        
        while(br.ready()==true)
        {
            dict.add(br.readLine());
        }
        ArrayList<String> set=nameCheck(input, dict);
        
        int counter=0;
        for(int i=0; i<set.size(); i++)
        {
            out.println(set.get(i));
        }
        
        if(set.size()==0)
        {
            out.println("NONE");
        }
        out.close();
    }
    
    
    public static void main (String[] args) throws IOException
    {
        name();
        System.exit(0);
        
    }
}