/*ID: johnath8
 LANG: JAVA
 TASK: friday
 */
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Scanner;
class friday
{
    public static void main (String [] args) throws IOException
    {
        
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        
        int totalSubtraction=0;
        int[] counter=new int[7];
        int[] leapYearIndex={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] yearIndex={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int n = Integer.parseInt(st.nextToken());
        //int n = 1;
        int dayOfTheWeek=0;
        int month=0;
        int year=0;
        int numberOfDays=(int)(365*(n)+Math.floor(n/4));
        
        if(n>=100)
        {
            numberOfDays+=1;
        }
        for(int i=14; i<numberOfDays; i+=0)
        {
            dayOfTheWeek=i%7;
            counter[dayOfTheWeek]+=1;
            
            //System.out.println(month + Arrays.toString(counter));
            if(year%4!=0 || year%100==0 && year!=100)
            {
                i+=yearIndex[month];
                month+=1;
                
               
                
                
            //System.out.println(month + "/" + year);
            }
            else
            {
                i+=leapYearIndex[month];
                month+=1;
                
                //System.out.println(month + "/" + year);
                //System.out.println(i-totalSubtraction);
                
            }
            if(month==11)
            {
                dayOfTheWeek=i%7;
                counter[dayOfTheWeek]+=1;
                if(year%4!=0 || year%100==0 && year!=100)
            {
                i+=yearIndex[month];
                
            }
            else
            {
                i+=leapYearIndex[month];
                          
            }
                
                //System.out.println(month + Arrays.toString(counter));
                month=0;
                year+=1;
            }
            //System.out.println("loop");
        }
        
        for(int i=0; i<6; i++)
        {
            out.print(counter[i] + " ");
            
        }
        
        out.print(counter[6]);
        out.print("\n");
        
        out.close();
        System.exit(0);
    }
}

