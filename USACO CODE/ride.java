/*ID: johnath8
 LANG: JAVA
 TASK: ride
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
class ride
{
    public static char[] index = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
        'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static int numberIndex(char k)
    {
        int hit=1;
        for(int i=0; i<26; i++)
        {
            if(k==index[i])
            {
                hit=i+1;
            }
            
        }
        return hit;
    }
    public static int number(char[] k)
    {
        int product=1;
        for(int i=0; i<k.length; i++)
        {
            product = product*(numberIndex(k[i]));
        }
        return product%47;
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String groupName=f.readLine();
        System.out.print(groupName);
        String shipName=f.readLine();
        System.out.print(shipName);
        char[] groupNameArray = groupName.toCharArray();
        char[] shipNameArray = shipName.toCharArray();
        if(number(groupNameArray)==number(shipNameArray))
        {
            out.println("GO");
        }
        else
        {
            out.println("STAY");
        }
        out.close();
        System.exit(0);
        
    }
    
} 
