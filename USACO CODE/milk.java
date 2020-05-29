/*ID: johnath8
 LANG: JAVA
 TASK: milk
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Math;
class milk
{
    public static int findLowest(ArrayList<Integer> rates)
    {
        int farmer=0;
        int lowest=10000;
        for(int i=0; i<rates.size(); i+=2)
        {
            if(rates.get(i)<lowest)
            {
                lowest=rates.get(i);
                farmer=i;
                
            }
        }
        return farmer;
    }
    
    
    
    public static void main (String[] args) throws IOException {
        /*PrintWriter in = new PrintWriter(new BufferedWriter(new FileWriter("milk.in")));
        in.write("100 5");
        in.write("5 20");
        in.write("9 40");
        in.write("3 10");
        in.write("8 80");
        in.write("6 30");
       */




        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int units=Integer.parseInt(st.nextToken());
        int numberOfFarmers=Integer.parseInt(st.nextToken());
        ArrayList<Integer> rates=new ArrayList<Integer>();
        int bill=0;
        for(int i=0; i<numberOfFarmers; i++)
        {
            
            StringTokenizer temp = new StringTokenizer(f.readLine());
            rates.add(Integer.parseInt(temp.nextToken()));
            rates.add(Integer.parseInt(temp.nextToken()));
            
        }
        while(units>0)
        {
            
            int currentFarmer=findLowest(rates);
            int rate=rates.get(currentFarmer);
            int stock=rates.get(currentFarmer+1);
            
            if(units>stock)
            {
                units-=stock;
                bill+=stock*rate;
                rates.remove(currentFarmer);
                rates.remove(currentFarmer);
            }
            else
            {
                bill+=units*rate;
                units=0;
                
                rates.remove(currentFarmer);
                rates.remove(currentFarmer);
            }
        }
        out.println(bill);
        out.close();
        System.exit(0);
    }
    
} 
