/*ID: johnath8
 LANG: JAVA
 TASK: shopping
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class shopping
{
    static ArrayList<Integer> codes=new ArrayList<Integer>();
    static int[] prices;
    static int[] amounts;
    static int[] dp;
    static boolean[] skip;
    static ArrayList<int[]> offers=new ArrayList<int[]>();
    static boolean cont=true;
    static int b;
    public static int[] deHash(int index)
    {
        int[] out=new int[b];
        for(int i=0; i<b; i++)
        {
            out[i]=(int)((index%Math.pow(6, i+1))/Math.pow(6, i));
        }
        return out;
    }
    public static void process(int index)
    {
        skip[index]=true;
        int[] deIndex=deHash(index);
        
        for(int i=0; i<offers.size(); i++)
        {
            boolean less=true;
            for(int j=2; j<offers.get(i).length-1; j+=2)
            {
                
                if(offers.get(i)[j]+deIndex[offers.get(i)[j-1]]>amounts[offers.get(i)[j-1]])
                {
                    less=false;
                    break;
                }
            }
            if(less)
            {
                int newIndex=index;
                for(int k=1; k<offers.get(i).length-1; k+=2)
                {
                    //System.out.println((offers.get(i)[k+1]*Math.pow(6, offers.get(i)[k])));
                    newIndex+=(offers.get(i)[k+1]*Math.pow(6, offers.get(i)[k]));
                }
                dp[newIndex]=Math.min(dp[newIndex], dp[index]+offers.get(i)[offers.get(i).length-1]);
            }
        }
    }
    public static void main(String[] args) throws IOException 
    {
        //for each offer, place the value of the offer and any multiples or combos into
        //the dp with the cost as long as all values remain under the desired amount of each
        
        BufferedReader f = new BufferedReader(new FileReader("shopping.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
        int s=Integer.parseInt(f.readLine());
        
        
        for(int i=0; i<s; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            int n=Integer.parseInt(st.nextToken());
            int[] temp=new int[n*2+2];
            temp[0]=n;
            for(int j=1; j<n*2+2; j++) temp[j]=Integer.parseInt(st.nextToken());
            offers.add(temp);
        }
        
        b=Integer.parseInt(f.readLine());
        dp=new int[(int)(Math.pow(6, b))];
        skip=new boolean[(int)(Math.pow(6,b))];
        ArrayList<Integer> products=new ArrayList<Integer>();
        prices=new int[b];
        amounts=new int[b];
        for(int i=0; i<b; i++)
        {
            StringTokenizer st=new StringTokenizer(f.readLine());
            int code=Integer.parseInt(st.nextToken());
            int amount=Integer.parseInt(st.nextToken());
            int price=Integer.parseInt(st.nextToken());
            products.add((code<<17)+(price<<3)+(amount));
            
        }
        
        Collections.sort(products);
        
        for(int i=0; i<products.size(); i++)
        {
            codes.add(products.get(i)>>17);
            prices[i]=(products.get(i)%(1<<17))>>3;
            amounts[i]=(products.get(i)%(8));
        }
        int amountsIndex=0;
        for(int i=0; i<b; i++)
        {
            amountsIndex+=Math.pow(6, i)*amounts[i];
        }
        //System.out.println(Arrays.toString(prices));
        //System.out.println(Arrays.toString(amounts));
        for(int i=0; i<offers.size(); i++)
        {
            for(int j=1; j<offers.get(i).length-1; j+=2)
            {
                offers.get(i)[j]=codes.indexOf(offers.get(i)[j]);
            }
        }
        Arrays.fill(dp, 100000000);
        dp[0]=0;
        process(0);
        while(cont)
        {
            cont=false;
            for(int i=0; i<dp.length; i++)
            {
                if(dp[i]!=100000000 && !skip[i])
                {
                    cont=true;
                    process(i);
                }
            }
        }
        for(int i=0; i<dp.length; i++)
        {
            if(!skip[i]) continue;
            int[] temp=deHash(i);
            int extra=0;
            for(int j=0; j<b; j++)
            {
                extra+=prices[j]*(amounts[j]-temp[j]);
            }
            dp[amountsIndex]=Math.min(dp[amountsIndex], dp[i]+extra);
        }
        /*for(int i=0; i<dp.length; i++)
        {
            System.out.println(Arrays.toString(deHash(i)));
            System.out.println(dp[i]);
            
        }*/
        out.println(dp[amountsIndex]);
        out.close();
    }
}
