/*ID: johnath8
 LANG: JAVA
 TASK: holstein
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class holstein
{
  
   static ArrayList<int[]> feeds=new ArrayList<int[]>();
   static int vita;
   static int num;
   static int[] requirements;
   static int[][] scoops;
   public static boolean feedsB(int[] feed)
   {
       
       int[] totalVita=new int[vita];
       for(int i=0; i<feed.length-1; i++)
       {
           if(feed[i]!=1)
               continue;
           for(int j=0; j<vita; j++)
           {
               //System.out.println(totalVita[j]);
               //System.out.println(scoops[i][j]);    
               totalVita[j]+=scoops[i][j];
           }
       }
       for(int i=0; i<totalVita.length; i++)
       {
           //System.out.println(Arrays.toString(requirements));
           if(totalVita[i]<requirements[i])
               return false;
       }
       return true;
   }
   public static ArrayList<Integer> testFeeds()
   {
       ArrayList<Integer> out=new ArrayList<Integer>();
       int lowestIndex=(int)(Math.pow(2,num)-1);
       for(int i=0; i<feeds.size(); i++)
       {
           if(feeds.get(i)[num]>feeds.get(lowestIndex)[num])
               continue;
           if(feedsB(feeds.get(i)))
           {
               lowestIndex=i;
           }
       }
       out.add(feeds.get(lowestIndex)[num]);
       int[] low=feeds.get(lowestIndex);
       for(int i=0; i<low.length-1; i++)
       {
           if(low[i]==1)
           {
               out.add(i+1);
           }
       }
       return out;
   }
   public static String intToBinary(int in)
   {
       String out=Integer.toBinaryString(in);
       //System.out.println(out);
       String outTemp="";
       //System.out.println(out.length() + " "+ num);
       while(out.length()!=num)
           out="0"+out;
       for(int i=num-1; i>=0; i--)
       {
           outTemp+=(out.charAt(i)+"");
       }
       return outTemp;
   }
   public static void makeFeeds()
   {
       for(int i=0; i<Math.pow(2, num); i++)
       {
           int[] tempAr=new int[num+1];
           int count=0;
           String temp=intToBinary(i);
           //System.out.println(temp);
           
           for(int j=0; j<num; j++)
           {
              if(Integer.parseInt(temp.charAt(j)+"")==1)
                  count++;
              tempAr[j]=Integer.parseInt(temp.charAt(j)+"");
           }
           tempAr[num]=count;
           feeds.add(tempAr);
       }
   }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        vita=Integer.parseInt(f.readLine());
        requirements=new int[vita];
        StringTokenizer st=new StringTokenizer(f.readLine());
        for(int i=0; i<vita; i++)
        {
            //System.out.println(Integer.parseInt(st.nextToken()));
            requirements[i]=Integer.parseInt(st.nextToken());
        }
        num=Integer.parseInt(f.readLine());
        scoops=new int[num][vita];
        for(int i=0; i<num; i++)
        {
            //System.out.print("\n");
            StringTokenizer temp=new StringTokenizer(f.readLine());
            for(int j=0; j<vita; j++)
            {
                
                scoops[i][j]=Integer.parseInt(temp.nextToken());
                //System.out.print(scoops[i][j]+" ");
            }
        }
        
        makeFeeds();
        for(int i=0; i<feeds.size(); i++)
        {
            //System.out.println(Arrays.toString(feeds.get(i)));
        }
        //System.out.println(feedsB(feeds.get(0)));
        ArrayList<Integer> printOut=testFeeds();
            for(int i=0; i<printOut.size()-1; i++)
                out.print(printOut.get(i) + " ");
            out.println(printOut.get(printOut.size()-1));
            out.close();
        
    }
}
