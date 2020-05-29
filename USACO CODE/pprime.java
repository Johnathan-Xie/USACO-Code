/*ID: johnath8
 LANG: JAVA
 TASK: pprime
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class pprime
{
    private static List palindromes=new ArrayList<Integer>();
    private static String[] starts = new String[]{
        "0","1","2","3","4","5","6","7","8","9",
            "00","11","22","33","44","55","66","77","88","99"};
    private static int low;
    private static int high;
    private static String highStr;
    
    public static void check(String s)
    {
        int num=Integer.parseInt(s);
        if(num%2==0)
            return;
        for(int i=3; i*i<=num; i+=2)
        {
            if(num%i==0)
                return;
        }
        if(num<low || num>high)
            return;
        if(s.charAt(0)==0)
            return;
        palindromes.add(num);
        
    }
    public static void createPalindrome(String s)
    {
        check(s);
        if(s.length()+2>highStr.length())
            return;
        for(int i=0; i<10; i++)
            createPalindrome(i+s+i);
    }
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        low=Integer.parseInt(st.nextToken());
        high=Integer.parseInt(st.nextToken());
        highStr=Integer.toString(high);
        ArrayList<Integer> previousPrimes=new ArrayList<Integer>();
        
        for(int i=0; i<starts.length; i++)
        {
            createPalindrome(starts[i]);
        }
        Collections.sort(palindromes);
        for(int i=0; i<palindromes.size(); i++)
        {
            out.println(palindromes.get(i));
        }
        
        out.close();
    }
}
