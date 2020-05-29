/*ID: johnath8
 LANG: JAVA
 TASK: frac1
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class frac1
{
    public static boolean contains(ArrayList<Double> a, double in)
    {
        
        for(int i=0; i<a.size(); i++)
        {
            
            double temp=a.get(i);
            //System.out.println(temp+" "+in);
            if(temp==in)
                return true;
        }
        return false;
    }
    public static String[] sort(ArrayList<String> str, ArrayList<Double> val)
    {
        int[] index=new int[val.size()];
        String[] out=new String[str.size()];
        for(int i=0; i<val.size(); i++)
        {
            for(int j=0; j<val.size(); j++)
            {
                //System.out.println(i+" "+j);
                if(val.get(i)>val.get(j))
                    index[i]++;
            }
        }
        for(int i=0; i<index.length; i++)
        {
            out[index[i]]=str.get(i);
        }
        return out;
    }
    public static void main(String[] args) throws IOException 
    {
        
        Scanner f = new Scanner(new File("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int n=f.nextInt();
        ArrayList<String> frac=new ArrayList<String>();
        ArrayList<Double> fracValues=new ArrayList<Double>();
        frac.add("0/1");
        frac.add("1/1");
        fracValues.add(0.0);
        fracValues.add(1.0);
        for(double i=2; i<=n; i++)
        {
            
            for(double j=1; j<i; j++)
            {
                //System.out.println(j+"/"+i);
                //System.out.println(contains(fracValues, (double)(j/i)));
                if(!contains(fracValues, j/i))
                {
                    frac.add((int)j+"/"+(int)i);
                    fracValues.add((double)(j/i));
                }
            }
        }
        for(int i=0; i<frac.size(); i++)
        {
            //System.out.println(frac.get(i));
        }
        String[] fracSort=sort(frac, fracValues);
        for(int i=0; i<fracSort.length; i++)
        {
            out.println(fracSort[i]);
        }
        out.close();
        //System.exit(0);
    }
}
