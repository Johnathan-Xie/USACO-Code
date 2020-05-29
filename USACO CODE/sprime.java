/*ID: johnath8
 LANG: JAVA
 TASK: sprime
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class sprime
{
    private static List sPrimes=new ArrayList<Integer>();
    private static String[] starts = new String[]{"2", "3", "5", "7"};
    private static int n;
    
    public static boolean prime(String s)
    {
        int num=Integer.parseInt(s);
        if(num%2==0 && num!=2)
            return false;
        for(int i=3; i*i<=num; i+=2)
        {
            if(num%i==0)
                return false;
        }
        return true;
        
    }
    public static void createSP(String s)
    {
        int num=Integer.parseInt(s);
        if(prime(s)==false)
        {
            return;
        }
        else if(s.length()<n)
        {
            for(int i=0; i<10; i++)
                createSP(s+i);
        }
        if(s.length()==n)
            sPrimes.add(num);
        
    }
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        n=Integer.parseInt(f.readLine());
        for(int i=0; i<starts.length; i++)
        {
            createSP(starts[i]);
        }
        Collections.sort(sPrimes);
        for(int i=0; i<sPrimes.size(); i++)
        {
            out.println(sPrimes.get(i));
        }
        
        out.close();
    }
}
