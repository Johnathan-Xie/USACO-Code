/*ID: johnath8
 LANG: JAVA
 TASK: skidesign
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class skidesign
{
    
    public static int countCost(ArrayList<Integer> mountains, int startOfGap)
    {
        int cost=0;
        int lowBound=startOfGap;
        int highBound=startOfGap+17;
        System.out.println("lowBound " + lowBound);
        
        for(int i=0; i<mountains.size(); i++)
        {
            if(mountains.get(i)<startOfGap)
                cost+=Math.pow((startOfGap-mountains.get(i)),2);
            else if(mountains.get(i)>highBound)
                cost+=Math.pow((mountains.get(i)-highBound),2);
            
        }
       
        System.out.println(cost);
        return cost;
        
    }
    public static void main(String[] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int hills=Integer.parseInt(f.readLine());
        ArrayList<Integer> mountains=new ArrayList<Integer>();
        while(f.ready())
        {
            mountains.add(Integer.parseInt(f.readLine()));
        }
        Collections.sort(mountains);
        
        int lowest=mountains.get(0);
        int highest=mountains.get(mountains.size()-1);
        int lowestCost=Integer.MAX_VALUE;
        if((highest-lowest)<=17)
        {
            out.println(0);
            out.close();
            //System.exit(0);
        }
        for(int i=lowest; i<highest-16; i++)
        {
            lowestCost=Math.min(countCost(mountains, i), lowestCost);
        }
        out.println(lowestCost);
        out.close();
        //System.exit(0);
    }
}
