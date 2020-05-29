/*ID: johnath8
 LANG: JAVA
 TASK: crypt1
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class crypt1
{
    public static boolean checkString(String a, String b)
    {
        for(int i=0; i<a.length(); i++)
        {
            if(b.contains("" + a.charAt(i))==false)
                return false;
        }
        return true;
    }
    
    
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int n=Integer.parseInt(f.readLine());
        String s=f.readLine();
        int count=0;
        s=s.replaceAll("\\s", "");
        for(int i=100; i<1000; i++)
        {
            if(checkString(Integer.toString(i), s)==false)
            {
                continue;
            }
            for(int j=10; j<100; j++)
            {
                if(checkString(Integer.toString(j), s)==false)
                {
                    continue;
                }
                String a=Integer.toString((j%10)*i);
                String b=Integer.toString((j-j%10)*i/10);
                String c=Integer.toString(j*i);
                if(a.length()==3 && b.length()==3 && c.length()==4
                       && checkString(a, s) && checkString(b, s) && checkString(c,s))
                    count++;
                    
                    
            }
        }
        out.println(count);
        out.close();
        System.exit(0);
    }
    
}
