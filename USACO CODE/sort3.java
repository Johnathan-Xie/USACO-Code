/*ID: johnath8
 LANG: JAVA
 TASK: sort3
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class sort3
{
    public static ArrayList<Integer> counter=new ArrayList<Integer>();
    private static int[] sorted;
    private static int[] counted;
    public static int[] unsort;
    
    public static int[] count(int[] unsort)
    {
        int[] out=new int[3];
        for(int i=0; i<unsort.length; i++)
        {
            
            out[unsort[i]-1]++;
        }
        int temp=out[1];
        out[1]=out[0];
        out[2]=out[1]+temp;
        out[0]=0;
        
        return out;
    }
    public static void goodSwaps(int[] in)
    {
        int[] counted=count(in);
        for(int i=0; i<in.length; i++)
        {
            if(in[i]!=sorted[i])
            {
                for(int j=counted[in[i]-1]; j<in.length; j++)
                {
                    if(in[i]==1 && j==counted[1])
                        break;
                    if(in[i]==2 && j==counted[2])
                        break;
                    if(in[j]==sorted[i])
                    {
                        swap(in, i, j);
                        break;
                    }
                }
            }
        }
    }
    public static void badSwaps(int [] in)
    {
        double counter1=0;
        for(int i=0; i<in.length; i++)
        {
            if(in[i]!=sorted[i])
                counter1++;
        }
        counter1=counter1/3;
        counter1*=2;
        for(int i=0; i<counter1; i++)
        {
            counter.add(1);
        }
    }
    public static void swap(int[] in, int index1, int index2)
    {
        System.out.println(Arrays.toString(unsort));
        System.out.println(counter.size());
        int temp=in[index2];
        in[index2]=in[index1];
        in[index1]=temp;
        counter.add(1);
    }
    
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int n=f.nextInt();
        unsort=new int[n];
        
        sorted=new int[n];
        
        for(int i=0; i<n; i++)
            unsort[i]=f.nextInt();
        System.out.println(Arrays.toString(unsort));
        int counter1=0;
        counted=count(unsort);
        int[] countedDif=new int[3];
        countedDif[0]=counted[1];
        countedDif[1]=counted[2]-counted[1];
        countedDif[2]=sorted.length-counted[2];
        System.out.println(Arrays.toString(countedDif));
        for(int i=0; i<counted.length; i++)
        {
            for(int j=0; j<countedDif[i]; j++)
            {
                sorted[counter1]=i+1;
                counter1++;
            }
        }
        goodSwaps(unsort);
        System.out.println(counter.size());
        badSwaps(unsort);
        System.out.println(counter.size());
        System.out.println(Arrays.toString(unsort));
        out.println(counter.size());
        out.close();
            
    }
}
