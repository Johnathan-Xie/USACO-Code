/*ID: johnath8
 LANG: JAVA
 TASK: loan
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class loan
{
    public static boolean valid(long N, long K, long M, long X)
    {
        long paid=0;
        while(paid<N && K>0)
        {
            long Y=(N-paid)/X;
            //System.out.println(paid);
            if(Y<M)
            {
                paid+=M*K;
                return paid>=N;
            }
            long maxSame=N-X*Y;
            long numOfDays=(maxSame-paid)/Y+1;
            paid+=Y*numOfDays;
            K-=numOfDays;
        }
      return paid>=N;
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        long N=Long.parseLong(st.nextToken()); //amount of milk owed
        long K=Long.parseLong(st.nextToken()); //Number of Days
        long M=Long.parseLong(st.nextToken()); //minimum number of milk given each day
        
        long lhs=1;
        long rhs=K;
        long X=(lhs+rhs)/2;
        HashSet<Long> seen=new HashSet<Long>();
        while(lhs<rhs)
        {
            //System.out.println(lhs+"-"+rhs);
             X=(lhs+rhs+1)/2;
            if(valid(N, K, M, X))
            {
                lhs=X;
            }
            else
                rhs=X-1;
           
        }
        out.println(lhs);
        out.close();
    }
}
