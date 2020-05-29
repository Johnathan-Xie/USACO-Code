/*ID: johnath8
 LANG: JAVA
 TASK: berries
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class berries
{
    //static Printer print;
    static int[] primeNumbers= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    
    static PrintWriter debug;
    public static int evaluate(int N, int K, ArrayList<Tree> trees)
    {
        ArrayList<Integer> baskets=new ArrayList<Integer>();
        for(int i=0; i<trees.size(); i++)
        {
            baskets.addAll(trees.get(i).values());
        }
        Collections.sort(baskets);
        
        
        
        int out=0;
        for(int i=baskets.size()-K/2-1; i>=Math.max(baskets.size()-K, 0); i--)
        {
            out+=(baskets.get(i));
        }
        
        return out;
    }
    /*public static boolean large(int N, int K, ArrayList<Tree> trees)
     {
     ArrayList<Integer> baskets=new ArrayList<Integer>();
     for(int i=0; i<trees.size(); i++)
     {
     baskets.addAll(trees.get(i).values());
     }
     Collections.sort(baskets);
     int lowHigh=0;
     if(baskets.size()>K/2+1)
     {
     lowHigh=baskets.get(baskets.size()-K/2-1);
     System.out.println("true");
     }
     
     return(trees.get(0).b/trees.get(0).split>lowHigh);
     }*/
    public static void main(String[] args) throws IOException 
    {
        
        BufferedReader f = new BufferedReader(new FileReader("berries.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        //debug=new PrintWriter(new BufferedWriter(new FileWriter("berries.debug")));
        StringTokenizer st=new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());// number of trees
        int K=Integer.parseInt(st.nextToken());// number of baskets
        StringTokenizer treesSt=new StringTokenizer(f.readLine());
        ArrayList<Integer> treesTemp=new ArrayList<Integer>();
        for(int i=0; i<N; i++) treesTemp.add(Integer.parseInt(treesSt.nextToken()));
        Collections.sort(treesTemp);
        Collections.reverse(treesTemp);
        ArrayList<Tree> trees=new ArrayList<Tree>();
        for(int i=0; i<Math.min(N, K); i++) trees.add(new Tree(treesTemp.get(treesTemp.size()-1-i), 1, i));
        
        Collections.sort(trees);
        /*
         boolean better=true;
         while(better)
         {
         better=false;
         for(int i=0; i<trees.size()-1; i++)
         {
         int prev=evaluate(N, K, trees);
         trees.get(i).split++;
         int temp=evaluate(N, K, trees);
         if(temp<=prev && !large(N, K, trees))
         {
         trees.get(i).split--;
         }
         else
         {
         better=true;
         Collections.sort(trees);
         break;
         }
         }
         ArrayList<Integer> baskets=new ArrayList<Integer>();
         for(int i=0; i<trees.size(); i++)
         {
         baskets.addAll(trees.get(i).values());
         }
         Collections.sort(baskets);
         for(Integer i:baskets)
         {
         System.out.print(i+" ");
         
         }
         System.out.print("\n");
         }
         ArrayList<Integer> temp=new ArrayList<Integer>();
         for(int i=0; i<trees.size(); i++)
         {
         temp.addAll(trees.get(i).values());
         }
         Collections.sort(temp);
         for(int i=0; i<temp.size(); i++)
         {
         debug.println(temp.get(i)+" "+i);
         }
         out.println(evaluate(N, K, trees));
         debug.close();
         out.close();*/
        int best=0;
        Collections.sort(trees);
        
        for(int b=1; b<treesTemp.get(0); b++)
        {
            ArrayList<Integer> mem=new ArrayList<Integer>();
            mem.addAll(treesTemp);
            int bucketCount=0;
            for(int i=0; i<treesTemp.size() && bucketCount!=K; i++)
            {
                bucketCount+=mem.get(i)/b;
                mem.set(i, mem.get(i)%b);
            }
            
            if(bucketCount>=K)
            {
                best=Math.max(best, b*(K/2));
            }
            
            else
            {
                Collections.sort(mem);
                Collections.reverse(mem);
                bucketCount-=K/2;
                int count=0;
                int i=0;
                for(i=bucketCount; i<K/2 && !mem.isEmpty(); i++)
                {
                    if(i==0)
                        count=0;
                    //debug.println(count+ " "+i);
                    count+=mem.get(0);
                    mem.remove(0);
                }
                if(i>0)
                    best=Math.max(best, (b*Math.max(bucketCount,0))+count);
            }
            //debug.println(best+ " "+ bucketCount);
            //debug.print("\n");
        }
        out.println(best);
        out.close();
        //debug.close();
    }
}
class Tree implements Comparable<Tree>
{
    public int b;
    public int split;
    public int ID;
    public Tree(int b, int split, int ID)
    {
        this.b=b;
        this.split=split;
        this.ID=ID;
    }
    public ArrayList<Integer> values()
    {
        int left=b%split;
        ArrayList<Integer> out=new ArrayList<Integer>();
        for(int i=0; i<split-left; i++) out.add(b/split);
        
        for(int i=0; i<left; i++) out.add(b/split+1);
        
        return out;
    }
    public String print()
    {
        return (b/split + " " + split +  " " +  ID);
    }
    @Override
    public int compareTo(Tree o)
    {
        if(o.b/o.split==this.b/this.split)
            return this.split- o.split;
        return o.b/o.split-this.b/this.split;
    }
}