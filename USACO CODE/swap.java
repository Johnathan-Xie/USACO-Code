/*ID: johnath8
 LANG: JAVA
 TASK: swap
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
/*class swap
 {
 static int N;
 static int M;
 static int K;
 static int[] indicator;
 static int[] temp;
 public static void swap(int one, int two, ArrayList<Integer> arr)
 {
 int hold=arr.get(one);
 arr.set(one, arr.get(two));
 arr.set(two, hold);
 }
 public static void main(String[] args) throws IOException 
 {
 BufferedReader f=new BufferedReader(new FileReader(new File("swap.in")));
 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
 StringTokenizer st=new StringTokenizer(f.readLine());
 N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());
 ArrayList<Integer> indicator=new ArrayList<>();
 ArrayList<Integer> temp=new ArrayList<>();
 for(int i=0; i<N; i++)
 {
 indicator.add(i);
 temp.add(i);
 }
 for(int i=0; i<M; i++)
 {
 StringTokenizer swapSt=new StringTokenizer(f.readLine());
 int from=Integer.parseInt(swapSt.nextToken())-1;
 int to=Integer.parseInt(swapSt.nextToken())-1;
 for(int j=0; j<(to-from)/2+1; j++)
 {
 swap(j+from, to-j, indicator);
 }
 }
 ArrayList<ArrayList<Integer>> order=new ArrayList<ArrayList<Integer>>();
 HashSet<ArrayList<Integer>> seen=new HashSet<ArrayList<Integer>>();
 for(int i=0; i<K; i++)
 {
 ArrayList<Integer> newPos=new ArrayList<Integer>();
 for(int j=0; j<indicator.size(); j++)
 {
 newPos.add(temp.get(indicator.get(j)));
 }
 
 //StringBuilder s=new StringBuilder();
 
 if(seen.contains(newPos))
 {
 ArrayList finalS=order.get(K%order.size());
 for(int a=0; a<finalS.size(); a++)
 {
 out.println(finalS.get(a));
 }
 }
 order.add(newPos);
 seen.add(newPos);
 temp=newPos;
 }
 for(int i=0; i<N; i++)
 out.println(temp.get(i)+1);
 out.close();
 }
 }*/

class swap
{
    static int N;
    static int M;
    static int K;
    static int[] indicator;
    static int[] temp;
    public static void swap(int one, int two, int[] arr)
    {
        int hold=arr[one];
        arr[one]=arr[two];
        arr[two]=hold;
    }
    /*public static int computeCycle()
    {
        int[] cycles=new int[N];
        for(int i=0; i<indicator.length; i++)
        {
            int temp=indicator[i];
            int counter=1;
            while(temp!=i)
            {
                counter++;
                temp=indicator[temp];
            }
            cycles[i]=counter;
        }
        
        ArrayList<Integer> total=new ArrayList<Integer>();
        ArrayList<Integer> seen=new ArrayList<Integer>();
        seen.add(1);
        for(int i=0; i<cycles.length; i++)
        {
            if(!seen.contains(cycles[i]))
            {
                total.add(cycles[i]);
                for(int a=0; a<seen.size(); a++)
                {
                    int temp=a*cycles[i];
                    if(!seen.contains(temp))
                        seen.add(temp);
                }
            }
        }
        int out=1;
        for(Integer i:total)
            out*=i;
        return out;
    }*/
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f=new BufferedReader(new FileReader(new File("swap.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        N=Integer.parseInt(st.nextToken()); M=Integer.parseInt(st.nextToken()); K=Integer.parseInt(st.nextToken());
        indicator=new int[N];
        temp=new int[N];
        int[] original=new int[N];
        for(int i=0; i<N; i++)
        {
            indicator[i]=i;
            temp[i]=i;
            original[i]=i;
        }
        for(int i=0; i<M; i++)
        {
            StringTokenizer swapSt=new StringTokenizer(f.readLine());
            int from=Integer.parseInt(swapSt.nextToken())-1;
            int to=Integer.parseInt(swapSt.nextToken())-1;
            for(int j=0; j<(to-from)/2+1; j++)
            {
                swap(j+from, to-j, indicator);
            }
        }
        System.out.println(Arrays.toString(indicator));
       
        int cycleValue=0;
        boolean detected=false;
        String swapString=Integer.toBinaryString(K);
        ArrayList<int[]> swaps=new ArrayList<int[]>();
        swaps.add(indicator);
        for(int i=0; i<swapString.length()-1; i++)
        {
            int[] newSwap=new int[N];
            int[] previous=swaps.get(swaps.size()-1);
            for(int j=0; j<N; j++)
            {
                newSwap[j]=previous[previous[j]];
            }
            swaps.add(newSwap);
        }
        StringBuilder swapStringReverse=new StringBuilder();
        for(int i=0; i<swapString.length(); i++) swapStringReverse.append(swapString.charAt(swapString.length()-1-i)+"");
        System.out.println(swapStringReverse);
        for(int i=0; i<swapStringReverse.length(); i++)
        {
            if(swapStringReverse.charAt(i)=='0')
                continue;
            System.out.println(i);
            int[] newPos=new int[N];
            int[] currIndicator=swaps.get(i);
            for(int j=0; j<indicator.length; j++)
            {
                newPos[j]=temp[currIndicator[j]];
            }
            //System.out.println(Arrays.toString(newPos));
            temp=newPos;
        }
        
        for(int i=0; i<N; i++)
            out.println(temp[i]+1);
        out.close();
    }
}
