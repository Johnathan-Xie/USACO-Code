/*ID: johnath8
 LANG: JAVA
 TASK: humble
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class humble
{

    
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("humble.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
        //Solution keep on finding humble numbers by adding to the j in j*the next prime
        int k=f.nextInt();
        int n=f.nextInt();
        int[] primes=new int[k];
        for(int i=0; i<k; i++) primes[i]=f.nextInt();
        int[] nums=new int[k];
        int[] humbles=new int[n+1];
        humbles[0]=1;
        for(int i=1; i<n+1; i++)
        {
            int best=Integer.MAX_VALUE;
            for(int j=0; j<k; j++)
            {
                while(primes[j]*humbles[nums[j]]<=humbles[i-1])
                {
                    nums[j]++;
                }
                best=Math.min(best, primes[j]*humbles[nums[j]]);
            }
            humbles[i]=best;
            //System.out.println(Arrays.toString(humbles));
        }
            out.println(humbles[n]);
            out.close();
        
        
    }
}
