/*ID: johnath8
 LANG: JAVA
 TASK: palsquare
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class palsquare
{
    /*public static int findHighest(int num, int base)
     {
     int counter=1;
     int total=1;
     while(total<num)
     {
     total*=base;
     counter++;
     }
     return counter;
     }*/
    public static boolean palindrome(String s)
    {
        boolean output=true;
        for(int i=0; i<Math.floor(s.length()); i++)
        {
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                output=false;
        }
        return output;
    }
    public static String flip(String s)
    {
        String temp="";
        for(int i=0; i<s.length(); i++)
        {
            temp+=s.charAt(s.length()-i-1);
        }
        return temp;
    }
    public static String baseConverter(int num, int base)
    {
        String output="";
        int leftover=num;
        int currentDigit=0;
        String[] index={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        while(leftover>0)
        {
            if((int)((leftover%Math.pow(base, currentDigit+1))/Math.pow(base, currentDigit))>9)
            {
                output+=index[(int)((leftover%Math.pow(base, currentDigit+1))/Math.pow(base, currentDigit))-10];
            }
            else
            {
                output+=(int)((leftover%Math.pow(base, currentDigit+1))/Math.pow(base, currentDigit));
            }
            leftover-=leftover%Math.pow(base, currentDigit+1);
            currentDigit+=1;
        }
        
        return flip(output);
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base=Integer.parseInt(f.readLine());
        
        for(int i=1; i<300; i++)
        {
            if(palindrome(baseConverter(i*i, base))==true)
            {
                out.println(baseConverter(i, base) + " " + baseConverter(i*i, base));

            }
        }
        out.close();
        System.exit(0);
    }
    
} 
