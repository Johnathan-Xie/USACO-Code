/*ID: johnath8
 LANG: JAVA
 TASK: castle
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class castle
{
   
    
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int n=f.nextInt();
        ArrayList frac=new ArrayList<String>();
        ArrayList fracValues=new ArrayList<double>();
        frac.add("0/1");
        frac.add("1/1");
        frac1.add(0);
        frac1.add(1);
        for(int i=2; i<n; i++)
        {
            for(int j=0; j<i-1; j++)
            {
                if(!fracValues.contains(i/j))
                {
                    frac.add(j+"/"+i);
                    fracValues.add(i/j);
                }
            }
        }
            
        out.close();
        System.exit(0);
    }
}
