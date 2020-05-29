/*ID: johnath8
 LANG: JAVA
 TASK: dualpal
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class dualpal
{
    
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
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int amount=Integer.parseInt(st.nextToken());
        System.out.println(amount);
        int min=Integer.parseInt(st.nextToken());
        System.out.println(min);
        int counter1=0;
        int counter3=min;
        while(counter1<amount)
        {
            counter3++;
            int counter2=0;
            for(int i=2; i<11; i++)
            {
                if(palindrome(baseConverter(counter3, i))==true)
                    counter2++;
                if(counter2==2)
                {
                    counter1++;
                    out.println(counter3);
                    break;
                }
            }
        }
        
        out.close();
        System.exit(0);
    }
    
} 
