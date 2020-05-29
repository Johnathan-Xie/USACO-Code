/*ID: johnath8
 LANG: JAVA
 TASK: wormhole
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class primeNumberGenerator
{
    private static long start=System.currentTimeMillis();
    public static void addIfPrime(int num, ArrayList<Integer> previousPrimes)
    {
        for(int i=0; previousPrimes.get(i)*previousPrimes.get(i)<=num; i++)
        {
            if(num%previousPrimes.get(i)==0)
                return;
        }
        previousPrimes.add(num);
    }
    /*public static void addIfPrime(int num, ArrayList<Integer> previousPrimes)
    {
        for(int i=0; i<previousPrimes.size(); i++)
        {
            if(num%previousPrimes.get(i)!=0 && num<previousPrimes.get(i)*previousPrimes.get(i))
            {
                previousPrimes.add(num);
                break;
            }
            if(num%previousPrimes.get(i)!=0)
                continue;
            else
                break;
        }
    }*/
    public static void main(String[] args) throws IOException 
    {
        int[] test={5,
            6, 7};
        BufferedReader f = new BufferedReader(new FileReader("prime.in"));
        BufferedReader line = new BufferedReader(new FileReader("prime.out"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prime.out")));
        ArrayList<Integer> previousPrimes=new ArrayList<Integer>();
        while(f.ready())
        {
            previousPrimes.add(Integer.parseInt(f.readLine()));
        }
        for(int i=previousPrimes.get(previousPrimes.size()-1)+2; i<10000000; i+=2)
        {
            addIfPrime(i, previousPrimes);
        }
        System.out.println("printing");
        System.out.println(previousPrimes.size());
        int curr=0;
        out.print("{");
        for(int i=0; i<previousPrimes.size(); i++)
        {
            out.print(previousPrimes.get(i)+", " );
            curr+=2+Math.log(previousPrimes.get(i));
            if(curr>40)
            {
                out.print("\n");
                curr=0;
            }
        }
        out.print("}");
        out.close();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        System.exit(0);
    }
}
