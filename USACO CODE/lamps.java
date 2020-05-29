/*ID: johnath8
 LANG: JAVA
 TASK: lamps
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class lamps
{
    static int c;
    static int n;
    static ArrayList<int[]> total=new ArrayList<int[]>();
    static ArrayList<Integer> ones=new ArrayList<Integer>();
    static ArrayList<Integer> zeros=new ArrayList<Integer>();
    static boolean possible=false;
    public static void switchLamps(int in, int[] inArr)
    {
        if(in==3)
        {
            for(int i=0; i<n; i++)
            {
                inArr[i]=(inArr[i]+1)%2;
            }
        }
        else if(in==2)
        {
            for(int i=0; i<n; i+=2)
            {
                inArr[i]=(inArr[i]+1)%2;
            }
        }
        else if(in==1)
        {
            for(int i=1; i<n; i+=2)
            {
                inArr[i]=(inArr[i]+1)%2;
            }
        }
        else if(in==0)
        {
            for(int i=0; i<n; i+=3)
            {
                inArr[i]=(inArr[i]+1)%2;
            }
        }
    }
    public static void generate()
    {
        ArrayList<String> index=new ArrayList<String>();
        index.add("0000");
        index.add("0001");
        index.add("0010");
        index.add("0100");
        index.add("1000");
        index.add("0011");
        index.add("0101");
        index.add("1001");
        index.add("0110");
        index.add("1010");
        index.add("1100");
        index.add("1110");
        index.add("1101");
        index.add("1011");
        index.add("0111");
        index.add("1111");
        
        for(int i=0; i<16; i++)
        {
            String temp=index.get(i);
            while(temp.length()<4)
                temp="0"+temp;
            int[] arr=new int[n+1];
            for(int j=0; j<n; j++)
                arr[j]=1;
            int count=0;
            for(int j=0; j<temp.length(); j++)
            {
                if(temp.charAt(j)=='1')
                {
                    switchLamps(j, arr);
                    count++;
                }
            }
            arr[n]=count;
            total.add(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static ArrayList<String> sortTotal(ArrayList<int[]> in)
    {
        ArrayList<String> inToString=new ArrayList<String>();
        for(int i=0; i<in.size(); i++)
        {
            String temp="";
            for(int j=0; j<n; j++)
            {
                temp=temp+in.get(i)[j];
            }
            inToString.add(temp);
        }
        Collections.sort(inToString);
        return inToString;
    }
    
    public static void main(String[] args) throws IOException 
    {
        Scanner f = new Scanner(new File("lamps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        n=f.nextInt();
        c=f.nextInt();
        while(f.hasNextInt())
        {
            int temp=f.nextInt();
            if(temp==-1)
            {
                break;
            }
            ones.add(temp);
        }
        while(f.hasNextInt())
        {
            int temp=f.nextInt();
            if(temp==-1)
            {
                break;
            }
            zeros.add(temp);
        }
        //System.out.println(zeros.size());
        //System.out.println(ones.size());
        generate();
        
        ArrayList<int[]> totalFits=new ArrayList<int[]>();
        
        for(int i=0; i<total.size(); i++)
        {
            
            boolean fits=true;
            if((c-total.get(i)[n])%2!=0 || c-total.get(i)[n]<0)
                continue;
            
            for(int j=0; j<ones.size(); j++)
            {
                if(total.get(i)[ones.get(j)-1]!=1)
                    fits=false;
            }
            for(int k=0; k<zeros.size(); k++)
            {
                if(total.get(i)[zeros.get(k)-1]!=0)
                   fits=false; 
            }
            if(fits)
            {
                totalFits.add(total.get(i));
                possible=true;
            }
            
        }
        ArrayList<String> totalString=sortTotal(totalFits);
        for(int i=0; i<totalString.size(); i++)
        {
           out.println(totalString.get(i));
        }
        if(possible==false)
            out.println("IMPOSSIBLE");
        out.close();
    }
}
